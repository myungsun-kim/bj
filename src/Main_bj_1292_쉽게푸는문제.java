import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1을 한 번, 2를 두 번, 3을 세 번 , ... 식의 수열을 만들어 일정한 구간을 주면 그 구간의 합을 구함
// 첫째 줄에 구간의 시작과 끝을 나타내는 정수 a,b가 주어진다
// n*(n-1)/2
public class Main_bj_1292_쉽게푸는문제 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1292.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		boolean check = false;
		int answer = 0;
		
		for(int i=1;i<=b;i++) {
			int val = 1+i*(i-1)/2;
			for(int j=val;j<val+i;j++) {
				if(j>=a && j<=b) answer+=i;
				if(j==b) {
					check = true;
					break;
				}
			}
			if(check) break;
		}
		br.close();
		System.out.print(answer);
	}
}
