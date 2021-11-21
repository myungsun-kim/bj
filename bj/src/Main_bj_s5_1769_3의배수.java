import java.io.*;
// 다른 문제로 바꾸어 풀기의 과정
// 1. 풀고자 하는 문제를 다른 문제로 변환한다
// 2. 변환된 문제의 답을 구한다
// 3. 구한 답을 원래 문제의 답으로 삼는다
// 예시
// 1. 양의 정수 x는 3의 배수인가? > x의 각 자리의 수를 단순히 더한 수 y를 만든다
// 2. y는 3의 배수인가?
// 문제 변환의 과정을 몇 번 거쳐야 Y가 한 자리 수가 되어 X가 3의 배수인지 아닌지를 알 수 있게 될지를 구하는 프로그램 작성
public class Main_bj_s5_1769_3의배수 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1769.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String x = br.readLine();
		int y = 0;
		int count = 0;
		
		if(x.length()==1) { //한 자리수인 경우
			y=Integer.parseInt(x);
		}else {
			while(x.length()!=1) {
				y = 0;				
				for(int i=0;i<x.length();i++) { //각 자리수를 더함
					y+=x.charAt(i)-'0';
				}
				count++;
				x = Integer.toString(y);
			}
		}
		br.close();
		sb.append(count).append('\n').append(y%3==0?"YES":"NO");
		System.out.print(sb.toString());
	}
}
