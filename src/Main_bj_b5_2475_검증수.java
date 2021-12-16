import java.io.*;
import java.util.*;

public class Main_bj_b5_2475_검증수 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2475.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[5];
		int sum=0;
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<arr.length;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			sum+=Math.pow(arr[i], 2);
		}
		br.close();
		System.out.print(sum%10);
	}
}