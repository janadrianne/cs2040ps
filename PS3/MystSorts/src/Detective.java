import java.util.*;

class Detective {
    private Random rng = new Random();

    // You might want this function
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
     * Test whether the sorter works correctly by sorting *one* input of the
     * specified size and checking if it is sorted.
     */


    boolean checkSorted(ISort sorter, int size) {
        // create array of given-size
        Integer[] newArray = new Integer[size];

        // fill array with random numbers
        for (int i = 0; i< size; i++) {
            newArray[i] = rng.nextInt();
        }

        // sort array using given sorter
        sorter.sort(newArray);

        for (int i = 0; i < size; i++) {
            if (i > 0) {
                if (newArray[i-1] > newArray[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Question 1.2
     *
     * Test whether a given sort is stable by testing it on *one* input of the
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

    public static void main(String[] args) {

    }



}

