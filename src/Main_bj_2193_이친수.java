import java.io.*;
import java.util.*;
// 이친수는 특별한 성질을 갖는 이진수
// 이친수는 0으로 시작하지 않는다
// 이친수에서는 1이 두 번 연속으로 나타나지 않는다(11을 부분 문자열로 갖지 않는다)
// N자리 이친수의 개수 구하기 (1<=N<=90)
// 1 > 1	1
// 2 > 10	1
// 3 > 101 100	2
// 4 > 1010 1001 1000 3 2+1 //2*1+1
// 5 > 10100 10101 10010 10000 10001 5 3+2 2*2+1
// 6 > 2+1+2+2+1 > 8 2*3+2
// 7 > 2+1+2+1+2+1+2+2 > 11 2*4+3
// 이전에 끝이 0인 수의 개수*2+이전에 끝이 1인 수의 개수
public class Main_bj_2193_이친수 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2193.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[][] dp = new long[n+1][2];
		//[i][0] 끝이 0인 수 개수
		//[i][1] 끝이 1인 수 개수
		dp[1][1]=1;
		
		for(int i=2;i<=n;i++) {
			dp[i][0]=dp[i-1][0]+dp[i-1][1];
			dp[i][1]=dp[i-1][0];
		}
		br.close();
		System.out.print(dp[n][0]+dp[n][1]);
	}
}
