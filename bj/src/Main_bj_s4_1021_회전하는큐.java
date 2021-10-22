import java.io.*;
import java.util.*;
// N개의 원소를 포함하고 있는 양방향 순환 큐를 가지고 있음. 
// 1. 첫 번째 원소를 뽑아냄
// 2. 왼쪽으로 한 칸 이동시킴
// 3. 오른쪽으로 한 칸 이동 시킴
public class Main_bj_s4_1021_회전하는큐 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1021.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int count = 0; //2,3 연산의 횟수
		int n = Integer.parseInt(st.nextToken()); //큐의 크기
		LinkedList<Integer> q = new LinkedList<>();
		for(int i=1;i<=n;i++) q.add(i);
		
		int m = Integer.parseInt(st.nextToken()); //뽑아낼 수의 개수

		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<m;i++) {
			int input=Integer.parseInt(st.nextToken());
			int idx = q.indexOf(input); //뽑아낼 수가 몇 번째 인덱스인지
			int half = q.size()/2-(q.size()%2==0?1:0); //큐의 중간 인덱스
			
			if(half>=idx) {//2번 연산
				for(int j=0;j<idx;j++) {
					int tmp = q.poll();
					q.addLast(tmp);
					count++;
				}
			}else {//3번 연산
				for(int j=0;j<q.size()-idx;j++) {
					int tmp = q.pollLast();
					q.addFirst(tmp);
					count++;
				}				
			}
			q.poll(); //2,3 연산이 끝나면 1번 연산 실행 
		}
		br.close();
		System.out.print(count);
	}
	
}
