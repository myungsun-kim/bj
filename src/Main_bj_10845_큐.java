import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_bj_10845_큐 {
	static int[] queue;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_10845.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int range = 10000;
		queue = new int[range+1];
		int idx = 0;
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push":
				queue[idx++] = Integer.parseInt(st.nextToken());
				break;
			case "pop":
				if(idx>0) {
					sb.append(queue[0]);
					pull(idx--);
				}else {
					sb.append(-1);
				}
				sb.append("\n");
				break;
			case "size":
				sb.append(idx).append("\n");
				break;
			case "empty":
				if(idx>0) {
					sb.append(0);
				}else {
					sb.append(1);
				}
				sb.append("\n");
				break;
			case "front":
				if(idx>0) {
					sb.append(queue[0]);
				}else {
					sb.append(-1);
				}
				sb.append("\n");
				break;
			case "back":
				if(idx>0) {
					sb.append(queue[idx-1]);
				}else {
					sb.append(-1);
				}
				sb.append("\n");
				break;
			}
		}
		System.out.print(sb);
	}
	
	static void pull(int idx) {
		for(int i=0;i<idx-1;i++) {
			queue[i] = queue[i+1];
		}
		queue[idx] = 0;
	}
}
