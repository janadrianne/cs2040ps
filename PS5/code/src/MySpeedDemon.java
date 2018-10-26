import java.io.*;
import java.util.*;

public class MySpeedDemon {

    public static int speedMatch(String dbfilename) {
        // Your code yas
        int result = 0;
        // create new HashMap
        HashMap<MyString, ArrayList<MyString>> map = new HashMap<>();
        try {
            // open file
            FileReader readFile = new FileReader(dbfilename);
            BufferedReader bufferedFile = new BufferedReader(readFile);
            String firstLine = bufferedFile.readLine();
            // BufferedReader outputs type String -> need to convert to Integer
            int lineCount = Integer.parseInt(firstLine);
            for (int lineIndex = 0; lineIndex < lineCount; lineIndex++) {
                MyString currString = new MyString(bufferedFile.readLine());
                if (map.get(currString) != null) {
                    map.get(currString).add(currString);
                } else {
                    ArrayList<MyString> newString = new ArrayList<>();
                    newString.add(currString);
                    map.put(currString, newString);
                }
            }
            // calculate anagrams
            for (MyString i : map.keySet()) {
                ArrayList<MyString> values = map.get(i);
                int k = values.size();
                if (k > 1) {
                    result += k * (k - 1) / 2;
                }
            }
        } catch (IOException e) {
        }
        map.clear();
        return result;
    }
}



