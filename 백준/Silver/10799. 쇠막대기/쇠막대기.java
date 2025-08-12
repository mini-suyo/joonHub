import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        int open = 0;
        long result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                open++;
            } else {
                open--;
                if (i > 0 && s.charAt(i - 1) == '(') {
                    result += open;
                } else {
                    result += 1;
                }
            }
        }

        System.out.println(result);
    }
}
