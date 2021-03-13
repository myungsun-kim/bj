import java.io.*;
import java.util.*;

public class X_Main_bj_7568_덩치 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_7568.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];//사람들의 키와 몸무게를 저장
		int[] grade = new int[n]; //등수 저장
		int weight=0, height=0;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<n;i++) {
			if(arr[i][0]>weight && arr[i][1]>height) {
				weight = arr[i][0];
				height = arr[i][1];
				grade[i] = 1;
			}else if(arr[i][0]>weight || arr[i][1]>height) {
				weight = arr[i][0];
				height = arr[i][1];
				grade[i] = 1;
			}else {
				
			}
		}
	}
}
