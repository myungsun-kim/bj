import java.io.*;
import java.util.*;
// 정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다. 섬의 개수를 세는 프로그램 작성
public class Main_bj_s2_4963_섬의개수 {
	static boolean[][] map, visited;
	static int[] dr = {-1,0,1,0,-1,1,-1,1};
	static int[] dc = {0,-1,0,1,-1,1,1,-1};
	static int width, height, count;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_4963.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			width = Integer.parseInt(st.nextToken()); //너비
			height = Integer.parseInt(st.nextToken()); //높이
			if(width==0 && height==0) break;
			map = new boolean[height][width];
			visited = new boolean[height][width];
			count = 0;
			for(int i=0;i<height;i++) { //입력
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<width;j++) {
					int tmp = Integer.parseInt(st.nextToken());
					if(tmp==1) map[i][j]=true;
				}
			}
			
			for(int i=0;i<height;i++) {
				for(int j=0;j<width;j++) {
					if(!visited[i][j] && map[i][j]) bfs(i,j);
				}
			}
			sb.append(count).append('\n');
		}
		br.close();
		System.out.print(sb.toString());
	}
	
	static void bfs(int row, int col) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {row, col});
		visited[row][col] = true;
		count++; //섬의 개수 하나 증가
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int d=0;d<8;d++) {
				int nr = tmp[0]+dr[d];
				int nc = tmp[1]+dc[d];
				if(check(nr,nc) && !visited[nr][nc] && map[nr][nc]) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc});
				}
			}
		}
	}
	
	static boolean check(int row, int col) {
		if(row<0 || row>=height || col<0 || col>=width) return false;
		return true;
	}
}
