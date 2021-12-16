import java.io.*;
import java.util.*;

public class Main_bj_s5_1037_약수 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1037.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //N의 약수의 개수
		int min = 1000000;
		int max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<n;i++) {
			int tmp = Integer.parseInt(st.nextToken()); //N의 진짜 약수 개수
			if(min>tmp) min=tmp;
			if(max<tmp) max=tmp;
		}
		int answer = min*max;
		br.close();
		System.out.print(answer);
	}
}
