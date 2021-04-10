import java.io.*;
import java.util.*;
//K개의 랜선을 모두 N개의 같은 길이의 랜선으로 만듦. 이미 자른 랜선은 붙일 수 없음
//이분탐색
public class Main_bj_1654_랜선자르기 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1654.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int K=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		int[] arr=new int[K];//이미 가지고 있는 랜선의 개수
		for(int i=0;i<K;i++) {
			arr[i]=Integer.parseInt(br.readLine());

		}
		Arrays.sort(arr);
		
		long left=1;//랜선 길이가 될 수 있는 가장 작은 수는 1
		long right=arr[K-1];
		long middle;
		br.close();
		
		while(right>=left) {//이분탐색
			middle = (right+left)/2;
			long cnt=0;
			
			for(int i=0;i<K;i++) {
				cnt+=arr[i]/middle;
			}
			
			if(cnt>=N) left=middle+1;//N개보다 더 많은 개수가 나온 경우 더 크게 잘라줌
			if(cnt<N) right=middle-1;
		}
		br.close();
		System.out.print(right);
	}
}