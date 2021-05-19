import java.io.*;
import java.util.*;
//이항계수:이항정리에서 전계된 항의 계수
public class Main_bj_b1_11050_이항계수1 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_11050.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		//Nx(N-1)x.. >K개를 K!로 나눔
		int answer=1;
		int cnt=0;
		
		while(cnt++<K) {
			answer*=(N--);
		}
		
		for(int i=1;i<=K;i++) {
			answer/=i;
		}
		br.close();
		System.out.print(answer);
	}
}
