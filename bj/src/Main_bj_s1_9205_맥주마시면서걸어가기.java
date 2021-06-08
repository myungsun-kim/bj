import java.io.*;
import java.util.*;

public class Main_bj_s1_9205_맥주마시면서걸어가기 {
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static int n, x, home_x, home_y, rock_x, rock_y;
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_9205.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			n=Integer.parseInt(br.readLine());
			visited=new boolean[n+2];
			map = new int[n+2][2];
			
			for(int i=0;i<n+2;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				if(i==0) {
					home_x=Integer.parseInt(st.nextToken());
					home_y=Integer.parseInt(st.nextToken());
					map[i][0]=home_x;
					map[i][1]=home_y;
				}else if(i==n+1) {
					rock_x=Integer.parseInt(st.nextToken());
					rock_y=Integer.parseInt(st.nextToken());					
					map[i][0]=rock_x;
					map[i][1]=rock_y;
				}else {
					map[i][0]=Integer.parseInt(st.nextToken());
					map[i][1]=Integer.parseInt(st.nextToken());					
				}
			}

			sb.append(bfs()).append("\n");
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
	
	static String bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(home_x,home_y));
		visited[0]=true;

		while(!q.isEmpty()) {
			Node temp = q.poll();
			
			if(temp.x==rock_x && temp.y==rock_y) {
				return "happy";
			}
			for(int i=1;i<n+2;i++) {
				if(!visited[i] && Math.abs(map[i][0]-temp.x)+Math.abs(map[i][1]-temp.y)<=1000) {//맥주 20병을 마시기 전에 도착					
					visited[i]=true;
					q.add(new Node(map[i][0],map[i][1]));
				}
			}
		}
		return "sad";
	}
	
}
