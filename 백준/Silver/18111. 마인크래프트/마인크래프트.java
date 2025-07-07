import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] heightCount = new int[257];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int h = Integer.parseInt(st.nextToken());
                heightCount[h]++;
            }
        }

        int resultTime = Integer.MAX_VALUE;
        int resultHeight = 0;

        for (int h = 0; h <= 256; h++) {
            int remove = 0;
            int add = 0;

            for (int i = 0; i <= 256; i++) {
                int diff = i - h;
                if (diff > 0) remove += diff * heightCount[i];
                else add -= diff * heightCount[i];
            }

            if (remove + B >= add) {
                int time = remove * 2 + add;
                if (time < resultTime || (time == resultTime && h > resultHeight)) {
                    resultTime = time;
                    resultHeight = h;
                }
            }
        }

        System.out.println(resultTime + " " + resultHeight);
    }
}
