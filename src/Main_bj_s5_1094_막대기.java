import java.io.*;
// 지민이가 가지고 있는 막대의 길이를 모두 더한다. 처음에는 64cm 막대 하나만 가지고 있다. 이때, 합이 X보다 크다면, 아래와 같은 과정을 반복한다.
// 1 가지고 있는 막대 중 길이가 가장 짧은 것을 절반으로 자른다.
// 2만약, 위에서 자른 막대의 절반 중 하나를 버리고 남아있는 막대의 길이의 합이 X보다 크거나 같다면, 위에서 자른 막대의 절반 중 하나를 버린다.
// 이제, 남아있는 모든 막대를 풀로 붙여서 Xcm를 만든다.
// X가 주어졌을 때, 위의 과정을 거친다면, 몇 개의 막대를 풀로 붙여서 Xcm를 만들 수 있는지 구하는 프로그램을 작성하시오. 
public class Main_bj_s5_1094_막대기 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1094.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		int x = Integer.parseInt(br.readLine());
		char[] tmp = Integer.toBinaryString(x).toCharArray();
		for(int i=0;i<tmp.length;i++) {
			if(tmp[i]=='1') answer++;
		}
		br.close();
		System.out.print(answer);
	}
}
