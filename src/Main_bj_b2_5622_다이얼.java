import java.io.*;
import java.util.*;
//n초를 누르기위해(걸기위해선) n+1초 걸린다
public class Main_bj_b2_5622_다이얼 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_5622.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sec=0;//총 몇 초 걸리는지
		String input = br.readLine();//입력받은 단어
		
		for(int i=0;i<input.length();i++) {
			if((input.charAt(i)-65)>=22)  {
				sec+=10;
			}else if((input.charAt(i)-65)>=19) {
				sec+=9;
			}else if((input.charAt(i)-65)>=15) {
				sec+=8;
			}else if((input.charAt(i)-65)>=12) {
				sec+=7;
			}else if((input.charAt(i)-65)>=9) {
				sec+=6;
			}else if((input.charAt(i)-65)>=6) {
				sec+=5;
			}else if((input.charAt(i)-65)>=3) {
				sec+=4;
			}else if((input.charAt(i)-65)>=0) {
				sec+=3;
			}
		}
		System.out.print(sec);

	}
}
