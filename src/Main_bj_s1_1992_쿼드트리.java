import java.io.*;
import java.util.*;

public class Main_bj_s1_1992_쿼드트리 {
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1992.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		String tmp;
		for(int i=0;i<N;i++) {//배열 입력
			tmp = br.readLine();
			for(int j=0;j<N;j++) {
				arr[i][j] = tmp.charAt(j) - '0';
			}
		}	
		comp(0, 0, N);
		
		System.out.println(sb);
	}
	
	static void comp(int x, int y, int n) {//x첫인덱스,y첫인덱스,배열의크기
		if(n==1) {//가장 작은 배열
			sb.append(arr[x][y]);
			return;
		}
		
		int init = arr[x][y];//초기값 0 또는 1
		boolean chk = check(x, y, n, init);
		if(chk) {
			sb.append(init);
			return;
		}
		
		sb.append("(");
		comp(x,y,n/2);//1사분면
		comp(x,y+n/2,n/2);//2사분면
		comp(x+n/2,y,n/2);//3사분면
		comp(x+n/2,y+n/2,n/2);//4사분면
		sb.append(")");
		
	}

	static boolean check(int x, int y, int n, int init) {
		for(int i=x;i<x+n;i++) {
			for(int j=y;j<y+n;j++) {
				if(arr[i][j] != init) {
					return false;
				}
			}
		}
		return true;
	}
}
