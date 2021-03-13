import java.io.*;
import java.util.*;

public class Main_bj_2447_별찍기10 {
	static StringBuilder sb = new StringBuilder();
	static boolean[][] arr;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2447.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new boolean[n][n];
		star(0,0,n);
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]) {
					sb.append("*");
				}else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
	
	static void star(int row, int col, int n) {
		if(n==1) {
			arr[row][col] = true;
			return;
		}
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(i==1 && j==1) {
					arr[i][j]=false;
				}else {
					star(row+n/3*i, col+n/3*j, n/3);
				}
			}
		}
	}
}

