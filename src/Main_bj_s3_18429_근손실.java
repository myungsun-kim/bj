import java.io.*;
import java.util.*;
// 모든 날 중량이 500 이상이 될 수 있게 한다
public class Main_bj_s3_18429_근손실 {
	static int[] arr;
	static boolean[] visited;
	static int n,k,answer;
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_18429.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken()); //하루에 줄어드는 중량
		k = Integer.parseInt(st.nextToken()); //운동 키트의 개수
		arr = new int[n]; //각 운동키트의 증량 증가 값
		visited = new boolean[n];
		answer = 0;
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) arr[i]=Integer.parseInt(st.nextToken());
		if(n==1) {
			if(arr[0]>=k) answer++;
		}else {			
			check(500,1);
		}
		br.close();
		System.out.print(answer);
	}
	
	static void check(int weight, int cnt) {
		if(weight<500) return;
		
		if(cnt==n) {
			answer++;
			return;
		}
		
		
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				check(weight-k+arr[i],cnt+1);
				visited[i]=false;
			}
		}
	}
}
