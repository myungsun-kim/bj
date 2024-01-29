import java.io.*;
import java.util.*;
// 배낭에 넣을 수 있는 물건 가치의 최댓값
public class Main_bj_12865_평범한배낭 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_12865.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken()); //물건의 개수
		int k = Integer.parseInt(st.nextToken()); //버틸 수 있는 무게
		int[] weight = new int[n+1];//물건의 무게
		int[] value = new int[n+1];//물건의 가치
		int[][] dp = new int[n+1][k+1];//해당 물건들을 담았을 때의 가치
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=n;i++) {//물건 체크
			for(int w=1;w<=k;w++) {//무게 체크
				if(weight[i]<=w) {//현재 물건을 가방에 넣을 수 있다면
					dp[i][w]=Math.max(dp[i-1][w-weight[i]]+value[i], dp[i-1][w]);
				}else {//현재 물건을 가방에 넣을 수 없다면
					dp[i][w]=dp[i-1][w];
				}
			}
		}
		br.close();
		System.out.print(dp[n][k]);
	}
}
