import java.io.*;
import java.util.*;

public class MySpeedDemon {
    // Your code
//    HashMap<Integer, ArrayList<HashMap<Integer, ArrayList<Character>>>> map = new HashMap<>();

    int name = 0;

    public static int speedMatch(String dbfilename) {
        // Your code yas
        int result = 0;
        try {
            // open file
            FileReader readFile = new FileReader(dbfilename);
            BufferedReader bufferedFile = new BufferedReader(readFile);
            String lineOne = bufferedFile.readLine();
            // BufferedReader outputs type String -> need to convert to Integer
            int lineCount = Integer.parseInt(lineOne);

            // read each line
            List<String> input = new ArrayList<String>();
            for (int i = 0; i < lineCount; i++) {
                String currString = bufferedFile.readLine();
                input.add(currString);
            }

            // create new HashMap
            HashMap<Integer, ArrayList<HashMap<Integer, ArrayList<Character>>>> map = new HashMap<>();
//            HashMap<String, ArrayList<String>> map = new HashMap<>();

            //
            for (String str : input) {
                HashMap<Integer, ArrayList<Character>> lineMap = new HashMap<>();
                for (int i = 0; i < str.length(); i++) {
                    Integer key = (int) str.charAt(i);
                    if (lineMap.get(key) != null) {
                        lineMap.get(key).add(str.charAt(i));
                    } else {
                        ArrayList<Character> newChar = new ArrayList<>();
                        newChar.add(str.charAt(i));
                        lineMap.put(key, newChar);
                    }
                }

                // try using arraylist of array list instead of hashmap of array list see faster
                Integer mKey = lineMap.hashCode();
                if (map.get(mKey) != null) {
                    map.get(mKey).add(lineMap);
                } else {
                    ArrayList<HashMap<Integer, ArrayList<Character>>> arrMap = new ArrayList<>();
                    arrMap.add(lineMap);
                    map.put(mKey, arrMap);
                }
            }
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
//            }

            for (Integer i : map.keySet()) {
                List<HashMap<Integer, ArrayList<Character>>> values = map.get(i);
                if (values.size() > 1) {
                    int k = values.size();
                    result += k * (k - 1) / 2;
                }
            }
//            for (String i : map.keySet()) {
//                List<String> values = map.get(i);
//                if (values.size() >1) {
//                    int k = values.size();
//                    result += k * (k-1)/2;
//                }
//            }


        } catch (IOException e) {
        }
        return result;
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
//    }

    private int a, b;
    private int[] array;

    @Override
    public int hashCode() {
        return (31 * (31 * Arrays.hashCode(array) + a)) + b;

        // create a HashMap mapping a key string to a linked list of strings
        // convert word to sorted and lowercased
        // what is new line character
    }
}



