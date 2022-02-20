import java.io.*;
import java.util.*;

public class Main_bj_10953_AplusB6 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_10953.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine()); //테스트케이스의 수
		for(int tc=0;tc<t;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(),",");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(a+b).append('\n');
		}
		br.close();
		System.out.print(sb.toString());
	}
}
