import java.io.*;
import java.util.*;
// 세준이는 N명의 병사를 키웠고 세비는 M명의 병사를 키웠다
// 전쟁은 여러 번의 전투로 이루어지며 각 전투에서 살아있는 병사 중 제일 약한 병사가 죽는다
// 만약 제일 약한 병사가 여러 명이고 제일 약한 병사가 모두 같은 편에 있다면 그 중 한 명이 임의로 죽는다
// 제일 약한 병사가 여러 명이고 양 편에 모두 있다면 세비의 제일 약한 병사 중 한 명이 임의로  죽는다
// 전쟁은 한 명의 병사를 제외하고 모두 죽었을 때 끝난다. 
// 세준이가 이기면 S, 세비가 이기면 B, 둘 다 아닌 경우 C를 출력한다
public class Main_bj_1542_세준세비 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1542.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int t = Integer.parseInt(st.nextToken()); //테스트케이스의 개수
		int[] s,b;//세준,세비 병사들의 힘
		
		for(int tc=0;tc<t;tc++) {
			br.readLine();
			st = new StringTokenizer(br.readLine()," ");
			int n=Integer.parseInt(st.nextToken());//세준이의 병사들의 수
			int m=Integer.parseInt(st.nextToken());//세비의 병사들의 수
			s=new int[n];
			b=new int[m];
			s=stationSolid(br.readLine(), s);//세준 병사 배치
			b=stationSolid(br.readLine(), b);//세비 병사 배치
			
			System.out.println(play(n,m,s,b));
		}
	}
	
	static int[] stationSolid(String input, int[] arr) {
		StringTokenizer st = new StringTokenizer(input," ");
		for(int i=0;i<arr.length;i++) arr[i] = Integer.parseInt(st.nextToken());
		return arr;
	}
	
	static char play(int n, int m, int[] s, int[] b) {//세준이가 이기면 true, 세비가 이기면 false
		Arrays.sort(s);
		Arrays.sort(b);
		
		int sIdx=0, bIdx=0;
		while(true) {
			if(n==0) return 'B';//세준팀의 병사가 더 이상 없음. 세비 승리
			if(m==0) return 'S';//세비팀의 병사가 더 이상 없음. 세준 승리
			if(s[sIdx]>=b[bIdx]) {//세비팀의 병사 죽음
				++bIdx;
				--m;
			}else {
				++sIdx;
				--n;
			}
		}
	}
}
