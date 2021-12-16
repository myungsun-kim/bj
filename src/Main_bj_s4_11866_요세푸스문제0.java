import java.io.*;
import java.util.*;
//요세푸스 문제:1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, N보다 작거나 같은 양의 정수 K가 주어짐
//이제 순서대로 K번째 사람을 제거하고, 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해나감
//N명의 사람들이 모두 제거될 때까지 계속되며, 원에서 사람들이 제거되는 순서를 (N,K)-요세푸스 순열이라고 함
public class Main_bj_s4_11866_요세푸스문제0 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_11866.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1;i<=N;i++) {
			q.offer(i);
		}
		sb.append("<");
		while(q.size()>1) {
			for(int i=0;i<K-1;i++) {//k-1번째까지의 수를 뒤로 보낸다
				q.offer(q.poll());
			}
			sb.append(q.poll()).append(", ");//k번째 수를 출력
		}
		//마지막 원소 출력
		sb.append(q.poll()).append(">");
		br.close();
		System.out.print(sb);
	}
}
