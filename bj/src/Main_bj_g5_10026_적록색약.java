import java.io.*;
import java.util.*;
// 적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못함
// 크기가 NxN인 그리드의 각 칸에 R,G,B 중 하나를 색칠한 그림이 있음
// 그림은 몇 개의 구역으로 나뉘어져 있는데, 구역은 같은 색으로 이루어져 있음
// 같은 색상이 상하좌우로 인접해 있는 경우 두 글자는 같은 구역에 속함
// (색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 함)
// 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램
public class Main_bj_g5_10026_적록색약 {
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static int n;
	static char[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_10026.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		int[] answer=new int[2]; //적록
		for(int i=0;i<n;i++) {			
			String tmp = br.readLine();
			arr[i] = tmp.toCharArray();
		}
	
		for(int d=0;d<2;d++) {
			visited=new boolean[n][n];
			if(d==1) {//적록색약인 경우 G를 R로 변경
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						if(arr[i][j]=='G') {
							arr[i][j]='R';					
						}
					}
				}				
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(!visited[i][j]) {
						if(bfs(i,j)) answer[d]++;						
					}
				}
			}
		}
		
		for(int i=0;i<2;i++) {//정답출력
			System.out.print(answer[i]+" ");
		}
	}
	
	static boolean bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{r,c});
		visited[r][c]=true;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int d=0;d<4;d++) {
				int nr = tmp[0]+dr[d];
				int nc = tmp[1]+dc[d];
				
				if(check(nr,nc) && !visited[nr][nc] && arr[r][c]==arr[nr][nc]) {
					visited[nr][nc]=true;
					q.offer(new int[] {nr,nc});
				}
			}
		}
		return true;
	}
	
	static boolean check(int r, int c) {
		if(r<0 || c<0 || r>=n || c>=n) return false;
		return true;
	}
}
