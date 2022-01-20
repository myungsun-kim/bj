import java.io.*;
import java.util.*;
// 캠핑장은 연속하는 p일 중 l일 동안만 사용할 수 있다. 이제 막 v일짜리 휴가를 시작했을때
// 캠핑장을 최대 며칠동안 사용할 수 있을까?
public class Main_bj_s5_4796_캠핑 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_4796.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = 0;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int l = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			if(l==0 && p==0 && v==0) break;
			int answer = v/p*l+((v%p)<l?v%p:l);
			sb.append("Case ").append(++tc).append(": ").append(answer).append('\n');
		}
		br.close();
		System.out.print(sb.toString());
	}
}
