import java.io.*;
import java.util.*;
//N장의 카드. 1부터 N까지의 번호가 있으며 1번 카드가 제일 위, N번 카드가 제일 아래
//제일 위에 있는 카드를 바닥에 버린 다음 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮김
//제일 마지막에 남게 되는 카드는
public class Main_bj_s4_2164_카드2 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2164.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			q.offer(i);
		}
		
		while(!q.isEmpty()) {
			if(q.size()==1) {
				System.out.print(q.poll());
				return;
			}
			q.poll();//제일 위에 있는 카드를 버린다
			q.offer(q.poll());//그 다음 제일 위에 있는 카드를 제일 아래로 옮긴다
		}
	}
}
