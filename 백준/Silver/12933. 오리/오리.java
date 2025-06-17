import java.util.*;

public class Main {
    public static void main(String[] args) {
        // quack 수를 카운팅하는 배열을 만들자.
        // quack 배열의 값은 뒤에 값이 앞보다 작거나같아야한다.
        // k를 만났을 때, q값과 k값의 차를 비교하여 최대값을 갱신한다.

        Scanner sc = new Scanner(System.in);

        String crying = sc.nextLine();
        sc.close();
        int[] count = new int[5];
        int result = 0;

        for (int i = 0; i < crying.length(); i++) {
            char tmp = crying.charAt(i);

            // 녹음소리가 올바르지 않은 경우
            if (count[0] < count[1] || count[1] < count[2] || count[2] < count[3] || count[3] < count[4]) {
                result = -1;
                break;
            }

            if (tmp == 'q') {
                count[0]++;
            } else if (tmp == 'u')
                count[1]++;
            else if (tmp == 'a')
                count[2]++;
            else if (tmp == 'c')
                count[3]++;
            else if (tmp == 'k') {
                count[4]++;
                if (result < (count[0] - count[4] + 1)) {
                    result = count[0] - count[4] + 1;
                }
            }
        }

        // 녹은소리가 올바르지 않은 경우2
        if (!((count[0] == count[1]) && (count[1] == count[2]) && (count[2] == count[3]) && (count[3] == count[4])))
            result = -1;

        System.out.print(result);

    }
}
