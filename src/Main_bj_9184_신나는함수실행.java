import java.io.*;
import java.util.*;
// 재귀함수 w(a,b,c)가 있다
// a,b,c 중 하나라도 0보다 작거나 같으면 1을 리턴
// a,b,c 중 하나라도 20보다 크다면 w(20,20,20)
// a<b<c라면 w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c)
// 그 외의 경우 w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1)
public class Main_bj_9184_신나는함수실행 {
	static int[][][] dp = new int[21][21][21];//1~20까지 사용
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_9184.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a==-1 && b==-1 && c==-1) break;
			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ");
			sb.append(w(a,b,c)).append('\n');
		}
		br.close();
		System.out.print(sb.toString());
	}
	
	static int w(int a, int b, int c) {
		if(a<=0 || b<=0 || c<=0) return 1;
		if(a>20 || b>20 || c>20) {
			if(dp[20][20][20]==0) return dp[20][20][20]=w(20,20,20);
			else return dp[20][20][20];
		}
		if(dp[a][b][c]!=0) return dp[a][b][c];
		if(a<b && b<c) return dp[a][b][c]=w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
		return dp[a][b][c]=w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
	}
}
