import java.io.*;
import java.util.*;

public class Main {
    public static double p(double t1, double t2){
        double std1 = Math.sqrt(t1*(1-t1)), std2 = Math.sqrt(t2*1-t2);
        double z = (t1-t2) / (Math.sqrt(std1) + Math.sqrt(Math.exp(std2)));
        return CDF_Normal.normp(z);
    }

    public static void main(String[] args) throws IOException {
        // write your code here
        Scanner txt = new Scanner(new File("RegularSeasonCompactResults.txt"));
        ArrayList<String> tm = new ArrayList();
        ArrayList<Double> wl = new ArrayList();
        Scanner test = new Scanner(new File("teams.txt"));
        /*for(int i = 0; test.hasNextLine(); i++){
            String s = test.nextLine();
            String[] a = s.split("\\s+");
            System.out.print(a[2] + ":\t");
            String[] b = a[4].split("-");
            int g = Integer.parseInt(b[0]) + Integer.parseInt(b[1]);
            double winloss = Double.parseDouble(b[0]) / (double) g;
            System.out.println(winloss);
        }*/
        while(test.hasNextLine()){
            String s[] = test.nextLine().split(",");
            tm.add(s[0]);
            wl.add(Double.parseDouble(s[1]));

        }
      //  for(int i = 0; i < tm.size(); i++){
        //    for(int u = i + 1; u < tm.size(); u++){
         //       System.out.println(tm.get(i) + "\t" + tm.get(u) + ":\t" + p(wl.get(i), wl.get(u)));
         //   }
       // }
        for(int i = 0; i < tm.size(); i = i + 2) {
            System.out.println(tm.get(i) + "\t" + tm.get(i + 1) + ":\t" + p(wl.get(i), wl.get(i + 1)));

            System.out.println();
            if(p(wl.get(i), wl.get(i + 1)) > .5){
                   System.out.println(tm.get(i) +"\tWins!");

               }
            else if(p(wl.get(i), wl.get(i + 1)) == .5){
                System.out.println("'Tis a tie!");
            }
            else{
                System.out.println(tm.get(i + 1) + "\tWins!");

            }
            System.out.println();

        }
        /*int maxIndex = -1;


        while (txt.hasNext()) {
            maxIndex++;
            tx.add(txt.nextLine();

        }

        //txt.close();
        for (int i = 0; i <= maxIndex; i++) {
            System.out.println(tx.get(i));
        }
        System.out.println("Enter team 1");
        Scanner input = new Scanner(System.in);
        String str = txt.next();
        String one = input.next();
        */

    }
}
