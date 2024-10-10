import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
       int[] count = new int[n+1];
        
        Arrays.fill(count,1);
        
        for(int i=0; i < reserve.length; i++){
            count[reserve[i]] += 1;
        }
        for(int i=0; i < lost.length; i++){
            count[lost[i]] -= 1;
        }
        
      for(int j=1; j< count.length; j++){
            if(count[j] == 0){
                if(j-1 >= 1 && count[j-1] == 2){
                    count[j-1] = 1;
                    count[j] = 1;
                    continue;
                }else if(j+1 <= n && count[j+1] == 2){
                   count[j+1] = 1;
                    count[j] = 1;
                    continue;
                }  
            }
        }
        int answer = 0;
        
        for(int k =1; k < count.length; k++){
            if(count[k] >= 1){
                answer++;
            }
        }
        return answer;
    }
}