import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double totalScore = 0;
        double totalCredit = 0;

        for (int i = 0; i < 20; i++) {
            String subject = sc.next();
            double credit = sc.nextDouble();
            String score = sc.next();

            if(score.equals("A+")) totalScore += (credit * 4.5);
            else if(score.equals("A0")) totalScore += (credit * 4.0);
            else if(score.equals("B+")) totalScore += (credit * 3.5);
            else if(score.equals("B0")) totalScore += (credit * 3.0);
            else if(score.equals("C+")) totalScore += (credit * 2.5);
            else if(score.equals("C0")) totalScore += (credit * 2.0);
            else if(score.equals("D+")) totalScore += (credit * 1.5);
            else if(score.equals("D0")) totalScore += (credit * 1.0);
            else if(score.equals("F")) totalScore += (credit * 0.0);
            else if(score.equals("P")) continue;

            totalCredit += credit;
        }
        sc.close();

        double result = totalScore/totalCredit;

        System.out.println(result);
    }
}
