public class MyString {
    private String data;
    private int length;
    private static int[] primeArray =  {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
        73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173,
        179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, // 60
        283, 293, 307, 311, 313,  // 0 - 64

        317, 331, 337, 347, 349, 353, 359,
        367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433,
        439, 443, 449, 457, 461, 463, 467, // 65 - 90 [caps alphabets]

        479, 487, 491, 499, 503,
        509, // 91 - 96

        317, 331, 337, 347, 349, 353, 359,
        367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433,
        439, 443, 449, 457, 461, 463, 467,  // 97 - 122

        619, 631, 641, 643, 647}; // 123 - 127

    // constructor
    public MyString(String data) {
        this.data = data.toLowerCase();
        length = data.length();
    }

    // getters and setters
    public String getData() {
        return data;
    }

    public int getLength() {
        return length;
    }

    @Override
    public int hashCode() {
        int result = 0;
        char[] charArray = this.getData().toCharArray();
        for (char c: charArray) {
            result += primeArray[(int) c];
        }
        return result;
    }

//    @Override
//    public int hashCode() {
//        // assumption: data is always lowercase (see: constructor)
//        int prime = 31;
//        int result = 17;
//        int hash = 31;
//        char[] charArray = this.getData().toCharArray();
//        for (char c: charArray) {
//            hash += ((int)c)*((int)c)*((int)c);
//            result = prime * result + (hash ^ (hash>>32));
//            if ((int)c /2 == 0) {
//                result *=29;
//            }
//        }
//        result = prime * result + hash%599;
//        return result;
//    }

    @Override
    public boolean equals(Object otherString) {
        if (!(otherString instanceof MyString)) {
            return false;
        }

        MyString str = (MyString) otherString;
        if (otherString == this) {
            return true;
        }
        return str.getLength() == this.getLength();
    }
}

