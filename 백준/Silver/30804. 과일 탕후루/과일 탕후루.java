import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] fruits = new int[N];
        for (int i = 0; i < N; i++) {
            fruits[i] = sc.nextInt();
        }

        Map<Integer, Integer> cnt = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < N; right++) {
            int f = fruits[right];
            cnt.put(f, cnt.getOrDefault(f, 0) + 1);

            while (cnt.size() > 2) {
                int lf = fruits[left];
                cnt.put(lf, cnt.get(lf) - 1);
                if (cnt.get(lf) == 0) cnt.remove(lf);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        System.out.println(maxLen);
    }
}