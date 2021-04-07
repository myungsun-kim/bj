import java.io.*;
import java.util.*;
//기존 파이프 가로일때 갈 수 있는 방향> +1,+1 / +0,+1
//기존 파이프 세로일때 갈 수 있는 방향> +1,+1 / +1,+0
//기존 파이프 대각선일때 갈 수 있는 방향> +1,+0 / +0,+1 / +1,+1
public class Main_bj_17070_파이프옮기기1 {
	static int N, cnt;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_17070.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map=new int[N+1][N+1];//끝점이 다음 시작점이 됨
		StringTokenizer st;
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		cnt=0;
		
		dfs(1,2,0);
		br.close();
		System.out.print(cnt);
	}
	
	static void dfs(int x, int y, int check) {
		if(x==N && y==N) {
			cnt++;
			return;
		}

		switch(check){
		case 0://현재 가로인 경우
			if(y+1<=N && map[x][y+1]==0) {
				dfs(x,y+1,0);
			}
			break;
		case 1://현재 세로인 경우
			if(x+1<=N && map[x+1][y]==0) {
				dfs(x+1,y,1);
			}
			break;
		case 2://현재 대각선인 경우
			if(y+1<=N && map[x][y+1]==0) {//가로
				dfs(x,y+1,0);
			}
			if(x+1<=N && map[x+1][y]==0) {//세로
				dfs(x+1,y,1);
			}	
			break;
		}
		
		if(x+1<=N && y+1<=N && map[x+1][y]==0 && map[x][y+1]==0 && map[x+1][y+1]==0) {//대각선인 경우 세 구역 확인
			dfs(x+1,y+1,2);
		}
	}
}
