import java.io.*;
import java.util.*;
// 전치 암호: 문자열의 대응되는 순서가 바뀌는 것
// 복호화를 할 때 암호화된 문장에서 첫 번째 글자를 가져옴. 그리고 N만큼 떨어진 거리에 있는 문자들을 가져옴(N-1개의 문자들은 건너뜀)
// 문자열 끝에 다다르면 다시 두 번째 위치의 문자로 되돌아가 같은 과정을 방문. 입력한 평문에서 모든 영문자를 사용하면 끝나게 됨
// 모든 문자를 대문자로 변경 후 단어 사이의 공백을 모두 제외한 평문으로 암호문 만들기
public class Main_bj_s3_6616_문자열암호화 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_6616.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			char[] input = br.readLine().toUpperCase().replace(" ", "").toCharArray();
			int size = input.length;
			char[] encode = new char[size];
			int idx = 0;
			
			for(int i=0;i<n;i++) {
				for(int j=i;j<size;j+=n) {
					encode[j]=input[idx++];
				}
			}
			
			for(int i=0;i<size;i++) {
				sb.append(encode[i]);
			}
			sb.append('\n');
		}
		br.close();
		System.out.print(sb.toString());
	}
}
