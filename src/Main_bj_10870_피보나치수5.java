import java.io.*;
import java.util.*;

public class Main_bj_10870_피보나치수5 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_10870.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.print(fibonacci(n));
	}

	static int fibonacci(int n) {
		if(n==0 || n==1) return n;
		
		return fibonacci(n-1)+fibonacci(n-2);
	}
}
