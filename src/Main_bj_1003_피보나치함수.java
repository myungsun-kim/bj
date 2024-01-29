import java.io.*;

//0이 출력되는 횟수와 1이 출력되는 횟수 출력
public class Main_bj_1003_피보나치함수 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1003.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] zero;
		int[] one;
		for(int t=0;t<T;t++) {
			int N=Integer.parseInt(br.readLine());
			zero = new int[N+1];
			one = new int[N+1];
			zero[0]=1;
			one[0]=0;
			if(N>0) {				
				zero[1]=0;
				one[1]=1;
			}
			for(int i=2;i<=N;i++) {
				zero[i]=zero[i-1]+zero[i-2];
				one[i]=one[i-1]+one[i-2];
			}
			sb.append(zero[N]).append(' ').append(one[N]).append('\n');
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb.toString());
	}
}
