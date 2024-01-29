import java.io.*;
import java.util.*;
// 주어진 수 사이에 연산자를 하나씩 넣어 수식을 만들 수 있음
// 주어진 수의 순서를 바꿀 수 없음
// 식의 계산은 연산자 우선 순위를 무시하고 앞에서부터 진행. 나눗셈은 정수 나눗셈으로 몫만 취함
public class Main_bj_14888_연산자끼워넣기 {
	static int N, max, min;
	static int[] arr, oper;
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_14888.txt"));
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		oper = new int[4];//덧셈,뺄셈,곱셈,나눗셈의 개수
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<oper.length;i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		
		max = -1000000000;
		min = 1000000000;
		perm(0,arr[0]);
		br.close();
		System.out.println(max);
		System.out.print(min);
	}
	
	static void perm(int cnt, int value) {
		if(cnt==N-1) {
			if(max<value) max=value;
			if(min>value) min=value;
			return;
		}
		
		for(int i=0;i<4;i++) {
			if(oper[i]>0) {
				oper[i]--;
				switch(i) {
				case 0:
					perm(cnt+1, value+arr[cnt+1]);					
					break;
				case 1:
					perm(cnt+1, value-arr[cnt+1]);					
					break;
				case 2:
					perm(cnt+1, value*arr[cnt+1]);					
					break;
				case 3:
					perm(cnt+1, value/arr[cnt+1]);					
					break;
				}
				oper[i]++;
			}
		}
	}
}
