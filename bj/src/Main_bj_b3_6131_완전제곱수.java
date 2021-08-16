import java.io.*;
// 상근이와 선영이가 게임을 하고 있다. 상근이는 두 양의 정수 a와 b를 고른다. 두 수는 500 이하 자연수
// 그 다음 선영이는 상근이가 고른 수를 맞춰야 한다. a의 제곱은 b의 제곱보다 n만큼 크다
// a와 b의 쌍의 개수를 구하는 프로그램 작성
public class Main_bj_b3_6131_완전제곱수 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_6131.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int range = 500;
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;//a와 b의 쌍의 개수
		for(int b=1;b<=range;b++) {
			for(int a=b+1;a<=range;a++) {
				if(a*a==b*b+n) {
					cnt++;
					break;
				}
				if(a*a>b*b+n) break;
			}
		}
		br.close();
		System.out.print(cnt);
	}
}
