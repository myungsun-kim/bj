import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_2839_설탕배달 {
	static int N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		int cnt = -1;//총 봉지의 개수
		int min = N/5;
		
		if(N == 5*min) {
			cnt = min;
		}else {
			while(min>=0) {
				if((N-5*min)%3 == 0) {
					cnt = (N-5*min)/3+min;
					break;
				}
				min--;
			}
		}
		sb.append(cnt);
		System.out.print(sb);
	}


}
