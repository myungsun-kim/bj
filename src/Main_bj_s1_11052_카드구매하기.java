import java.io.*;
import java.util.*;
// 전설 / 레드 / 오렌지 / 퍼플 / 블루 / 청록 / 그린 / 그레이 카드 있음
// 카드는 카드팩의 형태로만 구매할 수 있고 카드팩의 종류는 
// 카드 1개가 포함된 카드팩, 카드 2개가 포함된 카드팩, 카드 N개가 포함된 카드팩 .. 총 N가지 존재
// 카드 i개가 포함된 카드팩의 가격은 Pi
// 민규는 가격이 비싸면 높은 등급의 카드가 많이 들어있을 것이라는 미신을 믿고 있음
// 카드 팩의 가격이 주어졌을 때, N개의 카드를 구매하기 위해 민규가 지불해야 하는 금액의 최댓값은
public class Main_bj_s1_11052_카드구매하기 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_11052.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //구입하려는 카드의 개수
		int[] card = new int[n+1];
		int[] dp = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=n;i++) card[i] = Integer.parseInt(st.nextToken());
		dp[1] = card[1];
		//dp[2] = card[2] or card[i-1]+card[1]
		for(int i=2;i<=n;i++) {
			int tmp = card[i];
			for(int j=1;j<i;j++) {
				tmp = Math.max(dp[i-j]+card[j], tmp);
			}
			dp[i] = tmp;
		}
		br.close();
		System.out.print(dp[n]);
	}
}
