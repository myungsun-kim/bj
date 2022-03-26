import java.io.*;
import java.util.*;

public class Main_bj_1929_소수구하기 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1929.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		//M이상 N이하 소수 출력하기
		boolean[] isNotPrime =new boolean[N+1];//소수인지 아닌지 표현. false이면 소수
		isNotPrime[0] = isNotPrime[1] = true; //0과 1은 소수가 아님
		for(int i=2;i*i<=N;i++) {
			for(int j=i*i;j<=N;j+=i) {//소수의 배수는 소수가 아님
				isNotPrime[j]=true;
			}
		}
		for(int i=M;i<=N;i++) {
			if(!isNotPrime[i]) sb.append(i).append('\n');
		}
		br.close();
		System.out.print(sb.toString());
	}
}
