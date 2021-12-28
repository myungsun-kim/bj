import java.io.*;
import java.util.*;
// N개의 자연수와 자연수 M이 주어졌을 때 N개의 자연수 중에서 M개를 고른 수열을 모두 출력
// 고른 수열은 오름차순
public class Main_bj_s3_15655_N과M6 {
	static int n, m;
	static int[] arr, selected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_15655.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		selected = new int[m];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		perm(0,0);
		br.close();
		System.out.print(sb.toString());
	}
	
	static void perm(int idx, int start) {
		if(idx==m) {
			for(int i=0;i<m;i++) sb.append(selected[i]).append(' ');
			sb.append('\n');
			return;
		}
		
		for(int i=start;i<n;i++) {
			selected[idx] = arr[i];
			perm(idx+1, i+1);
		}
	}
}
