import java.io.*;

// 2xn 크기의 직사각형을 1x2, 2x1 타일로 채우는 방법의 수를 구하는 프로그램 작성
public class Main_bj_11726_2xn타일링 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_11726.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		dp[1] = 1;
		if(n>1) dp[2] = 2;
		for(int i=3;i<=n;i++) {
			dp[i] = (dp[i-1]+dp[i-2])%10007;
		}
		br.close();
		System.out.print(dp[n]);
	}
}
