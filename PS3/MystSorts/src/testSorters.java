public class testSorters {
    public static void main(String[] args) {
        Detective d = new Detective();
        int size = 100;
        int runs = 100;
        StopWatch timer = new StopWatch();
        ISort sorter = null;
        float timerA = 0;
        float timerB = 0;
        float timerC = 0;
        float timerD = 0;
        float timerE = 0;
        float timerF = 0;
        float timerG = 0;
        float timerH = 0;
        float timerI = 0;
        int sd = 0;
        int ids = 0;
        int gs = 0;


        for (int i = 1; i <= runs; i++) {
            /////////////
            // SorterA //
            sorter = new SorterA();
            timer.start();
            boolean test = d.checkSorted(sorter, size);
            boolean testStability = d.isStable(sorter, size);
            timer.stop();
            timerA += timer.getTime();
            if (!test) {
                System.out.println("Results: A NOT SORTED CONSISTENTLY");
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
            timer.stop();
            timerB += timer.getTime();
            if (!test) {
                System.out.println("Results: B NOT SORTED CONSISTENTLY");
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
            timer.stop();
            timerC += timer.getTime();
            if (!test) {
                System.out.println("Results: C NOT SORTED CONSISTENTLY");
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
            timer.stop();
            timerD += timer.getTime();
            if (!test) {
                System.out.println("Results: D NOT SORTED CONSISTENTLY");
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
            timer.stop();
            timerE += timer.getTime();
            if (!test) {
                System.out.println("Results: E NOT SORTED CONSISTENTLY");
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
            timer.stop();
            timerF += timer.getTime();
            if (!test) {
                System.out.println("Results: F NOT SORTED CONSISTENTLY");
            }
            /////////////
            // SorterDivine //
            sorter = new DivineInterventionSort();
            timer.reset();
            timer.start();
            test = d.checkSorted(sorter, size);
            timer.stop();
            timerG += timer.getTime();
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
            timerH += timer.getTime();
            if (!test) {
                ids += 1;
            }
 /*           System.out.println("[SorterF]");
            System.out.println("Results: " + test);
            System.out.println("That took: " + timer.getTime());
            System.out.println(); */
            /////////////
            // GambleSort //
            sorter = new GamblerSort();
            timer.reset();
            timer.start();
            test = d.checkSorted(sorter, size);
            timer.stop();
            timerI += timer.getTime();
            if (!test) {
                gs += 1;
            }

        }
        System.out.println("MEAN TIMINGS OF SORTERS");
        System.out.println();
        System.out.println("timerA:" + timerA / runs);
        System.out.println("timerB:" + timerB / runs);
        System.out.println("timerC:" + timerC / runs);
        System.out.println("timerD:" + timerD / runs);
        System.out.println("timerE:" + timerE / runs);
        System.out.println("timerF:" + timerF / runs);
        System.out.println("timerG:" + timerG / runs + "number of fails:" + sd + "/100");
        System.out.println("timerH:" + timerH / runs + "number of fails:" + ids + "/100");
        System.out.println("timerI:" + timerI / runs + "number of fails:" + gs + "/100");
    }
}
