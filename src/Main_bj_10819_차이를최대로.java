import java.io.*;
import java.util.*;
// n개의 정수로 이루어진 배열 a가 주어진다
// 이때 배열에 들어있는 정수의 순서를 적절히 바꿔서 다음 식의 최댓값을 구하는 프로그램 작성
// |A[0]-A[1]|+|A[1]-A[2]|+...+|A[N-2]-A[N-1]|
// 3<=N<=8. -100<==A[i]<=100
public class Main_bj_10819_차이를최대로 {
	static int n, answer;
	static int[] arr, number;
	static boolean[] selected;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_10819.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		number = new int[n];
		selected = new boolean[n];
		answer = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		perm(0);
		
		br.close();
		System.out.print(answer);
	}
	
	static void perm(int cnt) {
		if(cnt==n) { //n개 모두 뽑음
			cal();
		}
		
		for(int i=0;i<n;i++) {
			if(!selected[i]) {
				number[cnt] = arr[i];
				selected[i] = true;
				//현재 뽑은 수를 저장하고 사용중임을 체크
				perm(cnt+1);
				//다음 인덱스 수를 뽑아줌
				selected[i] = false; //선택값 되돌리기
			}
		}
	}
	
	static void cal() { //계산
		int sum = 0;
		for(int i=0;i<n-1;i++) {
			sum+=Math.abs(number[i]-number[i+1]);
		}
		if(answer<sum) answer=sum;
	}
}
