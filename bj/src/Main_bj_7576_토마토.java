import java.io.*;
import java.util.*;

public class Main_bj_7576_토마토 {
	static int M,N,answer;
	static int[] dx= {0,1,0,-1};//상우하좌
	static int[] dy= {1,0,-1,0};
	static int[][] storage;
	
	static class Node{
		int x;
		int y;
		int day;
		
		public Node(int x, int y, int day) {
			super();
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_7576.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M=Integer.parseInt(st.nextToken());//열의 개수 6
		N=Integer.parseInt(st.nextToken());//행의 개수 4
		storage=new int[N][M];
		Queue<Node> q = new LinkedList<>();
		answer=-1;
		int empty=0;
		int tomato=0;

		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				storage[i][j]=Integer.parseInt(st.nextToken());
				if(storage[i][j]==1) {
					q.offer(new Node(i,j,0));//익은 토마토의 경우 큐에 저장
					tomato++;//익은 토마토 개수 카운트
				}
				if(storage[i][j]==-1) ++empty;
			}
		}
		int total=N*M-empty;
		if(total==tomato) {
			answer=0;
		}else {			
			while(!q.isEmpty()) {
				Node cur=q.poll();
				for(int d=0;d<4;d++) {
					int nx=cur.x+dx[d];
					int ny=cur.y+dy[d];
					int nday=cur.day+1;//대신 q 사이즈를 이용하는 방법도 있음
					
					if(check(nx,ny) && storage[nx][ny]==0) {
						storage[nx][ny]=1;
						tomato++;
						q.offer(new Node(nx,ny,nday));
					}
				}
				if(tomato==total) {
					answer=cur.day+1;
					break;
				}
			}
		}
		br.close();
		System.out.print(answer);
	}
	
	static boolean check(int x,int y) {
		if(x<0 || y<0 || x>=N || y>=M) return false;
		return true;
	}
}
