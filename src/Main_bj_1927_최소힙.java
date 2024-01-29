import java.io.*;
import java.util.*;

public class Main_bj_1927_최소힙 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1927.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		int N=Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			int input=Integer.parseInt(br.readLine());
			if(input==0) {
				if(pq.isEmpty()) {
					sb.append(0).append('\n');
				}else {					
					sb.append(pq.poll()).append('\n');
				}
			}else {				
				pq.offer(input);
			}
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}
