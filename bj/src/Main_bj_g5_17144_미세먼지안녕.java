import java.io.*;
import java.util.*;

public class Main_bj_g5_17144_미세먼지안녕 {
	static int R,C,T;
	static int[] air;//공기 청정기 위치
	static int[][] map, spread_map;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_17144.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R=Integer.parseInt(st.nextToken());//행
		C=Integer.parseInt(st.nextToken());//열
		T=Integer.parseInt(st.nextToken());//시간
		map=new int[R][C];
		spread_map=new int[R][C];//확산된 양을 저장할 배열
		
		air=new int[2];
		int idx=0;
		for(int i=0;i<R;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<C;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) air[idx++]=i;//공기청정기 위치
			}
		}
		
		for(int i=0;i<T;i++) {//한 초마다 수행되는 행동
			bfs_dust();//미세먼지 확산
			air();//공기 청정기 작동
		}
		br.close();
		System.out.print(count());

	}
	
	static void bfs_dust() {
		Queue<int[]> q=new LinkedList<>();
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]>0) q.offer(new int[] {i,j});//미세먼지가 있는 경우 큐에 넣어줌
			}
		}
	
		while(!q.isEmpty()) {
			int[] cur=q.poll();
			
			int cur_d=map[cur[0]][cur[1]];//현재의 미세먼지 양

			int d_cnt=0;//확산된 방향의 개수
			for(int d=0;d<4;d++) {
				int nx=cur[0]+dx[d];
				int ny=cur[1]+dy[d];
				
				if(check(nx,ny) && map[nx][ny]!=-1) {//범위 내에 있고 공기 청정기가 없는 경우
					d_cnt++;
					spread_map[nx][ny]+=cur_d/5;
				}
			}
			//근처 사방 탐색 후
			map[cur[0]][cur[1]]-=cur_d/5*d_cnt;
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				map[i][j]+=spread_map[i][j];
				spread_map[i][j]=0;
			}
		}
	}
	
	static void air() {
		int[][] tmp_map=new int[R][C];//임시배열 생성
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				tmp_map[i][j]=map[i][j]; 
			}
		}
		
		for(int i=air[0];i>=0;i--) {
			for(int j=0;j<C;j++) {
				if(i==air[0]) {
					if(j==0) continue;//공기청정기
					if(j==1) {
						map[i][j]=0;//정화됨
					}else {
						map[i][j]=tmp_map[i][j-1];
					}
				}else if(j==C-1) {
					map[i][j]=tmp_map[i+1][j];
				}else if(i==0) {
					map[i][j]=tmp_map[i][j+1];
				}else if(j==0) {
					map[i][j]=tmp_map[i-1][j];
				}
			}
		}
		for(int i=air[1];i<R;i++) {
			for(int j=0;j<C;j++) {
				if(i==air[1]) {
					if(j==0) continue;//공기청정기
					if(j==1) {
						map[i][j]=0;//정화됨
					}else {
						map[i][j]=tmp_map[i][j-1];
					}
				}else if(j==C-1) {
					map[i][j]=tmp_map[i-1][j];
				}else if(i==R-1) {
					map[i][j]=tmp_map[i][j+1];
				}else if(j==0) {
					map[i][j]=tmp_map[i+1][j];
				}
			}
		}
	}
	
	static boolean check(int x,int y) {
		if(x<0 || y<0 || x>=R || y>=C) return false;
		return true;
	}
	
	static int count() {
		int sum=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]>0) sum+=map[i][j];
			}
		}
		return sum;
	}
}
