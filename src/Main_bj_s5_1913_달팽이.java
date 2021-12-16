import java.io.*;
import java.util.*;
// 가운데부터 달팽이 모양으로 채워감
public class Main_bj_s5_1913_달팽이 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1913.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int A = Integer.parseInt(br.readLine()); //출력할 좌표. N^2이하의 자연수

		int[] dr= {-1,0,1,0}; //행,열 이동
		int[] dc= {0,1,0,-1};
		
		int[][] arr = new int[N][N];
		int start = N/2;
		
		int r=start;
		int c=start; //시작할 행,열의 위치
		int v=1;//시작값. 1부터 시작
		arr[r][c]=v;
		
		int answer_r=0;//A좌표
		int answer_c=0;
		
		for(int i=1;i<N;i++) {
			int range;//범위를 선택할 변수
			if(i%2==1) {
				range=0;
			}else {
				range=2;				
			}
			for(int d=range;d<range+2;d++) {
				for(int j=1;j<=i;j++) {					
					r+=dr[d];
					c+=dc[d];
					arr[r][c]=++v;
				}
			}
		}
		
		for(int i=0;i<N-1;i++) { //마지막 표 출력
			arr[--r][c]=++v;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]==A) {
					answer_r=i+1;
					answer_c=j+1;
				}
				sb.append(arr[i][j]).append(' ');
			}sb.append('\n');
		}
		sb.append(answer_r).append(' ').append(answer_c);
		br.close();
		System.out.print(sb);
	}	
}
