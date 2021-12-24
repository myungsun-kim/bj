import java.io.*;
import java.util.*;
// 세 개의 서로 다른 점이 주어질때 적절한 점 D를 찾아 평행사변형 만들기
// 만들 수 있는 사각형 중 가장 큰 둘레 길이와 가장 작은 둘레 길이의 차이 출력
// 만들 수 있는 평행사변형이 없다면 -1 출력
// 세 점이 한 직선에 있다면 평행 사변형을 만들 수 없음
public class Main_bj_s5_1064_평행사변형 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1064.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] dot = new int[3][2];
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		double answer = -1.0;
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<dot.length;i++) {
			dot[i][0] = Integer.parseInt(st.nextToken());
			dot[i][1] = Integer.parseInt(st.nextToken());
		}
		
		if(!((dot[1][1]-dot[0][1])*(dot[2][0]-dot[1][0])==(dot[1][0]-dot[0][0])*(dot[2][1]-dot[1][1]))){
			// 평행 사변형을 만들 수 없는 경우가 아니라면
			// 0,1 / 0,2
			// 0,1 / 1,2
			// 0,2 / 1,2
			int[][] idx = {{0,1,0,2},{0,1,1,2},{0,2,1,2}};
			for(int i=0;i<idx.length;i++) {				
				double tmp = Math.sqrt(Math.pow(dot[idx[i][0]][0]-dot[idx[i][1]][0], 2)+Math.pow(dot[idx[i][0]][1]-dot[idx[i][1]][1], 2))+Math.sqrt(Math.pow(dot[idx[i][2]][0]-dot[idx[i][3]][0], 2)+Math.pow(dot[idx[i][2]][1]-dot[idx[i][3]][1], 2));
				if(tmp<min) min=tmp;
				if(tmp>max) max=tmp;
			}
			answer = ((max-min)*2);
		}
		br.close();
		System.out.print(answer);
	}
}
