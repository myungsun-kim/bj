import java.io.*;
import java.util.*;
// 컴퓨터에 1-10까지의 번호를 부여하고 1번,11번 데이터는 1번 컴퓨터 2번,12번 데이터는 2번 컴퓨터..식으로 처리
// 총 데이터의 개수는 항상 a^b개의 형태로 주어짐. 마지막 데이터가 처리될 컴퓨터의 번호를 구하는 프로그램 작성
public class Main_bj_1009_분산처리 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1009.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		int number; //마지막 데이터가 처리될 컴퓨터의 번호
		for(int i=0;i<t;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());//1부터 99이하의 정수
			int b = Integer.parseInt(st.nextToken());//1부터 999999 이하의 정수
			if(a>=10) a%=10;//마지막 자리 수
			if(a==0) {
				number=10;
			}else if(a==1 || a==5 || a==6) {
				number=a;
			}else if(a==4 || a==9) {
				if(b%2==0) {//짝수이면
					number=a*a%10;
				}else {
					number=a;
				}
			}else {
				int loop=(b%4==0?4:b%4);
				number=(int) Math.pow(a, loop)%10;
			}
			
			sb.append(number).append('\n');
		}
		br.close();
		System.out.print(sb.toString());
	}
}
