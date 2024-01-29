import java.io.*;
import java.util.*;
// 산타는 세계 곳곳에 거점들을 세워 그 곳을 방문하며 선물을 충전
// 착한 아이들을 만날 때마다 자신이 들고있는 가장 가치가 큰 선물 하나를 선물해줌
// 첫 번째 줄에서는 아이들과 거점지를 방문한 횟수 n이 주어진다.(1≤n≤5,000)
// 다음 n줄에는 a가 들어오고, 그 다음 a개의 숫자가 들어온다. 
// 이는 거점지에서 a개의 선물을 충전하는 것이고, 그 숫자들이 선물의 가치이다. 만약 a가 0이라면 거점지가 아닌 아이들을 만난 것이다. 
// 선물의 가치는 100,000보다 작은 양의 정수이다.(1≤a≤100)
public class Main_bj_14235_크리스마스선물 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_14235.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp==0) {
				if(pq.isEmpty()) sb.append(-1).append('\n');
				else sb.append(pq.poll()).append('\n');
			}else {
				while(st.hasMoreTokens()) {
					pq.offer(Integer.parseInt(st.nextToken()));
				}
			}
		}
		br.close();
		System.out.print(sb.toString());
	}
}
