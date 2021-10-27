import java.io.*;
import java.util.*;
// 계단 수 = 인접한 모든 자리의 차이가 1인 수
// N이 주어질 때, 길이가 N인 계단 수는 총 몇 개 인가 출력
// 0으로 시작하는 수는 계단수가 아님
// N은 1보다 크거나 같고 ,100보다 작거나 같은 자연수
// 정답을 1,000,000,000 으로 나눈 나머지 출력
public class Main_bj_s1_10844_쉬운계단수 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_10844.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		final int mod = 1000000000; //나누는 수
		
		int[][] dp = new int[101][10]; //dp[i][j] = n=1, 마지막 자리 수 j
		
		for(int i=1;i<10;i++) dp[1][i]=1;
		
		for(int i=2;i<dp.length;i++) {
			dp[i][0] = dp[i-1][1]%mod;
			for(int j=1;j<9;j++) {
				dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1])%mod;
			}
			dp[i][9] = dp[i-1][8]%mod;
		}
		
		int answer = 0;
		for(int i=0;i<10;i++) {
			answer+=dp[n][i];
			answer%=mod;
		}
		
		br.close();
		System.out.print(answer);
	}
}
