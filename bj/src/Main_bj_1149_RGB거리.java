import java.io.*;
import java.util.*;
//1번 집의 색!=2번 집의 색
//N번 집의 색!=N-1번 집의 색
//i번째(2<=i<=N-1) 집의 색 != i-1번째집의색 != i+1번째집의색
public class Main_bj_1149_RGB거리 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1149.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] cost = new int[n][3];
		int[][] dp = new int[n][3];
		//dp dp[i][0] R로 칠했을때
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<3;j++) {
				cost[i][j]=Integer.parseInt(st.nextToken());//빨, 초, 파
				if(i==0) dp[i][j]=cost[i][j];//첫번째값 초기화
			}
		}
		
		for(int i=1;i<n;i++) {
			dp[i][0]=Math.min(dp[i-1][1], dp[i-1][2])+cost[i][0];
			dp[i][1]=Math.min(dp[i-1][0], dp[i-1][2])+cost[i][1];
			dp[i][2]=Math.min(dp[i-1][0], dp[i-1][1])+cost[i][2];
		}
		br.close();
		System.out.print(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));
	}
}
