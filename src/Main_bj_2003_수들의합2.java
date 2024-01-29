import java.io.*;
import java.util.*;
// N개의 수로 된 수열 A가 있다. 이 수열의 i번째 수부터 j번째 수까지의 합이(연속된 수의 합이) 
// M이 되는 경우의 수의 개수 프로그램을 작성하여라
public class Main_bj_2003_수들의합2 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_2003.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int cnt = 0; //경우의 수 개수
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int end=0;
		int sum=0;

		for(int start=0;start<n;start++) {
			while(true) {
				if(end>=n) break;
				sum+=arr[end++];
				if(sum>=m) {
					if(sum==m) cnt++;//합이 m과 같으면 개수 증가
					if(sum>m && end>0) sum-=arr[--end];
					sum-=arr[start];
					break;
				}
			}
		}
		
		System.out.print(cnt);
	}
}
