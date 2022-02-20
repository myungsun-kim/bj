import java.io.*;
import java.util.*;

public class Main_bj_2869_달팽이는올라가고싶다 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2869.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());//낮에 a미터 올라가고
		int b = Integer.parseInt(st.nextToken());//밤에 b미터 내려가고
		int v = Integer.parseInt(st.nextToken());//나무 막대의 높이
		int cnt=1;//며칠이 걸리는지
//		int height=0;//현재 높이
		if((v-b)%(a-b)==0) {
			cnt = (v-b)/(a-b);			
		}else {
			cnt = (v-b)/(a-b)+1;				
		}
		
//		while(true) {
//			height+=a;
//			if(height>=v) break;
//			height-=b;
//			cnt++;
//		}
		br.close();
		System.out.print(cnt);
	}
}
