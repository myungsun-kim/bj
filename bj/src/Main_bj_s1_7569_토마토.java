import java.io.*;
import java.util.*;
// 가로 M, 세로 N, 높이 H인 창고에 토마토를 보관한다. 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다
// 인접한 곳은 위,아래,왼쪽,오른쪽,앞,뒤 여섯 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며 토마토가 혼자 저절로 익는 경우는 없다고 가정한다
// 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지 최소 일수를 구한다
// 1은 익은 토마토, 0은 익지 않은 토마토, -1은 토마토가 들어있지 않은 칸
public class Main_bj_s1_7569_토마토 {
	static int[] dr = {-1,0,1,0,0,0}; 
	static int[] dc = {0,-1,0,1,0,0};
	static int[] dl = {0,0,0,0,-1,1};
	static int N,M,H;
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_7569.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());//가로
		M = Integer.parseInt(st.nextToken());//세로
		H = Integer.parseInt(st.nextToken());//상자의 수
		
		int[][][] arr = new int[N][M][H];
		
		Queue<int[]> q = new LinkedList<>(); //bfs를 위한 큐
		
		int greenTomato = 0;//익지 않은 토마토 개수
		
		for(int k=0;k<H;k++) {
			for(int j=0;j<M;j++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int i=0;i<N;i++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					if(arr[i][j][k]==1) q.offer(new int[] {i,j,k,0}); //익은 토마토가 있는 위치 저장
					if(arr[i][j][k]==0) greenTomato++;
				}
			}
		}
		
		int answer=0; //며칠이 지났는지 체크
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int d=0;d<6;d++) {//한 토마토가 주변 토마토를 익게 만듦
				int nr=tmp[0]+dr[d];
				int nc=tmp[1]+dc[d];
				int nl=tmp[2]+dl[d];
				int nd=tmp[3];
				
				if(check(nr,nc,nl) && arr[nr][nc][nl]==0) {// 인접한 위치에 안익은 토마토가 있다면
					arr[nr][nc][nl]=1; //토마토가 익게 함
					greenTomato--; //익지 않은 토마토 개수 줄어듦
					q.offer(new int[] {nr,nc,nl,nd+1});
				}
			}
			if(q.isEmpty()) answer=tmp[3];
		}
		if(greenTomato==0) System.out.print(answer);
		else System.out.print(-1);//익지 않은 토마토가 있음
	}
	
	static boolean check(int r, int c, int l) {// 배열 범위 벗어나지 않도록 체크
		if(r<0 || c<0 || l<0 || r>=N || c>=M || l>=H) return false;
		return true;
	}
}
