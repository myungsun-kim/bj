import java.io.*;
import java.util.*;
//제일 왼쪽 위 칸의 지점에서 제일 오른쪽 아래 칸으로 이동하려고 함
//각 지점 사이의 이동은 상하좌우 이웃한 곳끼리만 가능
//높이가 더 낮은 지점으로만 이동하여 목표지점까지 가고자 함
//지도가 주어질 때 이와 같이 제일 왼쪽 위 지점에서 출발하여 제일 오른쪽 아래 지점까지 항상 내리막길로만 이동하는 경로의 개수 구하기
public class Main_bj_g4_1520_내리막길 {
	static int[] dr= {1,0,-1,0};
	static int[] dc= {0,-1,0,1};
	static int M, N;
	static int[][] map, memo;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1520.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		map = new int[M][N];
		memo = new int[M][N];
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				memo[i][j]=-1;//초기화
			}
		}
		
		System.out.print(find(0,0));
		br.close();
	}
	
	
	static int find(int row,int col) {
		if(row == M-1 && col == N-1) {//마지막점에 도착하는 경우
			return 1;
		}
		
		if(memo[row][col]!=-1) return memo[row][col];
		
		memo[row][col]=0; //현재 위치에서 끝점까지 경로 개수	
		for(int d=0;d<4;d++) {
			int nr=row+dr[d];			
			int nc=col+dc[d];
			if(check(nr,nc) && map[row][col] > map[nr][nc]) {
				memo[row][col]+=find(nr,nc);
			}
		}
		return memo[row][col];
	}
	
	static boolean check(int row, int col) {
		if(row<0 || col<0 || row>=M || col>=N) return false;
		return true;
	}
}
