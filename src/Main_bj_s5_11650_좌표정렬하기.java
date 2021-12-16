import java.io.*;
import java.util.*;

public class Main_bj_s5_11650_좌표정렬하기 {
	private static class Node implements Comparable<Node>{
		int x;
		int y;
		
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Node o) {
			int dif = Integer.compare(this.x, o.x);
			if(dif==0) {
				return Integer.compare(this.y, o.y);
			}else{
				return dif;
			}
		}
		
	}
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_11650.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		Node[] arr = new Node[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			arr[i] = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);
		for(int i=0;i<n;i++) {
			sb.append(arr[i].x).append(" ").append(arr[i].y).append("\n");
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}
