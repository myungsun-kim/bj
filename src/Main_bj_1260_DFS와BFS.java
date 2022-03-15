import java.io.*;
import java.util.*;

public class Main_bj_1260_DFS와BFS {
	static int n,m,v;
	static boolean[][] matrix;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1260.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //정점의 개수
		m = Integer.parseInt(st.nextToken()); //간선의 개수
		v = Integer.parseInt(st.nextToken()); //탐색을 시작할 정점의 번호
		matrix = new boolean[n+1][n+1];
		visited = new boolean[n+1];
		
		int from, to;
		for(int i=0;i<m;i++) {//간선이 연결하는 두 정점의 번호
			st = new StringTokenizer(br.readLine()," ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			matrix[from][to]=matrix[to][from]=true;
		}
		
		dfs(v);
		sb.setLength(sb.length()-1);
		sb.append("\n");
		bfs();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}

	static void dfs(int current) {
		visited[current]=true;
		sb.append(current).append(" ");//현재 정점에 대한 처리
		
		for(int i=1;i<=n;i++) {
			if(matrix[current][i] && !visited[i]) {
				dfs(i);
			}
		}
	}
	
	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		visited = new boolean[n+1];
		queue.offer(v);
		visited[v] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current).append(" ");//현재 정점에 대한 처리
			
			for(int i=1;i<=n;i++) {
				if(matrix[current][i] && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}
