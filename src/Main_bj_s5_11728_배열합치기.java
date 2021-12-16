import java.io.*;
import java.util.*;
// 정렬되어있는 두 배열 A와 B가 있음
// 두 배열을 합친 다음 정렬해서 출력하는 프로그램을 작성
public class Main_bj_s5_11728_배열합치기 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_11728.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+m];
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<n+m;i++) {
			if(i==n) st=new StringTokenizer(br.readLine()," ");
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i:arr) {
			sb.append(i).append(' ');
		}
		
		br.close();
		System.out.print(sb.toString()); 
	}
}
