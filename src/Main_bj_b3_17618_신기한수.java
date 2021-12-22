import java.io.*;
import java.util.*;
// 신기한 수=각 자리수를 더한 수가 원래의 수의 약수가 됨
// 주어진 N 이하인 신기한 수는 총 몇 개인지 계산
public class Main_bj_b3_17618_신기한수 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_17618.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		int n = Integer.parseInt(br.readLine());
		for(int i=1;i<=n;i++) {
			if(check(i)) cnt++;
		}
		br.close();
		System.out.print(cnt);
	}
	
	
	// 해당 수가 신기한 수인지
	static boolean check(int input) {
		int sum = 0;
		int num = input;
		
		while(input>0) {
			sum+=input%10;
			input/=10;
		}
		
		if(num%sum==0) return true;
		return false;
	}
}
