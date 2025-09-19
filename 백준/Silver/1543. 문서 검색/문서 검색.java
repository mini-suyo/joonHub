import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String word = sc.nextLine();
        sc.close();

        int count = 0;
        int length = word.length();

        for (int i = 0; i <= text.length() - length; i++) {
            int j = 0;
            for (; j < length; j++) {
                if (text.charAt(i + j) != word.charAt(j)) break;
            }
            if (j == length) {
                count++;
                i += length - 1;
            }
        }

        System.out.println(count);
    }
}
