import java.util.*;

class Solution {
    
    Map<Integer, List<Integer>> trees = new HashMap<>();
    boolean[] visited = new boolean[1000001];
    
    public int[] solution(int[] nodes, int[][] edges) {
        int[] answer = new int[2];
        
        // 1. 노드와 간선 정보 저장
        for (int node : nodes) {
            trees.put(node, new ArrayList<>());
        }
        for (int[] edge : edges) {
            trees.get(edge[0]).add(edge[1]);
            trees.get(edge[1]).add(edge[0]);
        }
        
        // 2. 홀짝 트리 검사
        for(int node : nodes) {
            if (!visited[node] && checkHolZzak(node, -1)) {
                answer[0]++;
            }
        }
        
        // 3. 방문 배열 초기화
        visited = new boolean[10000001];
        
        // 4. 역홀짝 트리 검사
        for (int node : nodes) {
            if(!visited[node] && checkReverseHolZzak(node, -1)) {
                answer[1]++;
            }
        }
        return answer;
    }
    
    // 홀짝 트리 검사
    private boolean checkHolZzak(int current, int parent) {
        List<Integer> children = trees.get(current);
        int childrenSize = children.size() - 1;
        if(parent == -1) {
            childrenSize++;
        }
        
        if(current % 2 == childrenSize % 2) {
            visited[current] = true;
            for(int child : children) {
                if(child == parent) continue;
                if(!checkHolZzak(child, current)) {
                    visited[current] = false;
                    return false;
                }
            }
        } else return false;
        return true;
    }

    // 역홀짝트리 검사
    private boolean checkReverseHolZzak(int current, int parent) {
        List<Integer> children = trees.get(current);
        int childrenSize = children.size() - 1;
        if (parent == -1) {
            childrenSize++;
        }

        if (current % 2 != childrenSize % 2) {
            visited[current] = true;
            for (int child : children) {
                if (child == parent) continue;
                if (!checkReverseHolZzak(child, current)) {
                    visited[current] = false;
                    return false;
                }
            }
        } else return false;
        return true;
    }
}