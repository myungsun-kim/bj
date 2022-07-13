import java.io.BufferedReader;
import java.io.InputStreamReader;

// 1<=n<=10000
// 특별한 수 = 연속한 두 소수의 곱
public class Main_bj_24039_2021은무엇이특별할까 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_24039.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		
		boolean[] isNotPrime = new boolean[105]; //소수인지 아닌지
		boolean[] special = new boolean[10404]; //특별한 수인지 아닌지
		isNotPrime[0] = isNotPrime[1] = true;
		
		for(int i=2;i*i<isNotPrime.length;i++) {
			if(!isNotPrime[i]) { //소수의 배수는 소수가 아님
				for(int j=i*i;j<isNotPrime.length;j+=i) isNotPrime[j] = true;
			}
		}
		
		int pre = 2; //이전의 수
		for(int i=3;i<isNotPrime.length;i++) {
			if(!isNotPrime[i]) {
				special[pre*i] = true; //연속된 소수의 곱은 특별한 수
				pre = i;
			}
		}
		
		for(int i=n+1;i<special.length;i++) {
			if(special[i]) {
				answer = i;
				break;
			}
		}
		br.close();
		System.out.print(answer);
	}
}
