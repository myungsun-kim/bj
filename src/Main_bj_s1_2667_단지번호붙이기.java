import java.io.*;
import java.util.*;
// 1:집이 있는 곳 0:집이 없는 곳 단지:연결된 집의 모임
// 총 단지 수와 각 단지에 속하는 집의 수 카운트
public class Main_bj_s1_2667_단지번호붙이기 {
	static int N;
	static int[][] map;
	static int[] complex_count;//단지당 집의 개수
	static boolean[][] visited;
	static int[] dr = {0,-1,0,1};
	static int[] dc = {1,0,-1,0};
	
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_2667.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		complex_count = new int[N*N];//단지당 집의 개수
		
		for(int i=0;i<N;i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j=0;j<N;j++) {
				map[i][j]=tmp[j]-'0';
				if(map[i][j]==0) visited[i][j]=true;//0인 경우 살펴볼 필요 X
			}
		}
		
		int complex=0; //단지 개수
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j]) continue; //이미 살펴본 경우
				if(map[i][j]==1) bfs(i,j,++complex);
			}
		}
		System.out.println(complex);
		Arrays.sort(complex_count);
		for(int i=0;i<complex_count.length;i++) {
			if(complex_count[i]!=0) System.out.println(complex_count[i]);
		}
	}
	
	static void bfs(int r, int c, int complex) {
		Queue<int[]> q= new LinkedList<>();
		q.offer(new int[] {r,c});
		visited[r][c]=true;
		int count=1;//현 단지의 집 개수
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int d=0;d<4;d++) {
				int nr=tmp[0]+dr[d];
				int nc=tmp[1]+dc[d];
				
				if(check(nr,nc) && !visited[nr][nc] && map[nr][nc]==1) {
					map[nr][nc] = complex;//단지 번호로 배열 값 변경
					q.offer(new int[] {nr,nc});
					visited[nr][nc]=true;
					count++;
				}
			}
		}
		complex_count[complex]=count;
	}
	
	static boolean check(int r, int c) {//배열 범위 벗어났는지 체크
		if(r<0 || c<0 || r>=N || c>=N) return false;
		return true;
	}
}
