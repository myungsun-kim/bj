import java.io.*;
import java.util.*;
// 세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점 찾기
// 좌표는 1보다 크거나 같고 1000보다 작거나 같은 정수
public class Main_bj_b3_3009_네번째점 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_3009.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[][] node = new int[3][2];
		for(int i=0;i<3;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			node[i][0] = Integer.parseInt(st.nextToken());
			node[i][1] = Integer.parseInt(st.nextToken());			
		}
		int x, y;
		if(node[0][0] == node[1][0]) {
			x= node[2][0];
		}else if(node[0][0] == node[2][0]) {
			x= node[1][0];
		}else {
			x= node[0][0];			
		}
		if(node[0][1] == node[1][1]) {
			y= node[2][1];
		}else if(node[0][1] == node[2][1]) {
			y= node[1][1];
		}else {
			y= node[0][1];			
		}
		br.close();
		System.out.print(x+" "+y);
	}
}
