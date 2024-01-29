import java.io.*;

public class Main_bj_16916_부분문자열 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_16916.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] P = br.readLine().toCharArray();
		char[] S = br.readLine().toCharArray();
		
		int p_size=P.length;
		int s_size=S.length;
		int answer=0;
		
		for(int i=0;i<=p_size-s_size;i++) {
			if(P[i]==S[0]) {
				boolean chk=true;
				
				for(int j=1;j<s_size;j++) {
					if(P[i+j]!=S[j]) {
						chk=false;
						break;
					}
				}
				if(chk) {					
					answer=1;
					break;
				}
			}
		}
		br.close();
		System.out.print(answer);
	}
}
