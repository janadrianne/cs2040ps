import java.util.ArrayList;
import java.util.Collections;

class Clownculator {

    private HerbertLog log;

    private boolean isSalaryCalculated;
    private long totalSalary;

    private int numJobs;
    private ArrayList<Integer> jobStartingMinutes;
    private ArrayList<Integer> jobDurations;

    public Clownculator(String filename) {
        log = new HerbertLog(filename);

        isSalaryCalculated = false;
        totalSalary = -1;

        numJobs = -1;
        jobStartingMinutes = new ArrayList<>();
        jobDurations = new ArrayList<>();
    }

    public long calculateSalary() {
        // Check if salary has already been calculated.
        if (isSalaryCalculated) {
            return totalSalary;
        }

        // Initialize
        int currentMinute = 0;
        long output = 0;

        // Loop until the entire log has been checked
        while (currentMinute < log.numMinutes()) {
            // Get first minute of current job
            int firstMinute = currentMinute;
            Record firstRecord = log.get(firstMinute);
            String name = firstRecord.getName();

            // Get last minute of current job
            int lastMinute = getLastMinuteOfName(name, firstMinute, log.numMinutes() - 1);
            Record lastRecord = log.get(lastMinute);

            // Update output
            output += lastRecord.getWages();

            // Record the details of the current job
            jobStartingMinutes.add(firstMinute);
            jobDurations.add(lastMinute - firstMinute + 1);

            // Go to the next job
            currentMinute = lastMinute + 1;
        }

        // Save total salary and total number of jobs
        totalSalary = output;
        numJobs = jobStartingMinutes.size();
        isSalaryCalculated = true;

        return totalSalary;
    }

    public long calculateMinimumWork(long goalIncome) {
        // Check if calculateSalary() has been called before
        if (!isSalaryCalculated) {
            // Call it once. We need the details of the jobs.
            calculateSalary();
        }

        // The answer, if it exists, is at most equal to the longest job
        int durationOfLongestJob = Collections.max(jobDurations);

        // Initialize binary search
        int bestAnswerSoFar = -1;
        int low = 0;
        int high = durationOfLongestJob;

        while (low <= high) {
            // Get middle index
            int mid = low + (high - low) / 2;

            // Test middle index
            boolean isEnough = testIfEnoughMinutes(goalIncome, mid);
            if (isEnough) {
                // This is enough for Herbert to earn his goal income!
                // Update the best answer so far
                bestAnswerSoFar = mid;
            }

            // Update bounds
            if (isEnough) {
                // Herbert can earn his goal income by working "mid" minutes. Maybe he can work even less.
                // A better answer may lie in [low, mid - 1].
                high = mid - 1;
            } else {
                // Herbert is too lazy to earn his goal income. He needs to work more.
                // A better answer may lie in [mid + 1, high]
                low = mid + 1;
            }
        }

        return bestAnswerSoFar;
    }

    /**
     * Returns the last occurrence of the specified name in the log between the specified lower and upper limits
     * inclusive.
     *
     * @param name the name to search
     * @param lowerLimit the lower limit of the search, inclusive
     * @param upperLimit the upper limit of the search, inclusive
     * @return the last minute in which the specified name appears
     */
    private int getLastMinuteOfName(String name, int lowerLimit, int upperLimit) {
        // Initialize binary search
        int bestAnswerSoFar = -1;
        int low = lowerLimit;
        int high = upperLimit;

        while (low <= high) {
            // Get middle index
            int mid = low + (high - low) / 2;

            // Test middle index
            Record midRecord = log.get(mid);
            if (midRecord.getName().equals(name)) {
                // The name matches!
                // Update the best answer so far
                bestAnswerSoFar = mid;
            }

            // Update bounds
            if (midRecord.getName().equals(name)) {
                // The middle record matches the name to be searched.
                // A better answer may lie in [mid + 1, high].
                low = mid + 1;
            } else {
                // The middle record does not match the name to be searched.
                // The answer may lie in [low, mid - 1]
                high = mid - 1;
            }
        }

        return bestAnswerSoFar;
    }

    /**
     * Returns true if Herbert can earn his goal income by working the specified number of minutes per employer.
     * 
     * @param goalIncome Herbert's goal income
     * @param minutesToWork the number of minutes Herbert will work per employer at most
     * @return true if Herbert can earn his goal income by working the specified number of minutes
     */
    private boolean testIfEnoughMinutes(long goalIncome, int minutesToWork) {
        if (minutesToWork == 0) {
            // Herbert is lazy AF. No work == No money
            return goalIncome <= 0;
        }

        // Initialize
        long totalIncome = 0;

        // Iterate through all the jobs
        for (int jobIndex = 0; jobIndex < numJobs; ++jobIndex) {
            // Get the minute when this job starts
            int jobStartingMinute = jobStartingMinutes.get(jobIndex);
            int jobDuration = jobDurations.get(jobIndex);

            // Calculate the minute when Herbert stops working for this employer.
            // Either the job ends, or Herbert has worked enough. Take whichever is earlier
            int jobEndingMinute = jobStartingMinute + Math.min(jobDuration, minutesToWork) - 1;
            Record lastRecord = log.get(jobEndingMinute);

            // Update total income
            totalIncome += lastRecord.getWages();
        }

        // Is it enough?
        return totalIncome >= goalIncome;
    }
}
