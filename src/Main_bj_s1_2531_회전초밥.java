import java.io.*;
import java.util.*;
// 1 벨트의 임의의 한 위치부터 k개의 접시를 연속해서 먹을 경우 할인된 정액 가격으로 제공
// 2 1번 행사에 참가할 경우 쿠폰에 적혀진 종류의 초밥 하나를 추가로 무료 제공. 벨트에 없으면 새로 만들어 제공
// 손님이 먹을 수 있는 초밥 가짓수의 최댓값을 구하는 프로그램 작성
public class Main_bj_s1_2531_회전초밥 {
	static int n, d, k, c, tmp, answer;
	static int[] belt, visited;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2531.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken()); //접시의 수
		d = Integer.parseInt(st.nextToken()); //초밥의 가짓수
		k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시의 수
		c = Integer.parseInt(st.nextToken()); //쿠폰번호
		answer = 0;
		tmp = 0; //현재 초밥을 먹은 가짓수
		
		belt = new int[n];
		visited = new int[d+1]; //해당 종류의 접시가 포함되어 있는지
		
		for(int i=0;i<n;i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0;i<k;i++) {
			if(visited[belt[i]]==0) tmp++; //해당 초밥 선택되지 않았을시
			visited[belt[i]]++; 
		}
		
		if(tmp==k && visited[c]==0) answer=k+1;
		else select();
		
		br.close();
		System.out.println(answer);
	}
	
	static void select() {
		int before;
		int cur;
		int j;
		
		for(int i=1;i<n;i++) {
			j=i+k-1;
			before = belt[i-1]; //이전 선택시 가장 처음 값
			visited[before]--;
			if(visited[before]==0) tmp--; //현재 해당 초밥 없음
			
			if(j>=n) {
				cur = belt[j-n];
			}else {
				cur = belt[j];
			}
			
			if(visited[cur]==0) tmp++;
			visited[cur]++;
			
			if(answer<=tmp) {
				if(visited[c]==0) answer=tmp+1;
				else answer=tmp;
			}
		}
	}
}
