import java.io.*;
import java.util.*;

public class Main_bj_b3_2439_별찍기2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for(int i=1;i<=n;i++) {
			for(int j=n-i;j>0;j--) {
				sb.append(" ");
			}
			for(int j=1;j<=i;j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}