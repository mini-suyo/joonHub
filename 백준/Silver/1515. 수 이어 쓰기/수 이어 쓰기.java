import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int index = 0;
        int i = 1;

        while (true) {
            String str = Integer.toString(i);
            for (int j = 0; j < str.length(); j++) {
                if (index < s.length() && s.charAt(index) == str.charAt(j)) {
                    index++;
                }
                if (index == s.length()) {
                    System.out.println(i);
                    return;
                }
            }
            i++;
        }
    }
}
