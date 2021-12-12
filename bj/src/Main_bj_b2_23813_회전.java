import java.io.*;
import java.math.*;

public class Main_bj_b2_23813_회전 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_23813.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		BigInteger sum = new BigInteger(input);
		
		for(int i=1;i<input.length();i++) {
			input = input.substring(1,input.length())+input.substring(0,1);
			sum = sum.add(new BigInteger(input));
		}
		
		br.close();
		System.out.print(sum);
	}
}
