import java.io.*;
import java.util.*;

public class Main_bj_b3_8320_직사각형을만드는방법 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_8320.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());//변의 길이가 1인 정사각형 n개
		int cnt=0;//n개의 정사각형으로 만들 수 있는 직사각형의 개수
		int x,y; //n개의 정사각형으로 만들어지는 직사각형의 가로,세로. x*y<=n
		
		for(int i=1;i<n;i++) {
			for(int j=1;j<=n/i;j++) {
				if(i<j) continue;
				cnt++;
			}
		}
		System.out.print(cnt+1);
	}
}
