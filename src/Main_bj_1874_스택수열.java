import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_bj_1874_스택수열 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1874.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[n+1];//스택에 있는지 체크
		StringBuilder sb = new StringBuilder();
		
		//처음 값 입력
		int cur=Integer.parseInt(br.readLine());
		for(int i=1;i<=cur;i++) {
			stack.push(i);
			visited[i] = true;
			sb.append('+').append('\n');
		}
		//처음 값 출력
		int peek=stack.pop();
		sb.append('-').append('\n');
		
		//다음 값 계산
		for(int i=2;i<=n;i++) {
			cur=Integer.parseInt(br.readLine());
			peek=stack.size()==0?1:stack.peek();//현재 스택의 가장 위의 값
			
			if(cur<peek) {
				System.out.print("NO");
				return;
			}
			
			if(cur==peek) {//피크 값이 현재 필요한 수와 같은 경우
				stack.pop();
				sb.append('-').append('\n');
			}else if(cur>peek) {//피크 값이 현재 필요한 수보다 작은 경우
				for(int j=peek+1;j<=cur;j++) {
					if(visited[j]) continue;//이미 사용한 경우
					stack.push(j);
					visited[j] = true;
					sb.append('+').append('\n');
				}
				stack.pop();
				sb.append('-').append('\n');
			}
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb.toString());
	}
}
