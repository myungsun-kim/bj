import java.io.*;

// 피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 
// 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
// Fn = Fn-1 + Fn-2 (n ≥ 2)
// n번째 피보나치 수를 구하는 프로그램 작성
public class Main_bj_2748_피보나치수2 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_2748.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] pibo = new long[n+1];
		if(n>1) pibo[0]=0;
		if(n>=1) pibo[1]=1;
		for(int i=2;i<=n;i++) {
			pibo[i]=pibo[i-2]+pibo[i-1];
		}
		br.close();
		System.out.print(pibo[n]);
	}

}
