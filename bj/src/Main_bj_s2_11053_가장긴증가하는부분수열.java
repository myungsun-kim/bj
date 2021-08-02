import java.io.*;
import java.util.*;
// 주어진 수열에서 가장 긴 증가하는 부분수열 값 구하기
public class Main_bj_s2_11053_가장긴증가하는부분수열 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_11053.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] length = new int[N];//해당 위치에서부터 증가하는 부분수열의 값
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			length[i]=1;//초기값
		}
		int max=1;//가장 긴 증가하는 부분 수열의 값
		
		// 해당 위치부터 증가하는 부분수열의 값 계산 및 저장
		for(int i=N-2;i>=0;i--) {
			int sum=0;
			for(int j=i+1;j<N;j++) {
				if(arr[i]<arr[j] && length[j]>sum) sum=length[j];
			}
			length[i]+=sum;
			if(length[i]>max) max=length[i];
		}
		
		System.out.print(max);
		
	}
}
