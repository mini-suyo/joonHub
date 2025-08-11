import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> tail = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = -a;

            int pos = -1;
            for (int j = 0; j < tail.size(); j++) {
                if (tail.get(j) >= b) {
                    pos = j;
                    break;
                }
            }

            if (pos == -1) {
                tail.add(b);
            } else {
                tail.set(pos, b);
            }
        }

        System.out.println(tail.size());
    }
}
