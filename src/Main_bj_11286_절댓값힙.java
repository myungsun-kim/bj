import java.io.*;
import java.util.*;
// 절대값 힙은 다음과 같은 연산을 지원하는 자료구조
// 1. 배열에 정수 x(x!=0)을 넣는다
// 2. 배열에서 절대값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거
// 절대값이 가장 작은 값이 여러개일때는 가장 작은 수를 출력하고 제거
// x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거. 배열이 비어있다면 0을 출력
// x가 0이 아니라면 그 값을 배열에서 제거
public class Main_bj_11286_절댓값힙 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_11286.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine()); //연산의 개수
		PriorityQueue<Integer> q = new PriorityQueue<>((o1,o2)->{ //절대값 기준 정렬
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);
			if(abs1==abs2) {
				if(o1>o2) return 1;
				else return -1;
			}
			return abs1-abs2;
		});
		
		for(int i=0;i<n;i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x==0) { //x가 0
				if(q.isEmpty()) {
					sb.append(0).append('\n');
				}else {
					sb.append(q.poll()).append('\n');
				}
			}else {
				q.add(x);
			}
		}
		br.close();
		System.out.print(sb.toString());
	} 
}
