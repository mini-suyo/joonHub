import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine().trim();
        int[] count = new int[26];

        for (char c : name.toCharArray()) {
            count[c - 'A']++;
        }

        String first = "";
        String middle = "";
        int oddCount = 0;

        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                oddCount++;
                middle = String.valueOf((char) ('A' + i));
            }
        }

        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < count[i] / 2; j++) {
                    first += (char) ('A' + i);
                }
            }

            String second = "";
            for (int i = first.length() - 1; i >= 0; i--) {
                second += first.charAt(i);
            }

            System.out.println(first + middle + second);
        }

        sc.close();
    }
}
