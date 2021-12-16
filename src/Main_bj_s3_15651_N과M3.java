import java.io.*;
import java.util.*;

public class Main_bj_s3_15651_N과M3 {
	static int n, m;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_15651.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n =Integer.parseInt(st.nextToken());
		m =Integer.parseInt(st.nextToken());
		selected = new int[m];
		//1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열. 순열
		perm(0);
		
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
	
	static void perm(int cnt) {
		if(cnt==m) {
			for(int i=0;i<m;i++) {
				sb.append(selected[i]).append(" ");
			}sb.setLength(sb.length()-1);
			sb.append("\n");
			return;
		}
		
		//비내림차순
		for(int i=1;i<=n;i++) {
			if(cnt==0 || (cnt>0 && selected[cnt-1]<=i)) {
				selected[cnt]=i;
				perm(cnt+1);				
			}
		}
	}
}