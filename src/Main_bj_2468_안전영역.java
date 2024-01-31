import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_bj_2468_안전영역 {
	static int n, answer;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_bj_2468.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		answer = 1; //아무지역도 물에 잠기지 않을 수 있다 > 영역이 1개
		map = new int[n][n];

		int min = 100;
		int max = 1;
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]<min) min = map[i][j];
				if(map[i][j]>max) max = map[i][j];
			}
		}
		
		for(int h=min;h<=max;h++) {
			int sum = 0;
			visited = new boolean[n][n];
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					if(map[i][j] > h && !visited[i][j]) {
						bfs(i,j,h);
						++sum;
					}
				}
			}
			if(sum>answer) answer = sum;
		}
		
		br.close();
		System.out.print(answer);
	}
	
	static void bfs(int row, int col, int height) {
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {row,col});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();

			for(int d=0;d<4;++d) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				
				if(check(nr,nc) && map[nr][nc] > height && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc});
				}
			}
		}
	}
	
	static boolean check(int r, int c) {
		if(r<0 || c<0 || r>=n || c>=n) return false;
		return true;
	}
}
