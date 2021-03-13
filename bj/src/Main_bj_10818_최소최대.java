import java.io.*;
import java.util.*;

public class Main_bj_10818_최소최대 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_10818.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		sb.append(min).append(" ").append(max);
		br.close();
		System.out.print(sb);
	}
}
