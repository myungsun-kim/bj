import java.io.*;
import java.util.*;
// 오늘부터 n+1일째 되는 날 퇴사를 하기 위해 남은 n일 동안 최대한 많은 상담을 하려고 한다
// 하루에 하나씩 서로 다른 상담을 잡아놓았고, 
// 각각의 상담은 상담을 완료하는데 걸리는 시간 t[i]와 받을 수 있는 금액 p[i]로 이루어져있다
// 상담을 하는데 필요한 기간은 1일보다 클 수 있기에 모든 상담을 할 수는 없다
// n일 동안 상담을 할 때 얻을 수 있는 최대 수익
public class Main_bj_s4_14501_퇴사 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_14501.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());//상담 개수
		int[][] counsel = new int[n+1][2]; //상담 정보
		int[] dp = new int[n+1]; //해당 날짜까지의 최대 수익 저장
		int max = 0;// 최대 수익 저장
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			counsel[i][0] = Integer.parseInt(st.nextToken());
			counsel[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<=n;i++) {
			dp[i] = Math.max(dp[i], max);
			if(counsel[i][0]+i<=n) dp[counsel[i][0]+i]=Math.max(dp[counsel[i][0]+i], counsel[i][1]+dp[i]);
			//현재+완료 시점의 수익 = 현재 완료 시점에 저장된 금액
			
			max = Math.max(max, dp[i]);
		}
		br.close();
		System.out.print(max);
	}
}
