import java.io.*;
import java.util.*;
// 방향 없는 그래프가 주어졌을 때 연결 요소의 개수 구하기
// 연결 요소: 연결 요소에 속한 모든 정점을 연결하는 경로가 있어야한다
//			또 다른 연결 요소에 속한 정점과 연결하는 경로가 있으면 안된다
//			서로 연결되어 있는 여러 개의 고립된 부분 그래프 각각을 연결 성분이라고 부름
// 간선 정보가 없는 노드도 연결 요소로 포함. (1<=u,v<=N,u!=v)로 인해 무조건 1부터 N까지 순서대로 노드 존재
// 연결요소 > dfs나 bfs로 탐색

public class Main_bj_11724_연결요소의개수_bfs {
	static boolean[][] graph;
	static boolean[] visited;
	static int N, answer;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_11724.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());//정점의 개수
		int M = Integer.parseInt(st.nextToken());//간선의 개수
		graph = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		for(int m=0;m<M;m++) {
			st=new StringTokenizer(br.readLine()," ");
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			graph[start][end]=graph[end][start]=true;
		}
		
		for(int i=1;i<=N;i++) {
			if(visited[i]) continue;
			bfs(i);
			answer++;
		}
		br.close();
		System.out.print(answer);
	}
	
	static void bfs(int start) {
		Queue<Integer> q= new LinkedList<>();
		q.offer(start);
		visited[start]=true;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int i=1;i<=N;i++) {
				if(graph[tmp][i] && !visited[i]) {
					q.offer(i);
					visited[i]=true;
				}
			}
		}
	}
}
