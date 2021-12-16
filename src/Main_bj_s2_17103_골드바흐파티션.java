import java.io.*;
import java.util.*;
//골드바흐 파티션 : 짝수 N을 두 소수의 합으로 나타내는 표현
//골드바흐 파티션의 개수 구하기. 두 소수의 순서만 다른 것은 같은 파티션
public class Main_bj_s2_17103_골드바흐파티션 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_17103.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int N, cnt, number;
		boolean[] isNotPrime = new boolean[1000001];
		//에라토스테네스의 체

		for(int i=2;i*i<isNotPrime.length;i++) {
			if(!isNotPrime[i]) {				
				for(int j=i*i;j<isNotPrime.length;j+=i) {
					isNotPrime[j]=true;//i가 소수라면 그 배수들을 제외
				}
			}
		}
		
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			cnt = 0;
			for(int i=2;i<=N/2;i++) {
				number=N-i;
				if(!isNotPrime[i] && !isNotPrime[number]) cnt++;
			}
			sb.append(cnt).append("\n");
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}
