import java.io.*;
import java.util.*;
// 길거리에서 찾은 수에 포함된 숫자들을 섞어 30의 배수가 되는 가장 큰 수를 만들고 싶어한다
// N은 최대 10^5개의 숫자로 구성되어 있으며 0으로 시작하지 않는다
// 30의 배수가 존재하지 않는다면 -1을 출력
public class Main_bj_10610_30 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_10610.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] tmp = br.readLine().toCharArray();
		int[] count = new int[10]; //각 숫자가 몇 번 나왔는지
		StringBuilder sb = new StringBuilder();

		int sum = 0;
		for(int i=0;i<tmp.length;i++) {
			int number = Character.getNumericValue(tmp[i]);
			count[number]++;
			sum+=number;
		}
		
		if(sum%3==0 && count[0]!=0) {
			for(int i=9;i>=0;i--) {
				while(count[i]-->0) {
					sb.append(i);
				}
			}
			System.out.print(sb.toString());
		}else {
			System.out.print(-1);
		}
		
	}
}
