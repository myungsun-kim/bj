import java.io.*;
import java.util.*;
// N장의 카드 중 가장 많이 가지고 있는 정수 구하기. 가장 많이 가지고 있는 정수가 여러가지라면 작은 것 출력
public class Main_bj_s4_11652_카드 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_11652.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N]; //정수의 범위는 -2^62이상 2^62이하
		for(int i=0;i<N;i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(arr);//오름차순 정렬
		int cnt=1;
		int max_cnt=0;
		long answer=arr[0];
		for(int i=1;i<N;i++) {
			if(arr[i]==arr[i-1]) {//이전 값과 같을 경우
				cnt++; 
			}else {//이전 값과 같지 않을 경우
				cnt=1;
			}
			if(max_cnt<cnt) {//현재 많이 나온 수보다 많이 나온 경우가 있는 경우
				max_cnt=cnt;
				answer=arr[i-1];
			}
		}
		br.close();
		System.out.print(answer);
	}
}
