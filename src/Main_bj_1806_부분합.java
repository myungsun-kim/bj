import java.io.*;
import java.util.*;
// 10000 이하의 자연수로 이루어진 길이 n짜리 수열이 주어짐
// 이 수열에서 연속된 수들의 부분합 중에 그 합이 S이상이 되는 것 중 가장 짧은 것의 길이를 구하는 프로그램 작성

public class Main_bj_1806_부분합 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1806.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		
		int answer = Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start=0;
		int end=0;
		int sum=arr[0];
		
		while(true) {
			int cnt=end-start+1;

			if(sum>=s) {//합이 s보다 크면(부분합길이계산)
				if(answer>cnt) answer=cnt;
				sum-=arr[start++];
			}else {
				sum+=arr[++end];
			}
			if(end==n) break;
		}
		
		br.close();
		System.out.print(answer==Integer.MAX_VALUE?0:answer);
	}
}
