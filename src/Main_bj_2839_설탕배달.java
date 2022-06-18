import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_2839_설탕배달 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		int cnt = -1;//총 봉지의 개수
		int min = n/5;
		
		if(n == 5*min) {
			cnt = min;
		}else {
			while(min>=0) {
				if((n-5*min)%3 == 0) {
					cnt = (n-5*min)/3+min;
					break;
				}
				min--;
			}
		}
		br.close();
		System.out.print(cnt);
	}
}
