import java.io.*;
import java.util.*;

public class Main_bj_s3_1874_스택수열 {
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1874.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		visited = new boolean[n+1];//이미 사용된 숫자인 경우
		StringBuilder sb = new StringBuilder();
		
		//처음 값 입력
		int input=Integer.parseInt(br.readLine());
		for(int i=1;i<=input;i++) {
			stack.push(i);
			sb.append('+').append('\n');
		}
		//처음 값 출력
		int peek=stack.peek();
		visited[peek]=true;
		stack.pop();
		sb.append('-').append('\n');
		
		//다음 값 계산
		for(int i=1;i<n;i++) {
			input=Integer.parseInt(br.readLine());
			if(visited[input]) {
				System.out.println("NO");
				return;
			}
			peek=stack.size()==0?1:stack.peek();//현재 스택의 가장 위의 값
			
			if(input==peek) {//피크 값이 현재 필요한 수와 같은 경우
				visited[stack.pop()]=true;
				sb.append('-').append('\n');
			}else if(input<peek) {//피크 값이 현재 필요한 수보다 큰 경우
				while(true) {
					visited[stack.pop()]=true;
					sb.append('-').append('\n');
					peek=stack.peek();
					if(peek==input) {
						visited[stack.pop()]=true;
						sb.append('-').append('\n');
						break;
					}else if(input>peek) {
						System.out.print("NO");
						return;
					}
				}
			}else if(input>peek) {//피크 값이 현재 필요한 수보다 작은 경우
				for(int j=peek+1;j<=input;j++) {
					if(visited[j]) continue;//이미 사용한 경우
					stack.push(j);
					sb.append('+').append('\n');
				}
				visited[stack.pop()]=true;
				sb.append('-').append('\n');
			}
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}
