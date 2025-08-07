import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        if (N % 2 == 0 || M % 2 == 0) {
            System.out.println("A");
        } else {
            System.out.println("B");
        }
    }
}
