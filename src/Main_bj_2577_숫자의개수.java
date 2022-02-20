import java.util.*;
import java.io.*;

public class Main_bj_2577_숫자의개수 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2577.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		String multi = Integer.toString(A*B*C);
		int[] cnt = new int[10];
		for(int i=0;i<multi.length();i++) {
			cnt[multi.charAt(i)-'0']++;
		}
		for(int i=0;i<10;i++) {
			sb.append(cnt[i]).append("\n");
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}
