import java.io.*;
import java.util.*;

//0:빈칸 1:벽 2:바이러스
//새로 세울 수 있는 벽의 개수는 3개
//안전 영역:벽을 3개 세운 뒤 바이러스가 퍼질 수 없는 곳
public class Main_bj_14502_연구소_dfs {
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] di= {0,0,-1,1};
	static int[] dj= {1,-1,0,0};
	static int N,M,answer=0;
	static int[][] map;
	static int[][] wall_map;
	static ArrayList<Node> virus = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_14502.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map=new int[N][M];
		wall_map=new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==2) virus.add(new Node(i,j));
			}
		}
		comb(0);
		//바이러스와 인접한 빈칸을 찾고 그 빈칸 중 3개에 벽을 세우고, 그 중 안전 영역의 크기가 가장 큰 경우를 구함
		
		System.out.print(answer);
	}
	
	static void comb(int cnt) {
		if(cnt==3) {
			for(int i=0;i<N;i++) {//배열 복사
				for(int j=0;j<M;j++) {
					wall_map[i][j]=map[i][j];
				}
			}
			//바이러스가 퍼지는 경우 계산
			for(int i=0;i<virus.size();i++) {
				dfs(virus.get(i).x,virus.get(i).y);
			}
			count();//바이러스가 퍼진 후 안전영역 계산
			return;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {//빈칸일때
					map[i][j]=1; //벽을 세우는 경우
					comb(cnt+1);
					map[i][j]=0; //벽을 세우지 않는 경우
				}
			}
		}
	}
	
	static void dfs(int x, int y) {
		wall_map[x][y]=2;
		
		for(int d=0;d<4;d++) {
			int nx=x+di[d];
			int ny=y+dj[d];
			if(nx>=0 && nx<N && ny>=0 && ny<M && wall_map[nx][ny]==0) {
				dfs(nx,ny);
			}
		}
	}
	
	static void count() {
		int safe=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(wall_map[i][j]==0) safe++;
			}
		}
		if(answer<safe) answer=safe;
	}
}
