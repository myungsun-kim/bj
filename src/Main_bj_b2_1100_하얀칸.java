import java.io.*;
import java.util.*;
// .은 빈칸 F는 위에 말이 있는 칸
// 체스판은 8x8 크기, 검정 칸과 하얀 칸이 번갈아가면서 색칠되어 있음
// 가장 왼쪽 위칸(0,0)은 하얀색 0,0 0,2 0,4 0,6 / 1,1 1,3 1,5 1,7 / 2,0 2,2 .. (행이 짝수면 짝수열 홀수면 홀수열)
// 하얀 칸 위에 말이 몇 개 있는지
public class Main_bj_b2_1100_하얀칸 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1100.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int size = 8;
		int count = 0;
		for(int i=0;i<size;i++) {
			String input = br.readLine();
			for(int j=0;j<size;j++) {
				if(i%2==0) { //행이 짝수
					if(j%2==0 && input.charAt(j)=='F') count++;
				}else { //행이 홀수
					if(j%2==1 && input.charAt(j)=='F') count++;					
				}
			}
		}
		br.close();
		System.out.print(count);
	}
}
