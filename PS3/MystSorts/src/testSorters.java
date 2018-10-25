public class testSorters {
    public static void main(String[] args) {
        Detective d = new Detective();
        int size = 100000;
        int runs = 1;
        StopWatch timer = new StopWatch();
        ISort sorter = null;
        float[] timers = new float[6];
        int[] failsSort = new int[6];
        int[] failsStable = new int[6];
        for (int i = 0; i < timers.length; i++) {
            timers[i] = 0;
            failsSort[i] = 0;
            failsStable[i] =0;
        }
        for (int i = 1; i <= runs; i++) {
            /////////////
            // SorterA //
            sorter = new SorterA();
            timer.start();
            boolean test = d.checkSorted(sorter, size);
            boolean testStability = d.isStable(sorter, size);
            timer.stop();
            timers[0] += timer.getTime();
            if (!test) {
                failsSort[0] += 1;
            }

            if (!testStability) {
                failsStable[0] += 1;
            }
/*            System.out.println("[SorterA]");
            System.out.println("Results: " + test);
            System.out.println("That took: " + timer.getTime());
            System.out.println();*/

            /////////////
            // SorterB //
            sorter = new SorterB();
            timer.reset();
            timer.start();
            test = d.checkSorted(sorter, size);
            testStability = d.isStable(sorter, size);
            timer.stop();
            timers[1] += timer.getTime();
            if (!test) {
                failsSort[1] += 1;
            }

            if (!testStability) {
                failsStable[1] += 1;
            }
/*            System.out.println("[SorterB]");
            System.out.println("Results: " + test);
            System.out.println("That took: " + timer.getTime());
            System.out.println();*/

            /////////////
            // SorterC //
            sorter = new SorterC();
            timer.reset();
            timer.start();
            test = d.checkSorted(sorter, size);
            testStability = d.isStable(sorter, size);
            timer.stop();
            timers[2] += timer.getTime();
            if (!test) {
                failsSort[2] += 1;
            }

            if (!testStability) {
                failsStable[2] += 1;
            }
/*            System.out.println("[SorterC]");
            System.out.println("Results: " + test);
            System.out.println("That took: " + timer.getTime());
            System.out.println();*/

            /////////////
            // SorterD //
            sorter = new SorterD();
            timer.reset();
            timer.start();
            test = d.checkSorted(sorter, size);
            testStability = d.isStable(sorter, size);
            timer.stop();
            timers[3] += timer.getTime();
            if (!test) {
                failsSort[3] += 1;
            }

            if (!testStability) {
                failsStable[3] += 1;
            }
/*            System.out.println("[SorterD]");
            System.out.println("Results: " + test);
            System.out.println("That took: " + timer.getTime());
            System.out.println();*/

            /////////////
            // SorterE //
            sorter = new SorterE();
            timer.reset();
            timer.start();
            test = d.checkSorted(sorter, size);
            testStability = d.isStable(sorter, size);
            timer.stop();
            timers[4] += timer.getTime();
            if (!test) {
                failsSort[4] += 1;
            }

            if (!testStability) {
                failsStable[4] += 1;
            }
/*            System.out.println("[SorterE]");
            System.out.println("Results: " + test);
            System.out.println("That took: " + timer.getTime());
            System.out.println();*/

            /////////////
            // SorterF //
            sorter = new SorterF();
            timer.reset();
            timer.start();
            test = d.checkSorted(sorter, size);
            testStability = d.isStable(sorter, size);
            timer.stop();
            timers[5] += timer.getTime();
            if (!test) {
                failsSort[5] += 1;
            }

            if (!testStability) {
                failsStable[5] += 1;
            }
            /*/////////////
            // SorterDivine //
            sorter = new DivineInterventionSort();
            timer.reset();
            timer.start();
            test = d.checkSorted(sorter, size);
            timer.stop();
//            timerG += timer.getTime();
            if (!test) {
                sd += 1;
            }

            /////////////
            // IntelligentDesignSort //
            sorter = new IntelligentDesignSort();
            timer.reset();
            timer.start();
            test = d.checkSorted(sorter, size);
            timer.stop();
//            timerH += timer.getTime();
            if (!test) {
                ids += 1;
            }
 *//*           System.out.println("[SorterF]");
            System.out.println("Results: " + test);
            System.out.println("That took: " + timer.getTime());
            System.out.println(); *//*
            /////////////
            // GambleSort //
            sorter = new GamblerSort();
            timer.reset();
            timer.start();
            test = d.checkSorted(sorter, size);
            timer.stop();
//            timerI += timer.getTime();
            if (!test) {
                gs += 1;
            }*/

        }
        System.out.println("MEAN TIMINGS OF SORTERS");
        System.out.println();
        System.out.println("timerA:" + timers[0] / runs);
        System.out.println("timerB:" + timers[1] / runs);
        System.out.println("timerC:" + timers[2] / runs);
        System.out.println("timerD:" + timers[3] / runs);
        System.out.println("timerE:" + timers[4] / runs);
        System.out.println("timerF:" + timers[5] / runs);

        System.out.println();
        System.out.println("MEAN FAILS");
        System.out.println("A FAILS:" + "SORT "+ failsSort[0] + "/200 " + "STABLE " + failsStable[0] + "/200");
        System.out.println("B FAILS:" + "SORT "+failsSort[1] + "/200 " + "STABLE " + failsStable[1] + "/200");
        System.out.println("C FAILS:" + "SORT "+failsSort[2] + "/200 " + "STABLE " + failsStable[2] + "/200");
        System.out.println("D FAILS:" + "SORT "+failsSort[3] + "/200 " + "STABLE " + failsStable[3] + "/200");
        System.out.println("E FAILS:" + "SORT "+failsSort[4] + "/200 " + "STABLE " + failsStable[4] + "/200");
        System.out.println("F FAILS:" + "SORT "+failsSort[5] + "/200 " + "STABLE " + failsStable[5] + "/200");
//        System.out.println("timerG:" + timerG / runs + "number of fails:" + sd + "/100");
//        System.out.println("timerH:" + timerH / runs + "number of fails:" + ids  + "/100");
//        System.out.println("timerI:" + timerI / runs + "number of fails:" + gs + "/100");
    }
}


