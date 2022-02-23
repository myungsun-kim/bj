import java.io.*;
import java.util.*;

public class Main_bj_10817_세수 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_10817.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int count = 3;
		int[] arr = new int[count];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<arr.length;i++) arr[i] = Integer.parseInt(st.nextToken());
		br.close();
		Arrays.sort(arr);
		System.out.print(arr[1]);
	}
}
