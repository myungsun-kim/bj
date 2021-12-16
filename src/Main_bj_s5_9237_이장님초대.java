import java.io.*;
import java.util.*;
// 마당에 심기 위한 나무 묘목 n개. 묘목 하나를 심는데 걸리는 시간은 1일
// 묘목의 수 N개, 각 나무가 다 자라는데 며칠이 걸리는지는 t[i]
// 마지막 나무가 다 자란 다음날 이장님을 초대. 최대한 빨리 초대하려고 함
// 자라는데 가장 오래 걸리는 묘목부터 심어준다
public class Main_bj_s5_9237_이장님초대 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_9237.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[] t = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			t[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(t, Collections.reverseOrder());//역정렬. 차례대로 심음
		
		for(int i=0;i<N;i++) {//묘목 심는 날 계산
			t[i]+=(i+1);
		}
		
		int day=1;

		for(int i=0;i<N;i++) {
			while(true) {
				if(t[i]-day<=0) break;
				day++;
			}
		}

		br.close();
		System.out.print(day+1);
	}
}
