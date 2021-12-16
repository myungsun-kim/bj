import java.io.*;
//계단 오르기 게임은 계단 아래 시작점부터 계단 꼭대기에 위치한 도착점까지 가는 게임
//계단은 한 번에 한 계단, 또는 두 계단씩 오를 수 있다
//연속된 세 개의 계단을 모두 밝아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다
//마지막 도착 계단은 반드시 밟아야한다
//총 점수의 최댓값을 구하여라
public class Main_bj_s3_2579_계단오르기 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2579.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] stair=new int[N+1];
		int[][] dp=new int[N+1][3];//몇 번째 계단을 밟고 있는지, 현재까지 몇 개의 연속된 계단을 밟았는지
		for(int i=1;i<=N;i++) {
			stair[i]=Integer.parseInt(br.readLine());
		}
		dp[1][1]=stair[1];
		if(N>1) {			
			dp[2][1]=stair[2];
			dp[2][2]=dp[1][1]+stair[2];
			for(int i=3;i<=N;i++) {
				dp[i][1]=Math.max(dp[i-2][1], dp[i-2][2])+stair[i];
				dp[i][2]=dp[i-1][1]+stair[i];
			}
		}

		System.out.print(Math.max(dp[N][1], dp[N][2]));
	}
}
