import java.io.*;
import java.util.*;
// 강의 서쪽에는 N개의 사이트 동쪽에는 M개의 사이트가 있음 N<=M
// 서쪽의 사이트와 동쪽의 사이트를 다리로 연결하려고 함. 총 N개의 다리를 지으려고 함
// 다리를 지을 수 있는 경우의 수 구하기
// mCn = m-1Cn+m-1Cn-1 이용
public class Main_bj_1010_다리놓기 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1010.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] comb = new int[M+1][N+1];//nCr 저장
			for(int i=0;i<=M;i++) {//nC0은 1
				comb[i][0]=1;
			}
			for(int i=1;i<=M;i++) {
				for(int j=1;j<=N;j++) {
					if(i==j) {
						comb[i][j]=1;// nCn은 1
					}else {						
						comb[i][j] = comb[i-1][j-1]+comb[i-1][j];
					}
				}
			}
			sb.append(comb[M][N]).append('\n');
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb.toString());
	}
}
