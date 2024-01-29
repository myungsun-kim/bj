import java.io.*;
import java.util.*;
// 수첩1: 하루 동안 본 정수들
// 수첩2: 봤다고 주장하는 수들
// 수첩 2에 적혀있는 순서대로 각각의 수에 대하여 수첩 1에 있으면 1, 없으면 0을 출력
public class Main_bj_2776_암기왕 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2776.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine()); //테스트케이스의 개수
		
		for(int tc=0;tc<t;tc++) {
			int n = Integer.parseInt(br.readLine()); //수첩 1의 정수의 개수
			HashSet<Integer> notebook1 = new HashSet<>();
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			for(int i=0;i<n;i++) notebook1.add(Integer.parseInt(st.nextToken()));
			
			int m = Integer.parseInt(br.readLine()); //수첩 2의 정수의 개수
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<m;i++) {
				if(notebook1.contains(Integer.parseInt(st.nextToken()))) {//수첩 1에 포함되어 있다면
					sb.append(1).append('\n');
				}else {
					sb.append(0).append('\n');					
				}
			}
		}
		br.close();
		System.out.print(sb.toString());
	}
}
