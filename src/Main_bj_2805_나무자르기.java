import java.io.*;
import java.util.*;
// 필요한 나무의 길이 : M
// 절단기의 높이 : H > 높이를 지정하면 톱날이 땅으로부터 H미터 위로 올라가고, 한 줄에 연속해있는 나무를 모두 절단. 0이상의 정수
//				> 높이가 H보다 큰 나무는 H위의 부분이 잘리고, 낮은 나무는 잘리지 않을 것.
// 적어도 M 미터의 나무를 가져가기 위해 절단기에 설정할 수 있는 높이의 최댓값 구하기
public class Main_bj_2805_나무자르기 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N=Integer.parseInt(st.nextToken()); //나무의 수
		int M=Integer.parseInt(st.nextToken()); //가져가려고 하는 나무의 길이
		st = new StringTokenizer(br.readLine());
		int[] height = new int[N]; //N개의 나무의 높이
		for(int i=0;i<N;i++) {
			height[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(height);
		for(int i=height[N-1];i>=0;i--) {//i=절단기에 설정되는 높이
			int sum=0;
			for(int j=N-1;j>=0;j--) {//전체 나무의 길이 비교
				if(height[j]<i) break; //절단기의 높이가 현재 나무보다 큰 경우 계산X
				sum+=height[j]-i;
			}
			if(sum>=M) {
				System.out.print(i);
				break;
			}
		}
	}
}
