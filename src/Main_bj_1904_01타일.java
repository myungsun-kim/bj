import java.io.*;
// 기존에는 0또는 1이 쓰여 있는 낱장의 타일이 있었음
// 0이 쓰여진 낱장의 타일들을 붙여 한 쌍으로 이루어진 00타일을 만듦
// 현재 1 하나만으로 이루어진 타일 또는 0타일을 두 개 붙인 한 쌍의 00타일만 남음
// 타일의 크기가 달라지면서 더 이상 크기가 N인 모든 2진 수열을 만들 수 없게 됨
// 예를 들어 n=1일때 1만 만들 수 있고 n=2일때는 00,11 .. 등등 만들어짐
// 1 1 1
// 2 11 00 2
// 3 100 001 111 3
// 4 0000 0011 1100 1001 1111 5
// 5 10000 00100 00001 10011 11001 11100 00111 11111 8
// n이 주어졌을 때 만들 수 있는 모든 가짓수 출력
public class Main_bj_1904_01타일 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1904.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		dp[1]=1;
		if(n>=2) dp[2]=2;
		
		for(int i=3;i<=n;i++) {
			dp[i] = (dp[i-1]+dp[i-2])%15746;
		}
		br.close();
		System.out.print(dp[n]);
	}
}
