import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_bj_5972_택배배송 {
	private static class Node implements Comparable<Node> {
		private int index;
		private int cost;
		
		Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}
		
		
	}
	
	static ArrayList<Node>[] list;
	static int[] dist;
	static int n;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_5972.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		dist = new int[n+1];
		list = new ArrayList[n+1];
		
		for(int i=1;i<=n;++i) list[i] = new ArrayList<>();
		for(int i=0;i<m;++i) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, count));
			list[end].add(new Node(start, count));
		}
		Arrays.fill(dist, Integer.MAX_VALUE);
		dijkstra();
		System.out.print(dist[n]);
	}

	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>(); 
		boolean[] visited = new boolean[n+1];
		dist[1] = 0;
		pq.offer(new Node(1,0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(!visited[cur.index]) {
				visited[cur.index] = true;
				
				for(int i=0;i<list[cur.index].size();++i) {
					Node next = list[cur.index].get(i);
					if(dist[next.index] > dist[cur.index] + next.cost) {
						dist[next.index] = dist[cur.index] + next.cost;
						pq.offer(new Node(next.index, dist[next.index]));
					}
				}
			}
		}
	}
}
