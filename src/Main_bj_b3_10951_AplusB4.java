import java.io.*;
import java.util.*;

public class Main_bj_b3_10951_AplusB4 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int a,b;
		String tmp;
		while((tmp=br.readLine()) != null) {
			st = new StringTokenizer(tmp);
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			sb.append(a+b).append("\n");
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}