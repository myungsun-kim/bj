import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_16953_A_B {
	//A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값 출력
	//1.2를 곱한다 2.1을 수의 가장 오른쪽에 추가
	//만들 수 없는 경우는 -1
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_16953.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		int answer=1;
		while(a<b) {
			int end = b%10; //마지막 자리 수
			if(end==3 || end==5 || end==7 || end==9) {
				answer=-1;
				break;
			}else if(end==1) { // 1을 수의 가장 오른쪽에 추가
				answer++;
				b/=10;
			}else { // 2를 곱한다
				answer++;
				b/=2;
			}
			if(a==b)break;
			if(a>b) {
				answer=-1;
				break;
			}
		}
		br.close();
		System.out.print(answer);
	}
}