import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            HashMap<String, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                sc.next();
                String type = sc.next();
                if (map.containsKey(type)) {
                    map.put(type, map.get(type) + 1);
                } else {
                    map.put(type, 1);
                }
            }

            int ways = 1;
            for (String key : map.keySet()) {
                ways = ways * (map.get(key) + 1);
            }
            ways = ways - 1;

            System.out.println(ways);
        }

        sc.close();
    }
}
