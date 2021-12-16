import java.io.*;
import java.util.*;

public class Main_bj_b4_1712_손익분기점 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1712.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer=-1;//손익분기점
		int cnt=0;//노트북 개수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());//고정비용
		int b = Integer.parseInt(st.nextToken());//한대의 노트북 생산 비용(가변비용)
		int c = Integer.parseInt(st.nextToken());//노트북 가격
		
		if(b<c) {			
			answer=a/(c-b)+1;
		}
		br.close();
		System.out.print(answer);
	}
}
