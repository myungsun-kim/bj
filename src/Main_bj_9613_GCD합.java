import java.io.*;
import java.util.*;
// 양의 정수 n개가 주어졌을때, 가능한 모든 쌍의 GCD의 합을 구하는 프로그램 작성
public class Main_bj_9613_GCD합 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_9613.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine()); //테스트케이스 개수
		
		for(int tc=0;tc<t;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken()); //수의 개수
			int[] arr = new int[n];
			long sum = 0;
			
			for(int i=0;i<n;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<n-1;i++) {
				for(int j=i+1;j<n;j++) {
					sum+=getGCD(arr[i], arr[j]);
				}
			}
			sb.append(sum).append('\n');
		}
		
		br.close();
		System.out.print(sb.toString());
	}
	
	static long getGCD(int num1, int num2) {
		long gcd = 0;
		int max = Math.max(num1, num2);
		
		for(int i=max;i>0;i--) {
			if(num1%i == 0 && num2%i == 0) {
				gcd = i;
				break;
			}
		}
		return gcd;
	}
}
