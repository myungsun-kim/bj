import java.io.*;
import java.util.*;

public class Main_bj_10871_X보다작은수 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n, x, tmp;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			tmp = Integer.parseInt(st.nextToken());
			if(tmp<x) sb.append(tmp).append(" ");
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}