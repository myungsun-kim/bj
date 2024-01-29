import java.io.*;
import java.util.*;

public class Main_bj_10867_중복빼고정렬하기 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_10867.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int range = 2000; //-1000~1000
		boolean[] exist = new boolean[range+1];
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			int tmp = Integer.parseInt(st.nextToken())+1000;
			if(!exist[tmp]) exist[tmp]=true;
		}
		for(int i=0;i<exist.length;i++) if(exist[i]) sb.append(i-1000).append(' ');
		sb.setLength(sb.length()-1);
		br.close();
		System.out.print(sb.toString());
	}
}
