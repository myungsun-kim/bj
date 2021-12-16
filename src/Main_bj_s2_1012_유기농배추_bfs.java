import java.io.*;
import java.util.*;
// 해충 방지에 효과적인 배추흰지렁이는 배추근처에 서식하며 해충을 잡아먹음으로써 배추를 보호
// 어떤 배추에 배추흰지렁이가 한마리 이상 살고 있으면 이 지렁이는 인접한(상하좌우)다른 배추로 이동할 수 있음
// 0은 배추가 심어져 있지 않은 땅이고, 1은 배추가 심어져 있는 땅
// 각 테스트 케이스에 대해 필요한 최소의 배추흰지렁이 마리 수 출력
public class Main_bj_s2_1012_유기농배추_bfs {
	static int M,N,K,answer;//배추밭의 가로길이,세로길이,배추가 심어져 있는 위치의 개수,최소의 배추흰지렁이 마리 수
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {0,-1,0,1};
	static int[] dc = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[M][N];
			visited = new boolean[M][N];
			
			int start_r=0, start_c=0;
			
			for(int k=0;k<K;k++) {
				st = new StringTokenizer(br.readLine()," ");
				if(k==0) {
					start_r=Integer.parseInt(st.nextToken());
					start_c=Integer.parseInt(st.nextToken());
					map[start_r][start_c]=1;
				}else {					
					map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=1;
				}
			}
			answer = 0;//첫 배추흰지렁이
			
			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++) {
					if(!visited[i][j] && map[i][j]==1) {
						bfs(i,j);
						answer++;
					}
				}
			}
			sb.append(answer).append('\n');
		}
		br.close();
		System.out.print(sb.toString());
	}
	
	static void bfs(int start_r, int start_c) {
		Queue<int[]> q = new LinkedList<>();
		visited[start_r][start_c] = true;
		q.offer(new int[] {start_r,start_c});
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int d=0;d<4;d++) {//주변 사방 탐색
				int nr=tmp[0]+dr[d];
				int nc=tmp[1]+dc[d];
				
				if(check(nr,nc) && !visited[nr][nc] && map[nr][nc]==1) {
					q.offer(new int[] {nr,nc});
					visited[nr][nc]=true;
				}
			}
		}
	}
	
	static boolean check(int r, int c) {//배열 범위 체크
		if(r<0 || c<0 || r>=M || c>=N) return false;
		return true;
	}
}
