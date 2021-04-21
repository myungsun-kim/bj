import java.io.*;
import java.util.*;

public class Main_bj_b3_2739_구구단 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i=1;i<=9;i++) {
			sb.append(N).append(" * ").append(i).append(" = ").append(N*i).append("\n");
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}