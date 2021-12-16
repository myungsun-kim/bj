import java.io.*;
import java.util.*;

public class Main_bj_s4_1920_수찾기 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1920.txt"));
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		int M = Integer.parseInt(br.readLine());
		int input;
		boolean chk;
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<M;i++) {
			chk=false;
			input=Integer.parseInt(st.nextToken());
			for(int j=0;j<N;j++) {
				if(input==a[j]) {
					chk=true;
					break;
				}else if(input<a[j]) break;
			}
			if(chk) sb.append(1);
			else sb.append(0);
			sb.append("\n");
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}
