import java.io.*;
import java.util.*;

public class Main_bj_2750_수정렬하기 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2750.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		for(int i=0;i<n;i++) {
			sb.append(arr[i]).append("\n");
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}
