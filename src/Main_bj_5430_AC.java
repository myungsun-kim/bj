import java.io.*;
import java.util.*;
// AC는 정수 배열에 연산을 하기 위해 만든 언어. 이 언어에는 두 가지 함수 R(뒤집기) D(버리기)가 있음
// R: 배열에 있는 숫자의 순서를 뒤집는 함수
// D: 첫 번째 숫자를 버리는 함수. 배열이 비어있는데 사용하면 에러 발생
// 함수는 조합해서 한 번에 사용할 수 있음 
public class Main_bj_5430_AC {
	static Deque<Integer> deque;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_5430.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); //테스트 케이스의 수
		
		for(int tc=0;tc<t;tc++) {			
			char[] p = br.readLine().toCharArray(); //수행할 함수
			int n = Integer.parseInt(br.readLine()); //배열에 들어있는 수의 개수

			String input = br.readLine();//입력받은 배열
			if(n!=0) input = input.substring(1, input.length()-1);//[ ] 제외
			StringTokenizer st = new StringTokenizer(input,",");
			deque = new LinkedList<>();
			
			for(int i=0;i<n;i++) {//배열에 값 입력
				deque.add(Integer.parseInt(st.nextToken()));
			}
			boolean check = true; //error가 발생했을 경우 false
			boolean reverse = false; //뒤집힌 경우
			for(int i=0;i<p.length;i++) { //함수 수행
				if(p[i]=='D') {//버리기
					if(deque.isEmpty()) {//배열이 비어있음. 에러 발생
						sb.append("error").append('\n');
						check = false;
						break;
					}else {
						if(reverse) {//뒤집힌 경우
							deque.removeLast();
						}else {//뒤집히지 않은 경우							
							deque.removeFirst();
						}
					}
				}else {//뒤집기
					reverse = !reverse;
				}
			}
			
			if(check) {
				sb.append('[');
				int tmp = deque.size();
				if(reverse) {
					for(int j=0;j<tmp;j++) {
						sb.append(deque.removeLast());
						if(j!=tmp-1)sb.append(',');
					}
				}else {					
					for(int j=0;j<tmp;j++) {
						sb.append(deque.removeFirst());
						if(j!=tmp-1)sb.append(',');
					}
				}
				sb.append(']').append('\n');
			}
		}
		
		System.out.print(sb.toString());
	}
}
