import java.io.*;
import java.util.*;

public class Main_bj_1193_분수찾기 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1193.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int loop=2, cnt=0;
		while(true) {
			if(loop%2==0) {
				for(int i=1;i<loop;i++) {
					cnt++;
					if(cnt==n) {
						System.out.print((loop-i)+"/"+i);
						return;
					}
				}				
			}else {
				for(int i=loop-1;i>0;i--) {
					cnt++;
					if(cnt==n) {
						System.out.print((loop-i)+"/"+i);
						return;
					}
				}
			}
			loop++;
		}
	}
}
