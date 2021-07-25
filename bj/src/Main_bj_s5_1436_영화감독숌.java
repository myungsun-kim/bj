import java.io.*;
import java.util.*;

public class Main_bj_s5_1436_영화감독숌 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1436.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int tmp=666;
		int cnt=0;
		while(true) {
			if(Integer.toString(tmp).contains("666")) cnt++;
			if(cnt==n) {
				System.out.print(tmp);
				return;
			}
			tmp++;
			br.close();
		}
	}
}
