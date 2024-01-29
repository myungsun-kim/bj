import java.io.*;
import java.util.*;
// n개의 서로 다른 양의 정수로 이루어진 수열이 있다
// 수열은 1 이상 1000000 이하의 수로 이루어져있다
// 자연수 x가 주어졌을때 arr[i]+arr[j]=x를 만족하는 (1<=i<=j<=n)
// arr[i],arr[j]를 구하여라
public class Main_bj_3273_두수의합 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_3273.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int start = 0; //시작점
		int end = n-1; //끝점
		int sum = 0; //두 값의 합
		int cnt = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int x = Integer.parseInt(br.readLine());
		
		while(start<end) {
			sum = arr[start]+arr[end];
			
			if(sum==x) {
				cnt++;
				start++;
				end--;
			}else if(sum<x) {
				start++;
			}else {//합이 x보다 큼
				end--;
			}	
		}
		
		br.close();
		System.out.print(cnt);
	}
}
