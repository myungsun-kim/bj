import java.io.*;
import java.util.*;

public class Main_bj_3052_나머지 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_3052.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[10];
		int cnt=0;
		boolean check;
		for(int i=0;i<10;i++) {
			check = true;
			arr[i] = Integer.parseInt(br.readLine())%42;
			for(int j=0;j<i;j++) {
				if(arr[j] == arr[i]) {
					check = false;
				}
			}
			if(check) cnt++;
		}
		br.close();
		sb.append(cnt);
		System.out.print(cnt);
	}
}