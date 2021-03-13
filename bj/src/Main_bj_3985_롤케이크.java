import java.io.*;
import java.util.*;
public class Main_bj_3985_롤케이크 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_3985.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int L = Integer.parseInt(br.readLine()); //롤케이크의 길이
		int N = Integer.parseInt(br.readLine()); //방청객의 수
		int[] cake = new int[L+1];//케이크 조각에 매겨지는 번호. 1~L인덱스 사용
		int[][] p = new int[N+1][2];//[i][0]번 조각부터 [i][1]번 조각까지 원함. 1~N인덱스 사용
		int[] count = new int[N+1];//한 사람이 몇 조각을 가져가는지
		int exp=0, real=0; //가장 많이 받을 거라고 기대했던 사람 / 실제로 가장 많이 받은 사람
		int dif=0, cnt=0;
		StringTokenizer st;
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			p[i][0] = Integer.parseInt(st.nextToken());
			p[i][1] = Integer.parseInt(st.nextToken());
			if(dif<p[i][1]-p[i][0]) {
				dif = p[i][1]-p[i][0];
				exp=i;//가장 많이 받을 것이라고 예상했던 사람
			}
			
			for(int j=p[i][0];j<=p[i][1];j++) {
				if(cake[j]==0) {//해당 케이크를 선택한 사람이 없으면
					cake[j]=i;//해당 케이크에 번호를 매김
					count[i]++;//해당 사람이 가져가는 케이크의 수
				}
				if(cnt<count[i]) {
					cnt=count[i];
					real = i;
				}
			}
		}
		br.close();
		sb.append(exp).append("\n").append(real);
		System.out.print(sb);
	}
}
