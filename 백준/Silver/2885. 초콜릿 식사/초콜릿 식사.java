import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        int size = 1;
        while (size < K) {
            size *= 2;
        }

        int result = 0;
        int piece = size;
        int remain = K;

        while (remain > 0) {
            if (remain >= piece) {
                remain -= piece;
            } else {
                piece /= 2;
                result++;
            }
        }

        System.out.println(size + " " + result);
    }
}