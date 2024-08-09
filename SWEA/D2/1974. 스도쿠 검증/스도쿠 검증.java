import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
 
        for (int t = 0; t < T; t++) {
            int[][] sudoku = new int[9][9];
            int result = 1; // 출력값(기본 1: 맞음으로 설정)
 
            // 9x9 행렬에 들어갈 데이터 받기
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = sc.nextInt();
                }
            }
 
            // 가로줄 확인
            PriorityQueue<Integer> pQwidth = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            a: for (int i = 0; i < sudoku.length; i++) {
                for (int j = 0; j < sudoku[0].length; j++) {
                    pQwidth.add(sudoku[i][j]);
                }
                for (int j = 0; j < sudoku[0].length; j++) {
                    if (pQwidth.poll() != j + 1) {
                        result = 0;
                        break a;
                    }
                }
            }
 
            // 세로줄 확인
            PriorityQueue<Integer> pQheight = new PriorityQueue<>();
            a: for (int i = 0; i < sudoku.length; i++) {
                for (int j = 0; j < sudoku[0].length; j++) {
                    pQheight.add(sudoku[j][i]);
                }
                for (int j = 0; j < sudoku[0].length; j++) {
                    if (pQheight.poll() != j + 1) {
                        result = 0;
                        break a;
                    }
                }
            }
 
            // 3x3 확인
            a: for (int i = 0; i < 9; i += 3) {
                for (int j = 0; j < 9; j += 3) {
                    int[] arr = new int[9];
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            arr[k * 3 + l] = sudoku[i + k][j + l];
                        }
                    }
                    Arrays.sort(arr);
                    for (int k = 0; k < 9; k++) {
                        if (arr[k] - 1 != k) {
                            result = 0;
                            break a;
                        }
                    }
                }
            }
 
            System.out.println("#" + (t + 1) + " " + result);
 
        }
 
    }
}