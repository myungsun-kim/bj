import java.io.*;
import java.util.*;
// 골드바흐 수=2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다
// 짝수를 두 소수의 합으로 나타내는 표현을 그 수의 골드바흐 파티션이라고 한다
// ex) 4=2+2, 6=3+3, 8=3+5, 12=5+7..
// 10000보다 작거나 같은 모든 짝수 n에 대한 골드바흐 파티션은 존재한다
// n의 골드바흐 파티션을 출력하는 프로그램 작성. 
// 가능한 n의 골드바흐 파티션이 여러가지라면 두 소수의 차이가 가장 작은 것 출력
public class Main_bj_9020_골드바흐의추측 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_9020.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		final int range = 10001;//n은 10000보다 작음
		
		boolean[] isNotPrime = new boolean[range];
		// true소수가 아님 false소수
		
		for(int i=2;i<range;i++) {
			for(int j=i+i;j<range;j+=i) {
				if(!isNotPrime[i]) {
					isNotPrime[j]=true;
				}
			}
		}
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			for(int j=n/2;j>0;j--) {
				if(!isNotPrime[j] && !isNotPrime[n-j]) {
					sb.append(j).append(' ').append(n-j).append('\n');
					break;
				}
			}
		}
		br.close();
		System.out.print(sb.toString());
	}
}
