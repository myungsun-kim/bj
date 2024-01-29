import java.io.*;
import java.util.*;

public class Main_bj_16948_데스나이트 {
	static int[] dr= {-2,-2,0,0,2,2};//이동할 수 있는 범위
	static int[] dc= {-1,1,-2,2,-1,1};
	static int N, answer;
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_16948.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		int start_r=Integer.parseInt(st.nextToken());
		int start_c=Integer.parseInt(st.nextToken());
		int end_r=Integer.parseInt(st.nextToken());
		int end_c=Integer.parseInt(st.nextToken());
		
		answer=-1;
		
		//시작점과 도착점의 행 차이가 홀수이면 이동할 수 없음
		if((end_r-start_r)%2==0) {			
			bfs(start_r,start_c,end_r,end_c);
		}
		System.out.print(answer);
	}
	
	static void bfs(int start_r, int start_c, int end_r, int end_c) {
		Queue<Node> q= new LinkedList<>();
		q.offer(new Node(start_r,start_c,0));
		boolean[][] visited=new boolean[N][N];
		visited[start_r][start_c]=true;

		while(!q.isEmpty()) {
			Node tmp = q.poll();
			
			if(tmp.r == end_r && tmp.c == end_c) {//도착점 도달
				answer=tmp.cnt;
				return;
			}
			
			for(int d=0;d<6;d++) {
				int nr=tmp.r+dr[d];
				int nc=tmp.c+dc[d];
				
				if(check(nr,nc) && !visited[nr][nc]) {
					q.offer(new Node(nr,nc,tmp.cnt+1));
					visited[nr][nc]=true;
				}
			}
		}
	}
	
	static boolean check(int r, int c) {
		if(r<0 || c<0 || r>=N || c>=N) return false;
		return true;
	}
	
	static class Node{
		int r, c, cnt;

		public Node(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}