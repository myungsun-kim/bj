import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 에라토스테네스의 체: n보다 작거나 같은 모든 소수를 찾는 유명한 알고리즘
// 1. 2부터 n까지의 모든 정수를 적는다
// 2. 아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이 수를 p라고 한다. 이 수는 소수 
// 3. p를 지우고, 아직 지우지 않은 p의 배수를 크기 순서대로 지움
// 4. 아직 모든 수를 지우지 않았다면 다시 2번 단계로 간다
// n,k가 주어졌을때 k번째 지우는 수를 구하는 프로그램 작성
public class Main_bj_2960_에라토스테네스의체 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_2960.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int count = 0;
		int answer = 0;
		boolean check = false; //k번째 변하는 수를 찾았는지
		boolean[] isNotPrime = new boolean[n+1];
		
		isNotPrime[1] = isNotPrime[2] = false;
		
		for(int i=2;i<=n;i++) {
			for(int j=i;j<=n;j+=i) {
				if(!isNotPrime[j]) {						
					isNotPrime[j] = true;
					++count;
					if(count == k) {
						answer = j;
						check = true;
						break;
					}
				}
			}
			if(check) break;
		}
		br.close();
		System.out.print(answer);
	}
}
