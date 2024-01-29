import java.io.*;

// N+1개의 I와 N개의 O로 이루어져 있으면, I와 O가 교대로 나오는 문자열을 Pn이라고 한다.
// P1: IOI / P2: IOIOI / P3: IOIOIOI / P4: IOIOI...OI (O가 N개) > 시작과 끝은 I
// I와 O로만 이루어진 문자열 S와 정수 N이 주어졌을 때, S안에 Pn이 몇 군데 포함되어 있는지 구하는 프로그램 작성
// IO 패턴 저장. 패턴이 N번 반복 되고 다음 문자가 I라면 Pn하나 완성
public class Main_bj_5525_IOIOI {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_5525.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine()); 
		int M=Integer.parseInt(br.readLine()); //S의 길이
		char[] S = br.readLine().toCharArray();
		int answer=0;
		int pattern_cnt=0;
		for(int i=0;i<M;i++) {
			if(S[i] == 'I') {//해당 위치에 I가 있는 경우
				if(pattern_cnt==N) {
					answer++;
					pattern_cnt--;//해당 인덱스 -2부터 시작하는 경우
				}
				if(i<M-1 && S[i+1]!='O') pattern_cnt=0; //패턴 반복 깨짐
			}else {//해당 위치에 O가 있는 경우
				if(i>0 && S[i-1]=='I') pattern_cnt++;//IO 패턴 한번 반복
				else pattern_cnt=0; //패턴 반복 깨짐
			}
		}
		System.out.print(answer);
	}
}
