import java.io.*;
import java.util.*;
// n개의 정수로 이루어진 임의의 수열이 주어짐. 
// 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 함
public class Main_bj_1912_연속합 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1912.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] sum = new int[n];//인덱스값까지의 연속된 수의 합 중 가장 큰 값

		int answer = -1000;
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(i==0) sum[i]=arr[i];
			else sum[i] = Math.max(sum[i-1]+arr[i], arr[i]);
			if(answer<sum[i]) answer=sum[i];
		}
		br.close();
		System.out.print(answer);
	}
}
