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
        ArrayList<String> RO32TM = new ArrayList<>();
        ArrayList<Double> RO32NUM = new ArrayList<>();
        ArrayList<String> RO16TM = new ArrayList<>();
        ArrayList<Double> RO16NUM = new ArrayList<>();
        ArrayList<String> RO8TM = new ArrayList<>();
        ArrayList<Double> RO8NUM = new ArrayList<>();
        ArrayList<String> RO4TM = new ArrayList<>();
        ArrayList<Double> RO4NUM = new ArrayList<>();
        ArrayList<String> RO2TM = new ArrayList<>();
        ArrayList<Double> RO2NUM = new ArrayList<>();
        ArrayList<String> FinalTM = new ArrayList<>();
        ArrayList<Double> FinalNum = new ArrayList<>();

        Scanner test = new Scanner(new File("teams.txt"));
        System.out.println("ROUND OF 64");
        System.out.println();
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
            if(p(wl.get(i), wl.get(i + 1)) > .5){
                   System.out.println(tm.get(i) +"\tWins!");
                RO32TM.add(tm.get(i));
                RO32NUM.add(wl.get(i));

               }
            else if(p(wl.get(i), wl.get(i + 1)) == .5){
                System.out.println("'Tis a tie!");
            }
            else{
                System.out.println(tm.get(i + 1) + "\tWins!");
                RO32TM.add(tm.get(i+1));
                RO32NUM.add(wl.get(i+1));


            }
            System.out.println();

        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("ROUND OF 32");
        for(int i = 0; i < RO32TM.size(); i = i + 2) {
            System.out.println(RO32TM.get(i) + "\t" + RO32TM.get(i + 1) + ":\t" + p(RO32NUM.get(i), RO32NUM.get(i + 1)));
            if(p(RO32NUM.get(i), RO32NUM.get(i + 1)) > .5){
                System.out.println(RO32TM.get(i) +"\tWins!");
                RO16TM.add(RO32TM.get(i));
                RO16NUM.add(RO32NUM.get(i));

            }
            else if(p(RO32NUM.get(i), RO32NUM.get(i + 1)) == .5){
                System.out.println("'Tis a tie!");
            }
            else{
                System.out.println(RO32TM.get(i + 1) + "\tWins!");
                RO16TM.add(RO32TM.get(i+1));
                RO16NUM.add(RO32NUM.get(i+1));
//

            }
            System.out.println();

        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("ROUND OF 16 (Sweet 16)");
        for(int i = 0; i < RO16TM.size(); i = i + 2) {
            System.out.println(RO16TM.get(i) + "\t" + RO16TM.get(i + 1) + ":\t" + p(RO16NUM.get(i), RO16NUM.get(i + 1)));
            if(p(RO16NUM.get(i), RO16NUM.get(i + 1)) > .5){
                System.out.println(RO16TM.get(i) +"\tWins!");
                RO8TM.add(RO16TM.get(i));
                RO8NUM.add(RO16NUM.get(i));

            }
            else if(p(RO16NUM.get(i), RO16NUM.get(i + 1)) == .5){
                System.out.println("'Tis a tie!");
            }
            else{
                System.out.println(RO16TM.get(i + 1) + "\tWins!");
                RO8TM.add(RO16TM.get(i+1));
                RO8NUM.add(RO16NUM.get(i+1));
//

            }
            System.out.println();

        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("ROUND OF 8 (Elite 8)");
        for(int i = 0; i < RO8TM.size(); i = i + 2) {
            System.out.println(RO8TM.get(i) + "\t" + RO8TM.get(i + 1) + ":\t" + p(RO8NUM.get(i), RO8NUM.get(i + 1)));
            if(p(RO8NUM.get(i), RO8NUM.get(i + 1)) > .5){
                System.out.println(RO8TM.get(i) +"\tWins!");
                RO4TM.add(RO8TM.get(i));
                RO4NUM.add(RO8NUM.get(i));

            }
            else if(p(RO8NUM.get(i), RO8NUM.get(i + 1)) == .5){
                System.out.println("'Tis a tie!");
            }
            else{
                System.out.println(RO8TM.get(i + 1) + "\tWins!");
                RO4TM.add(RO8TM.get(i));
                RO4NUM.add(RO8NUM.get(i));
//

            }
            System.out.println();

        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("ROUND OF 4 (Final 4)");
        for(int i = 0; i < RO4TM.size(); i = i + 2) {
            System.out.println(RO4TM.get(i) + "\t" + RO4TM.get(i + 1) + ":\t" + p(RO4NUM.get(i), RO4NUM.get(i + 1)));
            if(p(RO4NUM.get(i), RO4NUM.get(i + 1)) > .5){
                System.out.println(RO4TM.get(i) +"\tWins!");
                FinalTM.add(RO4TM.get(i));
                FinalNum.add(RO4NUM.get(i));

            }
            else if(p(RO4NUM.get(i), RO4NUM.get(i + 1)) == .5){
                System.out.println("'Tis a tie!");
            }
            else{
                System.out.println(RO4TM.get(i + 1) + "\tWins!");
                FinalTM.add(RO4TM.get(i));
                FinalNum.add(RO4NUM.get(i));
//

            }
            System.out.println();

        } System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Championship");
        for(int i = 0; i < FinalTM.size(); i = i + 2) {
            System.out.println(FinalTM.get(i) + "\t" + FinalTM.get(i + 1) + ":\t" + p(FinalNum.get(i), FinalNum.get(i + 1)));
            if(p(FinalNum.get(i), FinalNum.get(i + 1)) > .5){
                System.out.println(FinalTM.get(i) +"\tWins!");
                break;

            } else{
                System.out.println(FinalTM.get(i + 1) + "\tWins!");
                break;
//

            }
           // else if(p(FinalNum.get(i), FinalNum.get(i + 1)) == .5){
             //   System.out.println("'Tis a tie!");
               // break;
            }


        }


    }

