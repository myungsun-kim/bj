import java.io.*;
import java.util.*;

public class Main_bj_s1_16953_A_B {
	//A를 B로 바꾸는데 필요한 연산의 최솟값
	//1.2를 곱한다 2.1을 수의 가장 오른쪽에 추가
	//만들 수 없는 경우는 -1
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_16953.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int A=Integer.parseInt(st.nextToken());
		int B=Integer.parseInt(st.nextToken());
		int answer=1;
		while(A<B) {
			if(B%10==3 || B%10==5 || B%10==7 || B%10==9) {
				answer=-1;
				break;
			}else if(B%10==1) {
				answer++;
				B/=10;
			}else {
				answer++;
				B/=2;
			}
			if(A==B)break;
			if(A>B) {
				answer=-1;
				break;
			}
		}
		br.close();
		System.out.print(answer);
	}
}