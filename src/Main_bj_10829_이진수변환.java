import java.io.*;
import java.math.BigInteger;

public class Main_bj_10829_이진수변환 {
	static StringBuilder sb = new StringBuilder();
	static BigInteger two = new BigInteger("2");
	static BigInteger zero = new BigInteger("0");
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_10829.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger n = new BigInteger(br.readLine());
		binary(n);
		br.close();
		System.out.print(sb.reverse().toString());
	}
	
	static void binary(BigInteger n) {
		if(n.equals(zero)) return;
		sb.append(n.mod(two));
		binary(n.divide(two));
	}
}
