import java.io.*;
import java.util.*;
// 수 3개를 이용해 연도를 나타낸다. 각각의 수는 지구 E, 태양 S, 달 M 을 나타낸다
// 1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19
// 1년이 지날때마다 1씩 증가, 범위를 넘어가면 1이 됨
// 1년이 1 1 1일때,E S M이 우리가 알고 있는 연도로 몇 년인지 구하는 프로그램을 작성(가장 빠른 년도 출력)
public class Main_bj_s5_1476_날짜계산 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1476.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int size = 3;
		final int[] range = new int[size];
		range[0] = 15;//3 5
		range[1] = 28;//2 2 7
		range[2] = 19;//19
		int n = 1;
		int answer = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] input = new int[size];
		for(int i=0;i<size;i++) {
			input[i] = Integer.parseInt(st.nextToken());
			if(answer<input[i]) {
				answer = input[i];
				n = range[i];
			}
		}
		
		while(true) {
			int[] num = new int[size];
			for(int i=0;i<size;i++) {
				num[i]=answer%range[i];
				if(num[i]==0) num[i]=range[i];
			}
			boolean check = true;
			for(int i=0;i<size;i++) {
				if(num[i]!=input[i]) {
					check=false;
					break;
				}
			}
			if(check) break;
			answer+=n;
		}
		br.close();
		System.out.print(answer);
	}
}
