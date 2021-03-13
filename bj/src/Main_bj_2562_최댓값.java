import java.io.*;
import java.util.*;

public class Main_bj_2562_최댓값 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2562.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[10];
		int max = 0;
		int index = 0;
		for(int i=1;i<10;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
			if(max==arr[i]) index=i;
		}
		br.close();
		sb.append(max).append("\n").append(index);
		System.out.print(sb);
	}
}
