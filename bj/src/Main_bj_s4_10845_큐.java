import java.io.*;
import java.util.*;

public class Main_bj_s4_10845_큐 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_10845.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push":
				queue.offer(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(!queue.isEmpty()) {
					sb.append(queue.poll());
				}else {
					sb.append(-1);
				}
				sb.append("\n");
				break;
			case "size":
				sb.append(queue.size()).append("\n");
				break;
			case "empty":
				if(queue.isEmpty()) {
					sb.append(1);
				}else {
					sb.append(0);
				}
				sb.append("\n");
				break;
			case "front":
				if(!queue.isEmpty()) {
					sb.append(queue.peek());
				}else {
					sb.append(-1);
				}
				sb.append("\n");
				break;
			case "back":
				if(!queue.isEmpty()) {
					for(int j=0;j<queue.size()-1;j++) {
						queue.offer(queue.poll());
					}
					sb.append(queue.peek());
					queue.offer(queue.poll());
				}else {
					sb.append(-1);
				}
				sb.append("\n");
				break;
			}
		}
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}
