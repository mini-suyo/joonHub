import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        String[] NoHear = new String[N];
        String[] NoSee = new String[M];

        for (int i = 0; i < NoHear.length; i++) {
            NoHear[i] = sc.nextLine();
        }
        for (int i = 0; i < NoSee.length; i++) {
            NoSee[i] = sc.nextLine();
        }

        Arrays.sort(NoHear);
        Arrays.sort(NoSee);

        sc.close();

        int p1 = 0, p2 = 0;
        ArrayList<String> result = new ArrayList<>();

        while (p1 < N && p2 < M) {
            int compare = NoHear[p1].compareTo(NoSee[p2]);

            if (compare == 0) {
                result.add(NoHear[p1]);
                p1++;
                p2++;
            } else if (compare < 0) {
                p1++;
            } else {
                p2++;
            }
        }

        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
