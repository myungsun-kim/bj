import java.io.*;
import java.util.*;
// 광고를 해야 하면 "advertise", 하지 않아야 하면 "do not advertise", 광고를 해도 수익이 차이가 없다면 "does not matter"를 출력
public class Main_bj_5063_TGN {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_5063.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for(int tc=0;tc<n;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int r = Integer.parseInt(st.nextToken()); // 광고를 하지 않았을시 수익
			int e = Integer.parseInt(st.nextToken()); // 광고를 했을 때의 수익
			int c = Integer.parseInt(st.nextToken()); // 광고 비용
			
			if(r>e-c) {
				sb.append("do not advertise");
			}else if(r<e-c) {
				sb.append("advertise");
			}else {
				sb.append("does not matter");				
			}
			sb.append('\n');
		}
		br.close();
		System.out.print(sb.toString());
	}
}
