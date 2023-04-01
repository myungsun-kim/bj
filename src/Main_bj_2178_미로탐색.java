import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1은 이동할 수 있는 칸, 0은 이동할 수 없는 칸
// (1,1)에서 출발하여 (N,M)의 위치로 이동할 때 지나야 하는 최소의 칸 수 구하기
// 배열에선 (0,0)에서 출발하여 (N-1,M-1)로 이동
// 시작위치와 도착위치도 칸을 셀 때 포함
public class Main_bj_2178_미로탐색 {	
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,-1,0,1};
	static boolean[][] maze;
	static boolean[][] visited;
	static int n, m, answer;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2178.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());//행의 개수
		m = Integer.parseInt(st.nextToken());//열의 개수
		maze = new boolean[n][m];//미로
		visited = new boolean[n][m];//방문체크
		for(int i=0;i<n;i++) {
			char[] in = br.readLine().toCharArray();
			for(int j=0;j<m;j++) {
				if(in[j]=='1') maze[i][j]=true;
				else maze[i][j]=false;
			}
		}
		
		answer=Integer.MAX_VALUE;
		bfs(0,0);
		System.out.print(answer);
	}
	
	static void bfs(int row, int col) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {row, col, 1});
		visited[row][col] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0] == n-1 && cur[1] == m-1) {
				answer=cur[2];
				return;
			}
			
			for(int d=0;d<4;d++) {
				int nr=cur[0]+dr[d];
				int nc=cur[1]+dc[d];
				
				if(check(nr,nc) && !visited[nr][nc] && maze[nr][nc]) {
					q.offer(new int[] {nr,nc,cur[2]+1});
					visited[nr][nc]=true;
				}
			}
		}
	}
	
	static boolean check(int row, int col) {//배열의 범위 벗어났는지 유무
		if(row<0 || col<0 || row>=n || col>=m) return false;
		return true;
	}
}
