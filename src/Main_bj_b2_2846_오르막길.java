import java.io.*;
import java.util.*;
//자전거 길은 오르막길, 내리막길, 평지로 이루어져있고 가장 큰 오르막길의 크기를 구하려고 함
//측정한 높이는 길이가 N인 수열로 나타낼 수 있고, 오르막길은 적어도 2개의 수로 이루어진 높이가 증가하는 부분수열
//오르막길의 크기=부분 수열의 첫번째 숫자와 마지막 숫자의 차이
public class Main_bj_b2_2846_오르막길 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_2846.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int answer=0,start=0;
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			if(i>0 && arr[i-1]==arr[i]) {//평지일 경우
				start=i;
			}else if(i>0 && arr[i-1]<arr[i]) {//오르막일 경우
				answer=arr[i]-arr[start]>answer?arr[i]-arr[start]:answer;
			}else {
				start=i;
			}
		}
		br.close();
		System.out.print(answer);
	}
}