import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public void method(){
        double t1 = .5;
        double t2 = .75;
        double std1 = Math.sqrt(t1*(1-t1)), std2 = Math.sqrt(t2*1-t2);
        double z = (t1-t2) / (Math.sqrt(std1) + Math.sqrt(Math.exp(std2)));
      //  System.out.println(CDF_Normal.norp(z));
    }

    public static void main(String[] args) throws IOException {
        // write your code here
        Scanner txt = new Scanner(new File("RegularSeasonCompactResults.txt"));
        String tx[] = new String[10000];
        int maxIndex = -1;


        while (txt.hasNext()) {
            maxIndex++;
            tx[maxIndex] = txt.nextLine();

        }

        //txt.close();
        for (int i = 0; i <= maxIndex; i++) {
            System.out.println(tx[i]);
        }
        System.out.println("Enter team 1");
        Scanner input = new Scanner(System.in);
        String str = txt.next();
         String one = input.next();


    }
}
