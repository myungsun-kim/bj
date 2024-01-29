import java.io.*;
import java.math.BigInteger;

public class Main_bj_10826_피보나치수4 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_10826.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n==0) {
			System.out.print(0);
		}else if(n==1){
			System.out.print(1);			
		}else {
			BigInteger[] dp = new BigInteger[n+1];
			dp[1] = BigInteger.valueOf(1);
			dp[2] = BigInteger.valueOf(1);
			for(int i=3;i<=n;i++) dp[i]=dp[i-1].add(dp[i-2]);
			br.close();
			System.out.print(dp[n]);
		}
	}
}
