import java.io.*;
import java.util.*;

public class X_Main_bj_17413_단어뒤집기2 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_17413.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		char[] s = new char[input.length()];//문자를 담아놓는 배열
		boolean[] check = new boolean[input.length()];//<,>의 위치
		boolean chk=false;
		//< > 인덱스를 구한뒤 인덱스 범위 안이면 똑바로, 아니면 거꾸로 출력..
		int tmp_idx=0;
		for(int i=0;i<input.length();i++) {
		
		}

		
		for(int i=0;i<input.length();i++) {
			if(check[i]) {
				sb.append(i);
			}else {
				
			}
		}
	}
}
