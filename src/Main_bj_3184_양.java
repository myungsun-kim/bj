import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 마당은 행과 열로 이루어진 직사각형 모양
// 글자 '.' (점)은 빈 필드를 의미하며, 글자 '#'는 울타리를, 'o'는 양, 'v'는 늑대
// 한 칸에서 수평, 수직만으로 이동
// 울타리를 지나지 않고 다른 칸으로 이동할 수 있다면, 두 칸은 같은 영역 안에 속해 있다
// 마당에서 "탈출"할 수 있는 칸은 어떤 영역에도 속하지 않는다고 간주한다.
// 영역 안의 양의 수가 늑대의 수보다 많다면 이기고, 늑대를 우리에서 쫓아낸다. 
// 그렇지 않다면 늑대가 그 지역 안의 모든 양을 먹는다.
// 아침이 도달했을 때 살아남은 양과 늑대의 수를 출력하는 프로그램을 작성

public class Main_bj_3184_양 {
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static int row, col, wolf, sheep;
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_3184.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];

		for(int i=0;i<row;i++) {
			String tmp = br.readLine();
			for(int j=0;j<col;j++) {
				switch(tmp.charAt(j)) {
				case '.': //빈 필드
					map[i][j] = 0;
					break;
				case 'o': //양
					map[i][j] = 1;
					++sheep;
					break;
				case 'v': //늑대
					map[i][j] = 2;
					++wolf;
					break;
				case '#': //울타리
					map[i][j] = 3;
					break;
				}
			}
		}
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {				
				if(map[i][j]<3) {
					bfs(i,j);
				}
			}
		}
		
		br.close();
		System.out.print(sheep+" "+wolf);
	}
	
	static void bfs(int curRow, int curCol) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {curRow, curCol}); //출발점
		int curWolf = 0, curSheep = 0;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int d=0;d<4;d++) {
				int nr = tmp[0]+dr[d];
				int nc = tmp[1]+dc[d];
				
				if(check(nr,nc) && map[nr][nc]<3) {
					if(map[nr][nc] == 1) ++curSheep;
					if(map[nr][nc] == 2) ++curWolf;
					q.offer(new int[] {nr,nc});
					map[nr][nc] = 4; //이미 방문함
				}
			}
		}
		if(curSheep>curWolf) {
			wolf-=curWolf;
		}else {
			sheep-=curSheep;
		}
	}
	
	static boolean check(int row, int col) {
		if(row>=row || col>=col || row<0 || col<0) return false;
		return true;
	}
}