/*
sorting

quick sort not stable
bubble sort stable
selection sort not stable
insertion sort stable
merge sort stable
nota sort not stable

*/

class Detective {
    private Random rng = new Random();

    // Fisher-Yates shuffle, randomly permutes an array of length n
    // in O(n) time
    private <T> void shuffle(T[] array){
        if(array==null || array.length < 2){
            return;
        }

        for(int i=1;i<array.length;i++){
            int a = rng.nextInt(i+1);
            T temp   = array[a];
            array[a] = array[i];
            array[i] = temp;
        }
    }
    /**
     * Question 1.1
     *
     * Test whether the sorter works correctly by sorting one input of the
     * specified size and checking if it is sorted.
     */
    boolean checkSorted(ISort sorter, int size) {
        // create array of given-size
        Integer[] newArray = new Integer[size];

        // fill array with random numbers
        for (int i = 0; i< size; i++) {
            newArray[i] = rng.nextInt();
        }
        // attemp to sort array using given sorter
        sorter.sort(newArray);
        // check if array is sorted
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                if (newArray[i-1] > newArray[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
class Detective {
    private Random rng = new Random();

    // Fisher-Yates shuffle, randomly permutes an array of length n
    // in O(n) time
    private <T> void shuffle(T[] array){
        if(array==null || array.length < 2){
            return;
        }

        for(int i=1;i<array.length;i++){
            int a = rng.nextInt(i+1);
            T temp   = array[a];
            array[a] = array[i];
            array[i] = temp;
        }
    }
    /**
     * Question 1.2
     *
     * Test whether a given sort is stable by testing it on one input of the
     * specified size. You do not need to check if it is sorted!
     */
    boolean isStable(ISort sorter, int size) {
        // create an array with duplicates
        Pair[] newArray = new Pair[size];
        for (int i = 0; i < size; i++) {
            newArray[i] = new Pair(rng.nextInt(size/2), i);
        }
        // sort array using given sorter
        sorter.sort(newArray);

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (newArray[i].first == newArray[j].first) {
                    Pair first = newArray[i];
                    Pair second = newArray[j];
                    if (first.second > second.second) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
