import java.io.*;
import java.util.*;
// n 삼각형의 크기
// 맨 위층부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때, 최대의 합이 될 수 있는 경우 출력
// 아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택 가능
public class Main_bj_1932_정수삼각형 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1932.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int answer = 0;
		
		for(int i=0;i<n;i++) { // 삼각형 값을 입력받으며 현재 위치에서 가장 큰 합의 값 구하기
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int idx = 0;
			while(st.hasMoreTokens()) {
				int tmp = Integer.parseInt(st.nextToken());
				if(i==0) arr[i][idx] = tmp;
				else if(idx==0) arr[i][idx] = arr[i-1][0]+tmp;
				else arr[i][idx] = Math.max(arr[i-1][idx-1], arr[i-1][idx])+tmp;
				++idx;
			}
		}
		
		for(int i=0;i<n;i++) if(answer<arr[n-1][i]) answer = arr[n-1][i]; //가장 합이 큰 경우 구하기
		br.close();
		System.out.print(answer);
	}
}
