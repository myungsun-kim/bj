import java.io.*;
import java.util.*;

public class Main_bj_16935_배열돌리기3 {
	static int N,M,R;
	static int[][] arr;
	static int[][] chArr;
	static int[][] subArr1;
	static int[][] subArr2;
	static int[][] subArr3;
	static int[][] subArr4;
	static int[] select;
	
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_16935.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		select = new int[R];
		int cnt=0;
		while(st.hasMoreTokens()) {
			select[cnt++] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<R;i++) {//연산 작동
			N = arr.length;
			M = arr[0].length;
			switch(select[i]) {
			case 1:
				oper1();
				break;
			case 2:
				oper2();
				break;
			case 3:
				oper3();
				break;
			case 4:
				oper4();
				break;
			case 5:		
				oper5();
				break;
			case 6:
				oper6();
				break;
			}
		}
		
		for(int i=0;i<chArr.length;i++) {//출력
			for(int j=0;j<chArr[0].length;j++) {
				sb.append(chArr[i][j]+" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
	
	

	static void oper1() {//상하반전
		chArr=new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				chArr[N-i-1][j] = arr[i][j];
			}
		}
//		arr = new int[N][M];
		arr = chArr;
//		relocation();
	}
	
	static void oper2() {//좌우반전
		chArr=new int[N][M];
		for(int i=0;i<N;i++) { 
			for(int j=0;j<M;j++) {
				chArr[i][M-j-1] = arr[i][j];
			}
		}
//		arr = new int[N][M];
		arr = chArr;
//		relocation();
	}
	
	static void oper3() {//오른쪽 90도
		chArr=new int[M][N];
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				chArr[i][j] = arr[N-j-1][i];
			}
		}
		arr = new int[M][N];
		arr = chArr;
//		relocation();
	}
	
	static void oper4() {//왼쪽 90도
		chArr=new int[M][N];
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				chArr[i][j] = arr[j][M-i-1];
			}
		}
		arr = new int[M][N];
		arr = chArr;
//		relocation();
	}
	
	static void oper5() {
		subArr1 = new int[N/2][M/2];
		subArr2 = new int[N/2][M/2];
		subArr3 = new int[N/2][M/2];
		subArr4 = new int[N/2][M/2];
		section();
		chArr=new int[N][M];
		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M/2;j++) {
				chArr[i][j] = subArr2[i][j];
			}
		}
		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M/2;j++) {
				chArr[i][M/2+j] = subArr1[i][j];
			}
		}
		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M/2;j++) {
				chArr[N/2+i][M/2+j] = subArr4[i][j];
			}
		}
		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M/2;j++) {
				chArr[N/2+i][j] = subArr3[i][j];
			}
		}
//		arr = new int[N][M];
		arr = chArr;
//		relocation();

	}
	static void oper6() {
		subArr1 = new int[N/2][M/2];
		subArr2 = new int[N/2][M/2];
		subArr3 = new int[N/2][M/2];
		subArr4 = new int[N/2][M/2];
		section();
		chArr=new int[N][M];
		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M/2;j++) {
				chArr[i][j] = subArr4[i][j];
			}
		}
		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M/2;j++) {
				chArr[i][M/2+j] = subArr3[i][j];
			}
		}
		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M/2;j++) {
				chArr[N/2+i][M/2+j] = subArr2[i][j];
			}
		}
		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M/2;j++) {
				chArr[N/2+i][j] = subArr1[i][j];
			}
		}
//		arr = new int[N][M];
		arr = chArr;
//		relocation();
	}
	
	
	static void section() { //4구간으로 나누기
		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M/2;j++) {
				subArr1[i][j]=arr[i][j];
				
			}
		}
		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M/2;j++) {
				subArr2[i][j]=arr[N/2+i][j];
			}
		}
		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M/2;j++) {
				subArr3[i][j]=arr[N/2+i][M/2+j];
			}
		}
		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M/2;j++) {
				subArr4[i][j]=arr[i][M/2+j];
			}
		}
	}
	
//	static void relocation() {
//		for(int i=0;i<arr.length;i++) {
//			for(int j=0;j<arr[0].length;j++) {
//				arr[i][j] = chArr[i][j];
//			}
//		}
//	}
}
