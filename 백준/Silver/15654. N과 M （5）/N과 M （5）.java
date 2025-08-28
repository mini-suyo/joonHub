import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] nums, sel;
    static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        nums = new int[N];
        sel = new int[M];
        used = new boolean[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums); // 오름차순 정렬

        dfs(0);
    }

    static void dfs(int idx) {
        // 기저 조건: M개 다 뽑았을 때
        if (idx == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(sel[i] + " ");
            }
            System.out.println();
            return;
        }

        // 아직 안 쓴 숫자 하나 뽑기
        for (int i = 0; i < N; i++) {
            if (used[i]) continue;
            used[i] = true;
            sel[idx] = nums[i];
            dfs(idx + 1);
            used[i] = false;
        }
    }
}
