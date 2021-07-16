import java.io.*;
import java.util.*;
public class Main_bj_s1_16927_배열돌리기2 {
	static int[][] arr;
	static int N,M,R;
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_16927.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken()); //배열의 행의 크기
		M = Integer.parseInt(st.nextToken()); //배열의 열의 크기
		R = Integer.parseInt(st.nextToken()); //수행해야하는 회전의 수. 회전은 반시계 방향으로 돔
		arr = new int[N][M];

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rotate();
		
		for(int i=0;i<N;i++) {//정답 출력
			for(int j=0;j<M;j++) {
				sb.append(arr[i][j]).append(' ');
			}
			sb.setLength(sb.length()-1);
			sb.append('\n');
		}
		br.close();
		System.out.print(sb.toString());
	}
	
	static void rotate() {//반시계 방향으로 한 번 회전하는 경우
		int loop = Math.min(N, M)/2;
		for(int l=0;l<loop;l++) {//바깥에서 안쪽으로 회전
			int size=(N-2*l)*2+(M-2*l)*2-4;//회전하는 배열의 사이즈
			arrCopy(l, N-l-1, l, M-l-1, R%size);//회전할 배열의 열,행 값 전달. 임시배열에 표시
		}
	}
	
	static void arrCopy(int row_start, int row_end, int col_start, int col_end, int loop) {//임시배열에 회전된 값 저장
		for(int l=0;l<loop;l++) {			
			int tmp = arr[row_start][col_start];
			
			for(int i=col_start;i<col_end;i++) {
				arr[row_start][i]=arr[row_start][i+1];
			}
			for(int i=row_start;i<row_end;i++) {
				arr[i][col_end]=arr[i+1][col_end];
			}
			for(int i=col_end;i>col_start;i--) {
				arr[row_end][i]=arr[row_end][i-1];
			}
			for(int i=row_end;i>row_start;i--) {
				arr[i][col_start]=arr[i-1][col_start];
			}
			arr[row_start+1][col_start]=tmp;
		}
	}
}
