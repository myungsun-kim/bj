import java.io.*;
import java.util.*;

public class Main_bj_s4_18258_큐2 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_18258.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //연산의 개수
		StringBuilder sb = new StringBuilder();
		Deque<Integer> q = new ArrayDeque<>();
		for(int i=0;i<N;i++) {			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String oper = st.nextToken();
			switch(oper) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				q.push(num);
				break;
			case "pop":
				if(q.isEmpty()) sb.append(-1);
				else sb.append(q.pollLast());
				sb.append('\n');
				break;
			case "size":
				sb.append(q.size()).append('\n');
				break;
			case "empty":
				if(q.isEmpty()) sb.append(1);
				else sb.append(0);
				sb.append('\n');
				break;
			case "front":
				if(q.isEmpty()) sb.append(-1);
				else sb.append(q.peekLast());
				sb.append('\n');
				break;
			case "back":
				if(q.isEmpty()) sb.append(-1);
				else sb.append(q.peekFirst());
				sb.append('\n');
				break;
			}
		}
		br.close();
		System.out.print(sb.toString());
		
	}
}
