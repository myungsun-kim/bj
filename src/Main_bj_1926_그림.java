import java.io.*;
import java.util.*;
// 도화지에 1로 연결된 것을 한 그림이라고 정의. 가로나 세로로 연결된 것은 연결된 것
// 그림의 개수와 가장 넓은 그림의 넓이 출력
public class Main_bj_1926_그림 {
	static boolean[][] map, visited;
	static int n,m,max_area;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1926.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken()); //세로
		m = Integer.parseInt(st.nextToken()); //가로
		max_area = 0; //최대 넓이
		int count = 0; //그림의 개수
		
		map = new boolean[n][m];
		visited = new boolean[n][m];
		
		for(int i=0;i<n;i++) { //입력
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<m;j++) {
				if(Integer.parseInt(st.nextToken())==1) map[i][j] = true;
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] && !visited[i][j]) {
					count++;
					bfs(i,j);
				}
			}
		}
		br.close();
		sb.append(count).append('\n').append(max_area);
		System.out.print(sb.toString());
	}
	
	static void bfs(int row, int col) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {row, col});
		visited[row][col]=true;
		int area = 1; //현재 도화지 넓이
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int d=0;d<4;d++) {
				int nr = tmp[0]+dr[d];
				int nc = tmp[1]+dc[d];
				
				if(check(nr,nc) && map[nr][nc] && !visited[nr][nc]) {
					q.offer(new int[] {nr,nc});
					visited[nr][nc]=true;
					area++;
				}
			}
		}
		if(area>max_area) max_area=area;
	}
	
	static boolean check(int row, int col) {
		if(row<0 || col<0 || row>=n || col>=m) return false;
		return true;
	}
}
