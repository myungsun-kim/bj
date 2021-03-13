import java.io.*;
import java.util.*;
public class Main_bj_4673_셀프넘버 {
	public static void main(String[] args) throws Exception{
		boolean[] exist = new boolean[10001];//1~10000인덱스 사용
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<=10000;i++) {
			for(int j=1;j<=10000;j++) {
				if(i==d(j)) {
					exist[i] = true;
					break;
				}
			}if(!exist[i]) sb.append(i).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}

	private static int d(int n) {//n은 d(n)의 생성자
		int num = n;
		while(n!=0) {
			num+=n%10;
			n/=10;
		}
		return num;
	}
}
