import java.io.*;
import java.util.*;
//두 종류의 작업 가능
//1. 좌표(i,j)의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다 > 2초
//2. 인벤토리에서 블록 하나를 꺼내어 좌표 (i,j)의 가장 위에 있는 블록 위에 놓는다 > 1초
//땅의 높이를 모두 동일하게 만들어야함
public class Main_bj_18111_마인크래프트 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_18111.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int B=Integer.parseInt(st.nextToken());//기존 인벤토리에 있는 블록 수
		int[][] map = new int[N][M];
		int min_height=Integer.MAX_VALUE;
		int max_height=0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(min_height>map[i][j]) min_height=map[i][j];//가장 낮은 높이
				if(max_height<map[i][j]) max_height=map[i][j];//가장 높은 높이
			}
		}
		
		int answer_m=Integer.MAX_VALUE;//얼마나 시간이 걸렸는지
		int answer_h=0;
		for(int h=max_height;h>=min_height;--h) {//높이가 될 수 있는 범위 min~max
			int tmp_m=0;//임시시간
			int b_cnt=B;//인벤토리의 블록 개수
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]==h) continue;
					if(map[i][j]>h) {//현재 구역이 주어진 높이보다 큰 경우
						tmp_m+=2*(map[i][j]-h);//블록 한 개당 2초
						b_cnt+=map[i][j]-h;//인벤토리에 블록 추가
					}else {//현재 구역이 주어진 높이보다 작은 경우
						tmp_m+=h-map[i][j];//블록 한 개당 1초
						b_cnt-=h-map[i][j];//인벤토리에서 블록 제거
					}
				}
			}
			if(b_cnt>=0) {//인벤토리의 블록이 0개 이상일시				
				if(answer_m>tmp_m) {
					answer_m=tmp_m;
					answer_h=h;
				}
			}
		}
		br.close();
		sb.append(answer_m).append(" ").append(answer_h);
		System.out.print(sb);
	}
}
