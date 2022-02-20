import java.io.*;
import java.util.*;

public class Main_bj_1110_더하기사이클 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int a,b,tmp,cnt=0;
		int n = Integer.parseInt(br.readLine());
		tmp = n;
		while(true) {
			tmp=10*(tmp-tmp/10*10)+(tmp/10+(tmp-tmp/10*10))%10;
			++cnt;
			if(n==tmp) break;
		}
		br.close();
		sb.append(cnt);
		System.out.print(sb);
	}
}
