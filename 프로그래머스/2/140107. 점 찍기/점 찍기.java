import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        for (int a = 0; a <= d / k; a++) {
            double maxY = Math.sqrt((long)d * d - (long)(a * k) * (a * k));
            answer += (int)(maxY / k) + 1;
        }

        return answer;
    }
}
