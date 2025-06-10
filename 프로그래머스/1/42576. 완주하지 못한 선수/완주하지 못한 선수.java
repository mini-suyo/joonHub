import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();

        for (String key: participant) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (String key: completion) {
            map.put(key, map.get(key) - 1);
        }
    
        HashMap<String, Integer> result = new HashMap<>();
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                answer = entry.getKey();
                break;
            }
        }

        return answer;
    }
}
