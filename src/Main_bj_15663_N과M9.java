import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

// N개의 자연수와 자연수 M이 주어졌을 때 N개의 자연수 중에서 M개를 고른 수열을 모두 출력
// 고른 수열은 오름차순
public class Main_bj_15663_N과M9 {
	static int n, m;
	static int[] arr, selected;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static HashSet<String> hash = new HashSet<>();
	
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_15663.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n];
		arr = new int[n];
		selected = new int[m];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		perm(0);
		br.close();
		System.out.print(sb.toString());
	}
	
	static void perm(int idx) {
		if(idx==m) {
			StringBuilder tmp = new StringBuilder();
			for(int i=0;i<m;i++) tmp.append(selected[i]).append(' ');
			String cur = tmp.toString();
			if(!hash.contains(cur)) { //현재 완성된 배열과 중복된 배열이 있는지 체크
				hash.add(cur);
				sb.append(cur).append('\n');
			}
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!visited[i]) {				
				selected[idx] = arr[i];
				visited[i] = true;
				perm(idx+1);
				visited[i] = false;
			}
		}
	}
}
