import java.io.*;
import java.util.*;
import java.math.*;
// nCm 출력
public class Main_bj_2407_조합 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_2407.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		BigInteger answer = BigInteger.ONE;
		for(long i=n;i>n-m;--i) {
			answer = answer.multiply(BigInteger.valueOf(i));
		}
		for(long i=2;i<=m;++i) {
			answer = answer.divide(BigInteger.valueOf(i));
		}
		br.close();
		System.out.print(answer);
	}
}
