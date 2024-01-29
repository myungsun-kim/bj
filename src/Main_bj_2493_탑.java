import java.util.*;
import java.io.*;

public class Main_bj_2493_탑 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2493.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Stack<int[]> stack = new Stack<>();
		ArrayDeque<int[]> stack = new ArrayDeque<>();//ArrayDeque가 Stack보다 빠름
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); //탑의 수
		String[] tmp = br.readLine().split(" ");
		for(int i=0;i<tmp.length;i++) {//스택에 값을 대입
			int cur_top = Integer.parseInt(tmp[i]);//현재 탑의 높이
			while(!stack.isEmpty()) {
				if(stack.peek()[1]>=cur_top) {
					//스택의 가장 끝에 저장되어 있는 값이 현재 탑보다 높거나 같으면 출력 
					sb.append(stack.peek()[0]+" ");
					break;
				}
				stack.pop();//현재 값보다 작으면 pop
			}
			if(stack.isEmpty()) {//스택이 비었을시
				sb.append("0 ");
			}
			stack.push(new int[] {i+1,Integer.parseInt(tmp[i])});
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}
