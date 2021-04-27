import java.io.*;
import java.util.*;

public class Main_bj_b1_10163_색종이 {
	//격자 100X100
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_10163.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] paper = new int[N+1][2]; //색종이의 시작점 저장(가장 왼쪽 아래칸) x,y
		int[][] size = new int[N+1][2]; //색종이의 너비, 높이 저장
		int[][] map = new int[101][101]; //색종이 저장된 배열
		int[] area = new int[N+1]; //색종이의 넓이 저장
		
		for(int n=1;n<=N;n++) {//색종이 정보 입력
			area[n] = 0;
			st = new StringTokenizer(br.readLine());
			paper[n][0] = Integer.parseInt(st.nextToken());
			paper[n][1] = Integer.parseInt(st.nextToken());
			size[n][0] = Integer.parseInt(st.nextToken());
			size[n][1] = Integer.parseInt(st.nextToken());
			
			for(int i=paper[n][0];i<paper[n][0]+size[n][0];i++) {
				for(int j=paper[n][1];j<paper[n][1]+size[n][1];j++) {
					if(map[i][j]!=0) {
						area[map[i][j]]--; //겹칠 경우 크기 감소
					}
					map[i][j] = n;
					++area[n];
				}
			}
			
		}//지도의 paper[n][0],paper[n][1] 부터 
		//paper[n][0]+size[n][0]-1,paper[n][1]+size[n][0]-1
		//너비
		
		for(int n=1;n<=N;n++) {
			sb.append(area[n]).append("\n");
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
		

	}
}
