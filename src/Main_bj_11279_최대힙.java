import java.io.*;
import java.util.*;

public class Main_bj_11279_최대힙 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_11279.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
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