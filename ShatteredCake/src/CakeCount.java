import java.util.Scanner;


public class CakeCount {

    public static void main(String args[]) {
        int w = 0;
        int n = 0;
        String c = "";
        int SubV = 0; //area of small cake
        int result = 0;
        int area = 0;
// store first line as width
// second line as pieces
                // third line = for loop
        Scanner sc = new Scanner(System.in);

        System.out.println("Calculating length of cake");

        System.out.println("Enter information ");
        w = sc.nextInt();
        n = sc.nextInt();
        sc.nextLine();
        c = sc.nextLine();

        while(n > 0)  {
            //int firstInt = Integer.parseInt(c.substring(0,1));
            //int secondInt = Integer.parseInt(c.substring(2,3));
            //debug
            //System.out.println("c: " + c + " firstInt: " +  firstInt + " secondInt: " + secondInt);
            /*String[] processed = c.split(" ");
            int firstInt = Integer.parseInt(processed[0]);
            int secondInt = Integer.parseInt(processed[1]);*/

            int firstInt = Integer.valueOf((c.split(" "))[0]);
            int secondInt = Integer.valueOf((c.split(" "))[1]);
            SubV = firstInt * secondInt;
            area = area + SubV;
            c = sc.nextLine();
            n = n - 1;
        }

        result = area/w;
        System.out.println(result);

    }

}

