import java.io.*;

// n이 주어졌을때 n번째 피보나치 수를 구하는 프로그램 작성
public class Main_bj_2747_피보나치수 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2747.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] pibo = new int[n+1];
		pibo[1]=1;
		for(int i=2;i<=n;i++) pibo[i]=pibo[i-1]+pibo[i-2];
		br.close();
		System.out.print(pibo[n]);
	}
}
