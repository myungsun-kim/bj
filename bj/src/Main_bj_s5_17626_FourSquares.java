import java.io.*;

// 모든 자연수는 넷 혹은 그 이하의 제곱수의 합으로 표현될 수 있다
// 자연수 n이 주어질 때 n을 최소 개수의 제곱수 합으로 표현하는 프로그램을 작성
public class Main_bj_s5_17626_FourSquares {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_17626.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		
		dp[1]=1;
		 
		for(int i=2;i<=n;i++) {
			int min=Integer.MAX_VALUE;
			
			for(int j=1;j*j<=i;j++) {
				int tmp=i-j*j;			
				min=Math.min(min, dp[tmp]); 
			}
			dp[i]=min+1;
		}
		br.close();
		System.out.print(dp[n]);
	}
}