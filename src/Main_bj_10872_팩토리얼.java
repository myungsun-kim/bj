import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_bj_10872_팩토리얼 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_10872.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();
		System.out.print(factorial(n));
	}

	static int factorial(int n) {
		if(n==0) return 1;
		
		return n*factorial(n-1);
	}
}
