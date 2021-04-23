import java.io.*;
import java.util.*;

public class Main_bj_1978_소수찾기 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1978.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] isNotPrime = new boolean[1001];
		
		isNotPrime[1]=true;
		//에라토스테네스의 체
		for(int i=2;i*i<isNotPrime.length;i++) {
			if(!isNotPrime[i]) {//해당 수가 소수가 아니라면
				//소수의 배수 > 소수
				for(int j=i*i;j<isNotPrime.length;j+=i) {
					isNotPrime[j]=true;
				}
			}
		}

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int cnt=0;//소수의 개수
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			if(!isNotPrime[arr[i]]) cnt++;
		}
		br.close();
		System.out.print(cnt);
	}
}
