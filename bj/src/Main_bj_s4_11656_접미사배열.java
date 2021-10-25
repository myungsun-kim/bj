import java.io.*;
import java.util.*;

public class Main_bj_s4_11656_접미사배열 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_11656.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] arr = new String[s.length()];
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<s.length();i++) {
			arr[i] = s.substring(i);
		}

		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) sb.append(arr[i]).append('\n');
		br.close();
		System.out.print(sb.toString());
	}
}
