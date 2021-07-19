import java.io.*;
import java.util.*;

public class Main_bj_s5_1158_요세푸스문제 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1158.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayDeque<Integer> arr = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt=1; //반복횟수
		int N = Integer.parseInt(st.nextToken());//N명의 사람
		int K = Integer.parseInt(st.nextToken());//순서대로 K번째 사람 제거
		for(int n=1;n<=N;n++) {
			arr.add(n);
		}
		sb.append("<");
		while(!arr.isEmpty()) {
			if(cnt>0 && cnt%K==0) {
				sb.append(arr.pop()).append(", ");
			}else {
				arr.add(arr.pop());
			}
			cnt++;
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.print(sb);
	}
	
}
