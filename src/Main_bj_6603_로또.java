import java.io.*;
import java.util.*;
// 독일 로또는 1-49에서 수 6개를 고른다
// 가장 유명한 전략은 49가지 수 중 k(k>6)개의 수를 골라 집합 S를 만든 다음 그 수만 가지고 번호를 선택하는 것
// 집합 S와 k가 주어졌을 때 수를 고르는 모든 방법을 구하는 프로그램 작성
public class Main_bj_6603_로또 {
	static int k;
	static int[] s, select;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_6603.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");	
			k = Integer.parseInt(st.nextToken());
			if(k==0) break; //종료
			s = new int[k];
			select = new int[6]; //뽑은 수
			for(int i=0;i<k;i++) s[i] = Integer.parseInt(st.nextToken());
			comb(0,0);
			sb.append('\n');
		}
		br.close();
		System.out.print(sb.toString());
	}
	
	static void comb(int idx, int cnt) {
		if(cnt==6) { //6개를 모두 뽑았을 때
			for(int i=0;i<6;i++) {
				sb.append(select[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=idx;i<k;i++) {
			select[cnt] = s[i];
			comb(i+1,cnt+1);
		}
	}
}
