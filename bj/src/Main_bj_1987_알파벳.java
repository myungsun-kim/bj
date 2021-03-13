import java.io.*;
import java.util.*;

public class Main_bj_1987_알파벳 {
	static int R,C,max;
	static char[][] board;
	static int[] di = {-1,1,0,0};//상하좌우
	static int[] dj = {0,0,-1,1};
	static boolean[] visited;
	//말은 같은 알파벳이 적힌 칸을 두 번 지날 수 없음
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1987.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][];
		visited = new boolean[27]; // 알파벳-64 > 1~26 0번 인덱스 사용 X
		for(int i=0;i<R;i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		max = Integer.MIN_VALUE;
		visited[board[0][0]-64]=true;
		dfs(0,0,1);
		System.out.println(max);
	}
	
	static void dfs(int row, int col, int count) {
		if(max<count) max=count;
		
		for(int i=0;i<4;i++) {
			int dx = row+di[i];//행
			int dy = col+dj[i];//열
			if(dx<0 || dx>=R || dy<0 || dy>=C || visited[board[dx][dy]-64]) continue;
			visited[board[dx][dy]-64]=true;
			dfs(dx,dy,count+1);
			visited[board[dx][dy]-64]=false;
		}
	}
}
