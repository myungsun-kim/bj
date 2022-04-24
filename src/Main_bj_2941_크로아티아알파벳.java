import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
// c=, c-, dz=, d-, lj, nj, s=, z= 를 하나의 알파벳으로 셈
public class Main_bj_2941_크로아티아알파벳 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_2941.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int answer = 0;
		for(int i=input.length-1;i>=0;--i) {
			if(i>0 && input[i]=='=') {
				if(input[i-1]=='c' || input[i-1]=='s') { //c=, s=
					++answer;
					--i;
				}else if(input[i-1]=='z') { //z=, dz=
					++answer;
					--i;
					if(i>0 && input[i-1]=='d') { //dz=
						--i;
					}
				}
			}else if(i>0 && input[i]=='-') { //c-, d-
				if(input[i-1]=='c' || input[i-1]=='d') {
					++answer;
					--i;
				}
			}else if(i>0 && input[i]=='j') { //lj, nj
				++answer;
				if(input[i-1]=='l' || input[i-1]=='n') {
					--i;
				}
			}else {
				++answer;
			}
		}
		br.close();
		System.out.print(answer);
	}
}
