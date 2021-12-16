import java.io.*;

//M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램
public class Main_bj_s5_2581_소수 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2581.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M=Integer.parseInt(br.readLine());
		int N=Integer.parseInt(br.readLine());
		
		boolean[] isNotPrime = new boolean[N+1];//소수가 아닌 수 저장
		isNotPrime[1]=true;
		
		for(int i=2;i*i<=N;i++) {
			for(int j=i+i;j<=N;j+=i) {
				if(!isNotPrime[i]) isNotPrime[j]=true;
			}
		}
		
		int min=-1;
		int sum=0;
		
		for(int i=M;i<=N;i++) {
			if(!isNotPrime[i]) {
				if(min==-1) min=i;
				sum+=i;
			}
		}
		br.close();
		if(sum!=0) System.out.println(sum);
		System.out.print(min);
	}
}
