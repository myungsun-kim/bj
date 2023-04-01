import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_bj_7576_토마토 {
	static int n, m;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_7576.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		m=Integer.parseInt(st.nextToken());//열의 개수 6
	    n=Integer.parseInt(st.nextToken());//행의 개수 4
		int[][] storage=new int[n][m];
		Queue<int[]> q = new LinkedList<>();
		int[] dr = {0,1,0,-1};
		int[] dc = {1,0,-1,0};
		int answer = -1;
		int empty=0;
		int tomato=0;

		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<m;j++) {
				storage[i][j]=Integer.parseInt(st.nextToken());
				if(storage[i][j]==1) {
					q.offer(new int[] {i,j,0});//익은 토마토의 경우 큐에 저장
					++tomato;//익은 토마토 개수 카운트
				}
				if(storage[i][j]==-1) ++empty;
			}
		}
		
		int total=n*m-empty;
		
		if(total==tomato) {
			answer=0;
		}else {			
			while(!q.isEmpty()) {
				int[] cur=q.poll();
				for(int d=0;d<4;d++) {
					int nx=cur[0]+dr[d];
					int ny=cur[1]+dc[d];
					int nday=cur[2]+1;//대신 q 사이즈를 이용하는 방법도 있음
					
					if(check(nx,ny) && storage[nx][ny]==0) {
						storage[nx][ny]=1;
						tomato++;
						q.offer(new int[] {nx,ny,nday});
					}
				}
				if(tomato==total) {
					answer=cur[2]+1;
					break;
				}
			}
		}
		br.close();
		System.out.print(answer);
	}
	
	static boolean check(int x,int y) {
		if(x<0 || y<0 || x>=n || y>=m) return false;
		return true;
	}
}
