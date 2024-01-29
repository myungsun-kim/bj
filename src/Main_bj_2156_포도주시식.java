import java.io.*;
// 일렬로 놓인 포도주를 시식한다. 포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야하며 마신 후 원래 위치에 놓아야 한다
// 연속으로 놓여 있는 3잔을 모두 마실 수는 없다
// 가장 많은 양의 포도주를 마실 수 있도록 하는 프로그램 작성
public class Main_bj_2156_포도주시식 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_2156.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //포도주 잔의 개수
		int[] grape = new int[n+1];
		int[] dp = new int[n+1];
		for(int i=1;i<=n;i++) grape[i]=Integer.parseInt(br.readLine());
		dp[1]=grape[1];
		int answer=dp[1];
		
		if(n>=2) {
			dp[2]=grape[1]+grape[2];
			answer=dp[2];
		}
		
		for(int i=3;i<=n;i++) {
			dp[i]=Math.max(dp[i-2],dp[i-3]+grape[i-1]);//dp[i-2]에서의 가장 많이 마실 수 있는 포도주의 양 구함
			dp[i]=Math.max(dp[i]+grape[i], dp[i-1]);
			if(answer<dp[i]) answer=dp[i];
		}
		System.out.print(answer);
	}
}
