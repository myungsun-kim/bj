import java.io.*;
import java.util.*;

public class Main_bj_1152_단어의개수 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1152.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt=0;
		while(st.hasMoreTokens()) {
			st.nextToken();
			cnt++;
		}
		System.out.print(cnt);
	}
}
