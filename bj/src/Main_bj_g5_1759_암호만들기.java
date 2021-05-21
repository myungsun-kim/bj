import java.io.*;
import java.util.*;

public class Main_bj_g5_1759_암호만들기 {
	static int l, c;//암호 문자의 개수, 주어진 문자의 개수
	static char[] arr, selected;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1759.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 암호는 서로 다른 L개의 알파벳 소문자들로 구성되며 최소 한 개의 모음(a,e,i,o,u)과 최소 두 개의 자음으로 구성. 암호는 정렬되어있음
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		l = Integer.parseInt(st.nextToken());//암호 문자의 개수
		c = Integer.parseInt(st.nextToken());//주어진 문자의 개수
		arr = new char[c];//문자의 개수

		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<c;i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		selected = new char[l];
		
		comb(0,0,0,0);
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
	
	static void comb(int cnt, int idx, int cons_cnt, int vowel_cnt) {
		if(c-idx<l-cnt) return;
		
		if(cnt==l) {
			if(vowel_cnt>=1 && cons_cnt>=2) {
				for(int i=0;i<l;i++) {
					sb.append(selected[i]);
				}
				sb.append("\n");
			}
			return;
		}
		
		for(int i=idx;i<c;i++) {				
			selected[cnt]=arr[i];

			if(selected[cnt]=='a' || selected[cnt]=='e' || selected[cnt]=='i' || selected[cnt]=='o' || selected[cnt]=='u') {
				comb(cnt+1, i+1, cons_cnt, vowel_cnt+1);
			}else {
				comb(cnt+1, i+1, cons_cnt+1, vowel_cnt);
			}
		}
	}
}
