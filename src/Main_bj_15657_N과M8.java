import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N개의 자연수와 자연수 M이 주어졌을 때 N개의 자연수 중에서 M개를 고른 수열을 모두 출력
// 고른 수열은 오름차순
public class Main_bj_15657_N과M8 {
	static int n, m;
	static int[] arr, selected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_15657.txt"));
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
	
	static void perm(int idx, int cur) {
		if(idx==m) {
			print();
			return;
		}
		
		for(int i=cur;i<n;i++) {
			selected[idx] = arr[i];
			perm(idx+1, i);
		}
	}
	
	static void print() {
		for(int i=0;i<m;i++) sb.append(selected[i]).append(' ');
		sb.append('\n');		
	}
}
