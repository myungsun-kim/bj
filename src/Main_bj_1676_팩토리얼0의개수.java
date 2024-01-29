import java.io.*;

// N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램 작성
public class Main_bj_1676_팩토리얼0의개수 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1676.txt"));
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());

		int cnt_2=0;
		int cnt_5=0;
		for(int i=1;i<=N;i++) {
			int num=i;
			while(num%5==0) {
				cnt_5++;
				num/=5;
			}
			while(num%2==0) {
				cnt_2++;
				num/=2;
			}
		}
		br.close();
		System.out.print(Math.min(cnt_2, cnt_5));
	}
}
