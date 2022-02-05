import java.io.*;
import java.util.*;

public class Main_bj_b1_9093_단어뒤집기 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_9093.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine()); //테스트 케이스 개수
		for(int tc=0;tc<t;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			while(st.hasMoreTokens()) {
				String tmp = st.nextToken();
				for(int i=tmp.length()-1;i>=0;--i) {
					sb.append(tmp.charAt(i));
				}
				sb.append(' ');
			}
			sb.append('\n');
		}
		br.close();
		System.out.print(sb.toString());
	}
}
