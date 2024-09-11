import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long A = sc.nextLong();
		long B = sc.nextLong(); //1의 개수  
		
		int result = dGN(A,B); //값은 천만자리를 넘지 않는다고 했기 때문에 int로 받아도 됨
		
		for (int i = 0; i < result; i++) {
			bw.write("1");
		}

		bw.flush();
		bw.close();
		
	}

	private static int dGN(long a, long b) {
		if(b == 0) {
			return (int) a;
		}
		return dGN(b,a%b);
	}

}
