import java.io.*;
import java.util.*;

public class Main_bj_11399_ATM {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_11399.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] p = new int[N];//돈을 뽑는데 얼마나 걸리는지
		int sum=0;//모든 사람이 돈을 뽑는데 최소한의 시간
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(p);
		for(int i=0;i<N;i++) {
			for(int j=0;j<=i;j++) {				
				sum+=p[j];
			}
		}
		br.close();
		System.out.print(sum);
	}
}
