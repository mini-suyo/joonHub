import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < L; i++) {
            String studentId = br.readLine();

            if (map.containsKey(studentId)) {
                map.remove(studentId);
            }
            map.put(studentId, i);
        }

        int count = 0;
        for (String id : map.keySet()) {
            if (count == K) break;
            System.out.println(id);
            count++;
        }
    }
}
