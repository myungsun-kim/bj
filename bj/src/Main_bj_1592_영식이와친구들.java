import java.io.*;
import java.util.*;

public class Main_bj_1592_영식이와친구들 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1592.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//1-N까지 자리
		int M = Integer.parseInt(st.nextToken());//한 사람이 M번 받을시 게임 끝남
		int L = Integer.parseInt(st.nextToken());
		int cnt=0;//공을 던지는 총 횟수
		int idx=0;//임시 인덱스
		int[] p = new int[N];
		while(true) {// 0 1 2 3 4 +2 > 2(현재+2) -2 > 3(맨끝-(2-1)..
			if(p[idx]%2==0) {//현재 받은 횟수가 짝수이면
				cnt++;
				if(idx>=L) {
					idx-=L;
					p[idx]++;
				}else{
					idx=idx-L+N;
					p[idx]++;
				}
			}else {//현재 받은 횟수가 홀수이면
				cnt++;
				if(idx<=N-L-1) {
					idx+=L;
					p[idx]++;
				}else{//idx = idx+L-N-1;
					idx=idx+L-N;
					p[idx]++;
				}
			}
			if(p[idx]==M) break;
		}
		br.close();
		System.out.print(cnt-1);
	}
}
