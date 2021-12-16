import java.io.*;
import java.util.*;
public class Main_bj_s5_12871_무한문자열 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_12871.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer=1;
		
		char[] c1 = br.readLine().toCharArray();
		char[] c2 = br.readLine().toCharArray();

		int loop=c1.length*c2.length;
		
		for(int i=0;i<loop;i++) {//두 문자열의 크기의 곱만큼 반복 체크
			if(c1[i%c1.length]!=c2[i%c2.length]) {
				answer=0;
				break;
			}
		}
		br.close();
		System.out.print(answer);
	}
}
