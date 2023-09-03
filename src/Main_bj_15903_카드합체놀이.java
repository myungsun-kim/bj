import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_bj_15903_카드합체놀이 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_15903.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long answer = 0;
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;++i) {
			pq.add(Long.parseLong(st.nextToken()));
		}
		
		for(int i=0;i<m;++i) {
			long num1 = pq.poll();
			long num2 = pq.poll();
			long sum = num1+num2;
			pq.add(sum);
			pq.add(sum);
		}
		
		while(!pq.isEmpty()) {
			answer += pq.poll();
		}
		
		br.close();
		System.out.print(answer);
	}
}
