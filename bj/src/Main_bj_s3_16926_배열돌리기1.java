import java.io.*;
import java.util.*;

public class Main_bj_16926_배열돌리기1 {
	//주어지는 배열에 따라 돌려야하는 개수가 달라짐. 이는 행, 열 중 낮은 값을 2로 나누면 구할 수 있음
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_16926.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //배열의 행의 크기
		int M = Integer.parseInt(st.nextToken()); //배열의 열의 크기
		int R = Integer.parseInt(st.nextToken()); //수행해야하는 회전의 수. 회전은 반시계 방향으로 돔
//		int tmp;
		int[][] arr = new int[N][M];
		int[][] tmp = new int[N][M];
		
		for(int i=0;i<N;i++) {//배열에 값을 입력
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int loop = Math.min(N, M)/2;
		// 00 01 02 03 04		01 02 03 04 14	00 01 02 03		01 02 03 13		00 01 02 03 04		01 02 03 04 14
		// 10 11 12 13 14		00 12 13 23 24	10 11 12 13		00 12 22 23		10 11 12 13 14		00 12 13 23 24
		// 20 21 22 23 24		10 11 22 33 34	20 21 22 23		10 11 21 33		20 21 22 23 24		10 11 21 22 34
		// 30 31 32 33 34		20 21 31 32 44	30 31 32 33		20 30 31 32		30 31 32 33 34		20 30 31 32 33
		// 40 41 42 43 44 		30 40 41 42 43
		//	ㅡ 열 +1(j+1) j+1>M i+1/j
		//|행-1(i-1) i-1<0 i/j+i		|행+1(i+1) i+1>N i/j-1
		//	  ㅡ열 -1(j-1) j-1<0 i-1/j
		for(int r=0;r<R;r++) {//r번 회전
			tmp = arr;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(j+1<M) {
						arr[i][j] = tmp[i][j+1];
					}else if(i+1<N){
						arr[i][j] = tmp[i+1][j];
					}else {
						arr[i][j] = tmp[i][j-1];
					}
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					System.out.print(arr[i][j]+" ");
				}System.out.println();
			}
		}
	}
}
