import java.io.*;
import java.util.*;
// 4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다
// 백만 이하의 모든 짝수에 대해 이 추측을 검증하는 프로그램 작성
// n = a + b의 형태로 출력. a와 b는 홀수인 소수
// n은 짝수 정수
// 만약 n을 만들 수 있는 방법이 여러가지라면 b-a가 가장 큰 것 출력
// 두 홀수 소수의 합으로 n을 나타낼 수 없는 경우 Goldbach's conjecture is wrong. 출력 
public class Main_bj_6588_골드바흐의추측 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_6588.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		final int total = 1000000;
		
		boolean[] isNotPrime = new boolean[total+1];//소수인지 아닌지
		
		
		for(int i=2;i*i<isNotPrime.length;i++) {
			for(int j=i+i;j<isNotPrime.length;j+=i) {
				if(!isNotPrime[i]) isNotPrime[j]=true;
			}
		}
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			int a = 0, b = 0;
			
			for(int i=3;i<=n;i++) {
				if(n-i>=3 && !isNotPrime[i] && !isNotPrime[n-i]) {
					a = i;
					b = n-i;
					break;
				}
			}
			
			if(a*b==0) 	sb.append("Goldbach's conjecture is wrong.").append('\n');
			else		sb.append(n).append(" = ").append(a).append(" + ").append(b).append('\n');
			
		}
		
		System.out.print(sb.toString());
	}
}
