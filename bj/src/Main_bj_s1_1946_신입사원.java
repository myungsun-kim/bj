import java.io.*;
import java.util.*;
// 선발 시험은 1차 서류심사와 2차 면접시험으로 이루어짐
// 서류심사 성적과 면접시험 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발한다
// 선발할 수 있는 신입사원의 최대 인원수를 구하는 프로그램 작성

public class Main_bj_s1_1946_신입사원 {	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1946.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=0;tc<t;tc++) {
			int n = Integer.parseInt(br.readLine()); //지원자의 숫자
			int[] arr = new int[n+1]; //인덱스=서류성적, 값=면접성적
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
			}
			
			int count = 1; //합격자의 숫자(arr[0]은 무조건 합격)
			int tmp = arr[1]; //현재 가장 좋은 면접 점수
			for(int i=2;i<=n;i++) {
				if(tmp>arr[i]) { //현재 면접 점수의 기준값보다 작다면(성적이 좋다면)
					count++;
					tmp = arr[i];//기준값 변경
				}
			}
			sb.append(count).append('\n');
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb.toString());
	}
}
