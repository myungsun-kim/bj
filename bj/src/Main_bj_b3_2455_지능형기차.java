import java.io.*;
import java.util.*;
// 기차에는 4개의 역이 있다
// 기차는 역 번호 순서대로 운행한다
// 각 역에서 현재 기차에 있는 사람보다 더 많은 사람이 내리는 경우는 없다
// 기차의 정원은 최대 10000명이고 정원을 초과하여 타는 경우는 없다
public class Main_bj_b3_2455_지능형기차 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2455.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int count = 4; //역의 개수
		int[] train = new int[count];
		
		int max = 0; //최대 사람 수
		int sum = 0; //현재 사람 수
		for(int i=0;i<count;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			sum=sum-Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken());
			// 사람이 먼저 내린 후 탐
			if(sum>max) max=sum;
		}
		br.close();
		System.out.print(max);
	}
}
