import java.io.*;
import java.util.*;
// 가중치 없는 방향 그래프 G가 주어졌을 때 모든 정점 i,j에 대해서 i에서 j로 가는 경로가 있는지 없는지
public class Main_bj_s1_11403_경로찾기 {
	static int n;
	static boolean[][] arr;
	
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input_bj_11403.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		arr = new boolean[n][n];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<n;j++) {
				if(Integer.parseInt(st.nextToken())==1) arr[i][j] = true;
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sb.append(bfs(i,j)).append(' ');
			}
			sb.append('\n');
		}
		br.close();
		System.out.print(sb.toString());
	}
	
	static int bfs(int start, int end) {
		Queue<Integer> q = new LinkedList<>();
		boolean check = false; //이동이 가능한지 체크
		boolean first = true; //start와 end가 같은 경우 제외하기 위해
		boolean[] visited = new boolean[n];
		q.offer(start);
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			if(!first && tmp==end) {
				check = true;
				break;
			}
			
			for(int i=0;i<n;i++) {
				if(!visited[i] && arr[tmp][i]) {
					visited[i] = true;
					q.offer(i);
				}
			}
			if(first) first=false;
		}
		
		if(check) return 1;
		return 0;
	}
}
