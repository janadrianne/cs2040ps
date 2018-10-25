import java.util.ArrayList;

class Clownculator {

    HerbertLog log;

    Clownculator(String filename) {
        log = new HerbertLog(filename);
    }

/*
 * ----- Qn 1.1 (20 marks) ------
 */


    /**
     * Performs the calculation of salary
     */
    public int calculateSalary() { 
        int total = 0;
        int numRows = log.numMinutes();

         for(int row = 0; row < numRows; row++) {
             if(isFinalWage(row)) {
                 total += getJobWage(row);
             }
         }
         System.out.println("myNumGets:" + log.numGets());
        return total;
}

    // return final wages for each job
    public int getJobWage(int row) {
        Record r = log.get(row);

        return r.getWages();
    }

    // check for last wage
    public boolean isFinalWage(int row) {
        Record r = log.get(row);
        Record nr = null;
        String name = r.getName();
        String nName = "";
        long lastRow = log.numMinutes() - 1;

        // look for next record
        // if is not last record
        if(row == lastRow) {
            return true;
        } else {
            nr = log.get(row+1);
            nName = nr.getName();
            // compare names

            if(!name.equals(nName)) {
                return true;
            }
        }

        return false;
    }


/*
 * ----- Qn 1.2 (10 marks) ------
 */

    /**
     *  Calculates the minimum number of minutes per job
     *  needed to reach the target income
     */
    public long calculateMinimumWork(long goalIncome){
        // find first row and last row of each employer
        int firstRow = 0;
        long totalIncome = 0; long prevTotalIncome = 0;
        int n = 0;
        ArrayList<Record> employerRecords = null;
        ArrayList<ArrayList<Record>> employers = new ArrayList<ArrayList<Record>>();

        while(totalIncome < goalIncome) {
            n++;
            prevTotalIncome = totalIncome;
            firstRow = 0;
            totalIncome = 0;
            // creating arrayList of arrayList of employers
            for(int row = 0; row < log.numMinutes(); row++) {
                if(isFinalWage(row)) {
                    employerRecords = getEmployerRecords(firstRow, row);
                    employers.add(employerRecords);
                    firstRow = row + 1;

                    totalIncome += calculateNthWage(n, employerRecords);
                }
            }
            if(prevTotalIncome == totalIncome){
                break;
            }

            }
        if(totalIncome >= goalIncome) {
            return n;
        }
        System.out.println("myNumGets:" + log.numGets());
        return -1;
    }

    // get nth wage of each employer
    // consider if n is larger than employer list
    public long calculateNthWage(int n, ArrayList<Record> employer) {
        long result = 0;
        int lastRecord = employer.size();

        // if employer does not have n wages
        // then get last wage
        if(n > lastRecord) {
            result = employer.get(lastRecord-1).getWages();
        } else {
            result = employer.get(n-1).getWages();
        }
        return result;
    }

    // building employer ArrayList<Record>
    public ArrayList<Record> getEmployerRecords(int firstRow, int lastRow) {
        ArrayList<Record> result = new ArrayList<Record>();
        for(int rowCount = firstRow; rowCount <= lastRow; rowCount++) {
            result.add(log.get(rowCount));
        }
        return result;
    }

    // find biggest n in all employers
    public int getMaxSizeRecords(ArrayList<ArrayList<Record>> records) {
        int max = 0;

        for (int i = 0; i > records.size(); i++){
            ArrayList<Record> employer = records.get(i);
            if (employer.size() > max) {
                max = employer.size();
            }
        }
        return max;
    }
}