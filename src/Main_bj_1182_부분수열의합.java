import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중 수열의 원소를 다 더한 값이 S가 되는 경우의 수 출력
public class Main_bj_1182_부분수열의합 {
	static int[] arr;
	static int N,S,answer;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1182.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken()); 
		S=Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(S==0) answer=-1; //S가 0인 경우 공집합은 제외
		else answer=0;
		subset(0,0);
		System.out.print(answer);
	}
	
	public static void subset(int idx, int sum) {
		if(idx==N) {
			if(sum==S) answer++;
			return;
		}
		
		subset(idx+1,sum+arr[idx]);//현재 위치의 원소를 뽑는 경우 
		subset(idx+1,sum);//현재 위치의 원소를 뽑지 않는 경우
	}
}
