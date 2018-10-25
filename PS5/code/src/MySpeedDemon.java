import java.io.*;
import java.util.*;

public class MySpeedDemon {
    // Your code
    public static int speedMatch(String dbfilename) {
        // Your code yas
        int result = 0;
        try{
            // open file
            FileReader readFile = new FileReader(dbfilename);
            BufferedReader bufferedFile = new BufferedReader(readFile);
            String lineOne = bufferedFile.readLine();
            // BufferedReader outputs type String -> need to convert to Integer
            int lineCount = Integer.parseInt(lineOne);

            // keep track of number of equivalent
            int[] wordCount= new int[lineCount];
            Arrays.fill(wordCount,0);

            // read each line
            List<String> input = new ArrayList<String>();
            for (int i = 0; i < lineCount; i++) {
                String currString = bufferedFile.readLine();
                input.add(currString);
            }

            // create new HashMap
            HashMap<String, ArrayList<String>> map = new HashMap<>();

            // for each word, sort the word and use the sorted word as key for map
            for (String str : input) {
//                char[] wordArray = str.toCharArray();
//                Arrays.sort(wordArray);
//                String key = new String(wordArray).toLowerCase();
//                if (map.get(key) != null) {
//                    // if anagram alrd exists, add to list
//                    map.get(key).add(str.toLowerCase());
//                } else {
//                    // if word not yet in map, create ArrayList for future anagrams to be added
//                    ArrayList<String> anagramList = new ArrayList<>();
//                    anagramList.add(str);
//                    map.put(key, anagramList);
//                }
                HashMap<String,>
            }

            for (String i : map.keySet()) {
                List<String> values = map.get(i);
                if (values.size() >1) {
                    int k = values.size();
                    result += k * (k-1)/2;
                }
            }





        } catch (IOException e) {
        }
        return result + '/n';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof String)) {
//            return false;
//        }
//
//        if (this == o) {
//            return true;
//        }
//
//        return true;
//    }

//    @Override
//    public int hashCode() {
//
//        return result;
//    }

    // create a HashMap mapping a key string to a linked list of strings
    // convert word to sorted and lowercased
    // what is new line character
}



