import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_bj_9095_123더하기 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_9095.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		int[] dp;
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			dp = new int[num+1];
			dp[1]=1;
			if(num>1) dp[2]=2;
			if(num>2) dp[3]=4;
			for(int j=4;j<=num;j++) {
				dp[j]=dp[j-1]+dp[j-2]+dp[j-3];
			}
			sb.append(dp[num]).append('\n');
		}
		br.close();
		if(n>0) sb.setLength(sb.length()-1);
		System.out.print(sb.toString());
	}
}
