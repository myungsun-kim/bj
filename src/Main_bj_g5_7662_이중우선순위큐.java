import java.io.*;
import java.util.*;
// D 1 최댓값 삭제 D -1 최솟값 삭제 비어있을시 무시
// I n 정수값 삽입
// 모든 연산을 처리한 후 Q에 남아있는 최댓값과 최솟값 출력
public class Main_bj_g5_7662_이중우선순위큐 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_7662.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		for(int tc=0;tc<t;tc++) {
			int k = Integer.parseInt(br.readLine()); //연산의 개수
			TreeMap<Integer, Integer> q = new TreeMap<>();
			
			for(int i=0;i<k;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				char oper = st.nextToken().charAt(0);
				int n = Integer.parseInt(st.nextToken());
				
				switch(oper) {
				case 'I':
					q.put(n, q.getOrDefault(n, 0)+1);
					break;
				case 'D':
					if(!q.isEmpty()) {
						int val = 0;
						if(n==1) {
							val = q.lastKey();
						}else {
							val = q.firstKey();
						}
						if(q.get(val)==1) {
							q.remove(val);
						}else {
							q.put(val, q.get(val)-1);
						}
					}
				}
			}
			if(q.isEmpty()) {
				sb.append("EMPTY");
			}else {
				sb.append(q.lastKey()).append(' ').append(q.firstKey());
			}
			sb.append('\n');
		}
		br.close();
		System.out.print(sb.toString());
	}
}
