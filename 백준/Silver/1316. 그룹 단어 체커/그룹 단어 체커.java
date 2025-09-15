import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            boolean[] seen = new boolean[26];
            char prev = 0;

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c != prev) {
                    if (seen[c - 'a']) {
                        s = null;
                        break;
                    }
                    seen[c - 'a'] = true;
                    prev = c;
                }
            }

            if (s != null) {
                count++;
            }
        }

        System.out.println(count);
        sc.close();
    }
}
