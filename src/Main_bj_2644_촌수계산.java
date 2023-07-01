import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_bj_2644_촌수계산 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2644.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer;
		boolean[][] rel = new boolean[n+1][n+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int person1 = Integer.parseInt(st.nextToken());
		int person2 = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		for(int i=0;i<m;++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			rel[tmp1][tmp2] = rel[tmp2][tmp1] = true;
		}
		answer = bfs(n, person1, person2, rel);
		System.out.print(answer);
	}
	
	static int bfs(int n, int person1, int person2, boolean[][] rel) {
		int answer = -1;
		boolean[] visited = new boolean[n+1];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {person1, 0}); //현재위치, 촌수
	
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0] == person2) {
				answer = cur[1];
				break;
			}
			
			visited[cur[0]] = true;
			
			for(int i=1;i<=n;++i) {
				if(!visited[i] && rel[cur[0]][i]) {
					q.offer(new int[] {i, cur[1]+1});
				}
			}
		}
		
		return answer;
	}
}
