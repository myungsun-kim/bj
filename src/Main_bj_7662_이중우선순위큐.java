import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

// D 1 최댓값 삭제 D -1 최솟값 삭제 비어있을시 무시
// I n 정수값 삽입
// 모든 연산을 처리한 후 Q에 남아있는 최댓값과 최솟값 출력
public class Main_bj_7662_이중우선순위큐 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_7662.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); //입력 데이터의 수
		StringBuilder sb = new StringBuilder(); // Q에 적용할 연산의 개수
		
		for(int tc=0;tc<t;tc++) {
			int k = Integer.parseInt(br.readLine()); //연산의 개수
			TreeMap<Integer, Integer> q = new TreeMap<>();
			
			for(int i=0;i<k;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				char oper = st.nextToken().charAt(0);
				int n = Integer.parseInt(st.nextToken());
				
				switch(oper) {
				case 'I': //정수 n을 q에 삽입
					q.put(n, q.getOrDefault(n, 0)+1);
					break;
				case 'D':
					if(!q.isEmpty()) {
						int val = 0;
						if(n==1) { // q의 최댓값 삭제
							val = q.lastKey();
						}else { //q의 최솟값 삭제
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
