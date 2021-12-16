import java.io.*;
import java.util.*;
public class Main_bj_s4_10816_숫자카드2 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_10816.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] cnt = new int[20000001];//숫자의 범위가 -10000000~10000000
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			cnt[Integer.parseInt(st.nextToken())+10000000]++;
		}
		int M=Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<M;i++) {			
			sb.append(cnt[Integer.parseInt(st.nextToken())+10000000]).append(" ");
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}
