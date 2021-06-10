import java.io.*;

//회문 또는 팰린드롬은 앞 뒤 방향으로 볼 때 같은 순서의 문자로 구성된 문자열을 말함
//유사회문 = 그 자체는 회문이 아니지만 한 문자를 삭제하여 회문으로 만들 수 있는 문자열
//제시된 문자열이 회문인지 유사회문인지 일반 문자열인지 판단
//회문이면 0, 유사회문이면 1, 그 외는 2
public class Main_bj_s1_17609_회문 {
	static char[] input;
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_17609.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			input = br.readLine().toCharArray();
			int cnt=0;
			int size=input.length;
			
			for(int idx1=0;idx1<size/2;idx1++) {
				int idx2=size-idx1-1;
				if(input[idx1]!=input[idx2]) {
					if(idx2-1>=0 && input[idx1]==input[idx2-1]) {
						//input[idx2]를 지웠을 경우
						int tmp1=idx1;
						int tmp2=idx2-1;
						cnt=1;
						while(++tmp1<--tmp2) {
							if(input[tmp1]!=input[tmp2]) {
								cnt=2;
								break;
							}
						}
						if(cnt==1) break;
					}
					if(idx1+1<=size/2 && input[idx1+1]==input[idx2]) {
						//input[idx1]를 지웠을 경우
						int tmp1=idx1+1;
						int tmp2=idx2;
						cnt=1;
						while(++tmp1<--tmp2) {
							if(input[tmp1]!=input[tmp2]) {
								cnt=2;
								break;
							}
						}
						if(cnt>=1) break;
					}
					cnt=2;
					break;
				}
			}
			sb.append(cnt).append('\n');
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb.toString());
	}
}
