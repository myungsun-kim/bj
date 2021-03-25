import java.io.*;
import java.util.*;

public class Main_bj_15652_N과M4 {
	static int n, m;
	static int[] selected;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_15649.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n =Integer.parseInt(st.nextToken());
		m =Integer.parseInt(st.nextToken());
		visited = new boolean[n+1];
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
		
		
		for(int i=1;i<=n;i++) {
			if(!visited[i] && (cnt==0 || selected[cnt-1]<i)) {//오름차순
				visited[i]=true;
				selected[cnt]=i;
				perm(cnt+1);
				visited[i]=false;
			}
		}
	}
}