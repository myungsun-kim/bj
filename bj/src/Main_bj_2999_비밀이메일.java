import java.io.*;
import java.util.*;
// R<=C, R*C=N인 R,C 중 R이 큰 값
public class Main_bj_2999_비밀이메일 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2999.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String msg = br.readLine(); //msg.length() = N
		int R=0, C=0;
		for(int i=1;i<=Math.sqrt(msg.length());i++) {
			if(msg.length()%i==0) {
				R=i;
				C=msg.length()/R;
			}
		}

		char[][] arr = new char[R][C];
		int idx=0;
		for(int i=0;i<C;i++) {
			for(int j=0;j<R;j++) {
				arr[j][i] = msg.charAt(idx++);
			}
		}
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				sb.append(arr[i][j]);
			}
		}
		br.close();
		System.out.print(sb);
		
	}
}
