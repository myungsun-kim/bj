import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_bj_10828_스택 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_10828.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push":
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(!stack.isEmpty()) {
					sb.append(stack.pop());
				}else {
					sb.append(-1);
				}
				sb.append("\n");
				break;
			case "size":
				sb.append(stack.size()).append("\n");
				break;
			case "empty":
				if(stack.isEmpty()) {
					sb.append(1);
				}else {
					sb.append(0);
				}
				sb.append("\n");
				break;
			case "top":
				if(!stack.isEmpty()) {
					sb.append(stack.peek());
				}else {
					sb.append(-1);
				}
				sb.append("\n");
				break;
			}
		}
		br.close();
		System.out.print(sb.toString());
	}
}
