import java.io.*;
import java.util.*;

public class Main_bj_2675_문자열반복 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2675.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int n;
		String input;
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			input = st.nextToken();
			for(int i=0;i<input.length();i++) {
				for(int j=0;j<n;j++) {
					sb.append(input.charAt(i));
				}
			}
			sb.append("\n");
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
