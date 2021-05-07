import java.io.*;
import java.util.*;
//학점을 잘 받을 수 있으면서도 중요한 과목을 듣고 싶은 서윤이는 모든 과목의 중요도와 일정 이상의 학점을 받기 위해 필요한 공부 시간을 적음
//공부 시간의 한계를 초과하지 않으면서 과목의 중요도 합이 최대가 되도록
public class Main_bj_17845_수강과목 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_17845.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N=Integer.parseInt(st.nextToken());//최대 공부 시간
		int K=Integer.parseInt(st.nextToken());//과목 수
		int[] profits=new int[K+1];//과목의 중요도
		int[] time=new int[K+1];//과목의 필요한 공부 시간
		int[][] D=new int[N+1][K+1];//해당 과목까지 고려하여 해당 시간동안의 최대 중요도
		for(int i=1;i<=K;i++) {
			st = new StringTokenizer(br.readLine()," ");
			profits[i]=Integer.parseInt(st.nextToken());
			time[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=K;i++) {//0번 인덱스의 과목부터 고려
			for(int t=1;t<=N;t++) {
				if(time[i]<=t) {
					D[t][i]=Math.max(D[t-time[i]][i-1]+profits[i], D[t][i-1]);
				}else {
					D[t][i]=D[t][i-1];
				}
			}
		}
		br.close();
		System.out.print(D[N][K]);
	}
}
