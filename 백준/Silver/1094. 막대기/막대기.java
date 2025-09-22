import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        sc.close();

        int count = 0;
        for (int i = X; i > 0; i = i / 2) {
            if ((i & 1) == 1) count++;
        }
        System.out.println(count);
    }
}