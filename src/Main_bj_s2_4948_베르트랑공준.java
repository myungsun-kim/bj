import java.io.*;

// 베르트랑 공준은 임의의 자연수 n에 대하여 n보다 크고 2n보다 작거나 같은 소수는 적어도 하나 존재한다는 내용을 담고 있다
// 자연수 n이 주어졌을때 n보다 크고 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성
// 입력은 여러 개의 테스트 케이스로 이루어져 있으며 입력의 마지막에는 0
public class Main_bj_s2_4948_베르트랑공준 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_4948.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			int cnt = 0;//소수의 개수 카운트
			
			boolean[] isNotPrime = new boolean[2*n+1];//소수인지 아닌지
			isNotPrime[0] = isNotPrime[1] = true; //0, 1은 소수가 아님
			for(int i=2;i*i<=2*n;i++) {
				for(int j=i*2;j<=2*n;j+=i) {
					if(!isNotPrime[i]) isNotPrime[j]=true;//소수의 배수는 소수가 아님
				}
			}
			
			for(int i=n+1;i<=2*n;i++) {
				if(!isNotPrime[i]) cnt++;
			}
			sb.append(cnt).append('\n');
		}
		br.close();
		System.out.print(sb.toString());
	}
}
