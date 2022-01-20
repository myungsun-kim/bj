import java.io.*;
import java.util.*;

public class Main_bj_b3_2953_나는요리사다 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_2953.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int count = 5;
		int score = 0;
		int num = 0;
		for(int i=1;i<=count;i++) {
			int tmp = 0;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			while(st.hasMoreTokens()) tmp+=Integer.parseInt(st.nextToken());
			if(tmp>score) {
				score = tmp;
				num = i;
			}
		}
		br.close();
		sb.append(num).append(' ').append(score);
		System.out.print(sb.toString());
	}
}
