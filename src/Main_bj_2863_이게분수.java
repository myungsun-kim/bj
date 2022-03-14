import java.io.*;
import java.util.*;
// a b 
// c d 로 이루어진 2*2표에서 표의 값은 a/c+b/d
// 표는 90도 시계방향으로 돌릴 수 있다(최대 3)
// 표를 몇 번 회전시켜야 표의 값이 최대가 되는지 구하라
public class Main_bj_2863_이게분수 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_2863.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] graph = new int[4]; // 0 1 2 3 > a b c d
		int[][] rotate = {{0,1,2,3},{2,0,3,1},{3,2,1,0},{1,3,0,2}};
		StringTokenizer st = null;
		
		for(int i=0;i<graph.length;i++) {
			if(i%2==0) st = new StringTokenizer(br.readLine()," ");
			graph[i] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;
		double max = 0;
		for(int i=0;i<rotate.length;i++) {
			double tmp = (double)graph[rotate[i][0]]/graph[rotate[i][2]]+(double)graph[rotate[i][1]]/graph[rotate[i][3]];
			
			if(tmp>max) {
				max=tmp;
				answer=i;
			}
		}
		br.close();
		System.out.print(answer);
	}
}
