import java.io.*;
import java.util.*;
//가장 바깥 쪽의 치즈는 한 시간 후 녹아 없어짐
//외부공기, 내부공기, 치즈로 나눠서 계산
public class Main_bj_2636_치즈 {
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static int[] di= {1,0,-1,0};//우 상 좌 하
	static int[] dj= {0,1,0,-1};
	static int height, width, cnt, answer_cnt, time; //세로, 가로
	static int[][] arr;
	static boolean[][] visited;
	static Queue<Node> q = new LinkedList<>();//녹을 예정인 치즈를 담음
	static Queue<Node> air = new LinkedList<>();
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2636.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		arr = new int[height][width];
		cnt=0;
		time=0;
		for(int i=0;i<height;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<width;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) cnt++;//치즈 개수
			}
		}
		
		while(cnt>0) {//치즈가 남아있으면
			visited=new boolean[height][width];
			time++;
	
			bfs();//외부공기를 -1로
			
			for(int i=0;i<height;i++) {
				for(int j=0;j<width;j++) {
					if(arr[i][j]==1) {
						for(int d=0;d<4;d++) {//외부 공기와 한 면이라도 맞닿는다면 녹일 수 있음
							int dx=i+di[d];
							int dy=j+dj[d];
							if(dx>=0 && dx<height && dy>=0 && dy<width && arr[dx][dy]==-1 && !visited[i][j]) {
								visited[i][j]=true;
								q.add(new Node(i,j));
							}
						}
					}
				}
			}
			answer_cnt=cnt;//녹이기 연산 전의 치즈 개수
			
			while(!q.isEmpty()) {//치즈를 녹이는 과정
				Node tmp = q.poll();
				arr[tmp.x][tmp.y]=-1;//녹인 좌표는 외부 공기로
				cnt--;//치즈 개수 감소
			}
			if(cnt==0) break;
		}
		br.close();
		System.out.println(time);
		System.out.print(answer_cnt);
	}
	
	static void bfs() {
		Queue<Node> bfs_q = new LinkedList<>();
		boolean[][] bfs_visited=new boolean[height][width]; 
		bfs_q.add(new Node(0,0));
		bfs_visited[0][0]=true;
		arr[0][0]=-1;
		
		while(!bfs_q.isEmpty()) {
			Node bfs_n = bfs_q.poll();
			for(int d=0;d<4;d++) {
				int dx=bfs_n.x+di[d];
				int dy=bfs_n.y+dj[d];
				if(dx>=0 && dx<height && dy>=0 && dy<width && arr[dx][dy]!=1 && !bfs_visited[dx][dy]) {
					bfs_visited[dx][dy]=true;
					arr[dx][dy]=-1;
					bfs_q.add(new Node(dx,dy));
				}
			}
		}
	}
}
