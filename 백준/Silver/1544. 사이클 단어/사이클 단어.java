import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        String[] words = new String[N];
        boolean[] isVisited = new boolean[N];

        for (int i = 0; i < N; i++) {
            words[i] = sc.nextLine();
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            if (isVisited[i]) continue;
            count++;

            for (int j = i + 1; j < N; j++) {
                if (isVisited[j]) continue;
                if (words[i].length() != words[j].length()) continue;

                String doubled = words[i] + words[i];
                if (doubled.contains(words[j])) {
                    isVisited[j] = true;
                }
            }
        }

        System.out.println(count);
    }
}
