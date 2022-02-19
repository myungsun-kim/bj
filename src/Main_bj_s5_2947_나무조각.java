import java.io.*;
import java.util.*;
// 첫째 줄에 조각에 쓰여 있는 수가 순서대로 주어짐
// 1 첫 번째 조각의 수가 두 번째 수보다 크다면, 둘의 위치를 서로 바꾼다.
// 2 두 번째 조각의 수가 세 번째 수보다 크다면, 둘의 위치를 서로 바꾼다.
// 3 세 번째 조각의 수가 네 번째 수보다 크다면, 둘의 위치를 서로 바꾼다.
// 4 네 번째 조각의 수가 다섯 번째 수보다 크다면, 둘의 위치를 서로 바꾼다.
// 5 만약 순서가 1, 2, 3, 4, 5 순서가 아니라면 1 단계로 다시 간다.
// 다음의 과정을 거쳐서 1 2 3 4 5의 순서로 만들려고 한다
// 처음 조각의 순서가 주어졌을 때 위치를 바꿀 때마다 조각의 순서 출력
public class Main_bj_s5_2947_나무조각 {
	static int[] input;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_2947.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int count = 5;
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		input = new int[count+1];
		for(int i=1;i<input.length;i++) input[i] = Integer.parseInt(st.nextToken());
		for(int i=1;i<count;i++) {
			if(input[i]>input[i+1]) {
				change(i,i+1); //순서 바꾸기
				if(print()) break; //순서가 바뀌었다면 출력
			}
			if(i==count-1) i=0;
		}
		br.close();
		System.out.print(sb.toString());
	}
	
	static void change(int idx1, int idx2) {
		int tmp = input[idx2];
		input[idx2] = input[idx1];
		input[idx1] = tmp;
	}
	
	static boolean print() {
		boolean check = true; //현재 순서가 차례대로인지
		for(int i=1;i<input.length;i++) {
			if(input[i]!=i) check=false;
			sb.append(input[i]).append(' ');
		}
		sb.append('\n');
		return check;
	}
}
