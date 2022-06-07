import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_bj_10866_덱 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_10866.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> deque = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push_front":
				deque.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				deque.add(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if(!deque.isEmpty()) {
					sb.append(deque.pollFirst());
				}else {
					sb.append(-1);
				}
				sb.append("\n");
				break;
			case "pop_back":
				if(!deque.isEmpty()) {
					sb.append(deque.pollLast());
				}else {
					sb.append(-1);
				}
				sb.append("\n");
				break;
			case "size":
				sb.append(deque.size()).append("\n");
				break;
			case "empty":
				if(deque.isEmpty()) {
					sb.append(1);
				}else {
					sb.append(0);
				}
				sb.append("\n");
				break;
			case "front":
				if(!deque.isEmpty()) {
					sb.append(deque.peekFirst());
				}else {
					sb.append(-1);
				}
				sb.append("\n");
				break;
			case "back":
				if(!deque.isEmpty()) {
					sb.append(deque.peekLast());
				}else {
					sb.append(-1);
				}
				sb.append("\n");
				break;
			}
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}
