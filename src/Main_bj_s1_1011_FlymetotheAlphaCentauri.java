import java.io.*;
import java.util.*;

public class Main_bj_s1_1011_FlymetotheAlphaCentauri {
	static int t, min,x,y;
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1011.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		for(int tc=0;tc<t;tc++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
//			select(y-x,1,1);
			int distance = y-x;//거리
			int max = (int)Math.sqrt(distance);//이동가능한최대거리
			if(max==Math.sqrt(distance)) {
				sb.append(max*2-1).append("\n");
			}else if(distance <= max*(max+1)) {
				sb.append(max*2).append("\n");
			}else {
				sb.append(max*2+1).append("\n");
			}
//			sb.append(min).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.print(sb);

		br.close();
	}

//	private static void select(int dis, int k, int cnt) {
//		if(dis<=0 || cnt>=min) return;//범위를 벗어나는 경우
//		if(dis==1 && k==1) {
//			min=Math.min(min, cnt);//최소값계산
//			return;
//		}
//		select(dis-k, k+1, cnt+1);
//		if(k>0) select(dis-k, k, cnt+1);
//		if(k>1) select(dis-k, k-1, cnt+1);	
//	}
	
}
