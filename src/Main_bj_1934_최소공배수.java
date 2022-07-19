import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 두 자연수의 최소 공배수 구하기
public class Main_bj_1934_최소공배수 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1934.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<t;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			int max_num = Math.max(num1, num2); //둘 중 더 큰 수
			int min_num = Math.min(num1, num2); //둘 중 더 작은 수
			
			int answer = 0;//최소 공배수
			int cnt = 1; //곱할 수

			while(true) {
				answer = max_num*cnt++;
				if(answer%min_num==0) break;
			}
			
			sb.append(answer).append('\n');
		}
		System.out.print(sb.toString());
	}
}
