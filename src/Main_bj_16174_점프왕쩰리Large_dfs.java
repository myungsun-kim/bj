import java.io.*;
import java.util.*;

public class Main_bj_16174_점프왕쩰리Large_dfs {
	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = { 1, 0 };// 오른쪽,아래쪽
	static int[] dy = { 0, 1 };
	static int N;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input_bj_16174.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		dfs(0, 0);
		System.out.println("Hing");
	}

	static void dfs(int x, int y) {
		visited[x][y] = true;
		if (map[x][y] == -1) {
			System.out.print("HaruHaru");
			System.exit(0);
		}
		for (int d = 0; d < 2; d++) {
			int nx = x + dx[d] * map[x][y];
			int ny = y + dy[d] * map[x][y];

			if (nx < N && ny < N && !visited[nx][ny]) {
				dfs(nx, ny);
			}
		}
	}
}
