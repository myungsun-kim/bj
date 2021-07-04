import java.io.*;
import java.util.*;
//2xn 직사각형을 1x2, 2x1과 2x2 타일로 채우는 방법의 수 구하기
public class Main_bj_s3_11727_2xn타일링2 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_11727.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] memo=new int[n+1];
		if(n==1) {
			System.out.print(1);
			return;
		}else if(n==2) {
			System.out.print(3);
			return;
		}else {			
			memo[1]=1;
			memo[2]=3;
			
			for(int i=3;i<=n;i++) memo[i]=(2*memo[i-2]+memo[i-1])%10007;
			//2xn 직사각형을 타일로 채우는 방법
			//> n-1번째에서 1x2 타일을 붙이는 경우 
			//> n-2번째에서 2x1 타일 두 개 붙이는 경우
			//> n-2번째에서 2x2 타일 한 개 붙이는 경우
			//> n-2일때 타일로 채우는 방법x2+n-1일때 타일로 채우는 방법
		}
		br.close();
		System.out.print(memo[n]);
	}
}
