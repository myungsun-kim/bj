import java.io.*;

//괄호를 적절히 쳐서 최소의 값이 나오도록
//식은 0~9,+,-로만 이루어져있고 가장 처음과 마지막은 숫자이다
//연속해서 두 개 이상의 연산자가 나타나지 않고 5자리보다 많이 연속되는 숫자는 없다.수는 0으로 시작할 수 없다
//-뒤의 숫자가 최대값이 되도록, +뒤의 숫자가 최소값이 되도록
//첫 숫자는 무조건 +가 됨
public class Main_bj_s2_1541_잃어버린괄호 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1541.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int answer=0;
		boolean chk=true; //- 부호가 한 번도 나오지 않음
		for(int i=0;i<input.length;i++) {
			int num=0;
			while(true) {
				int tmp=input[i]-'0';
				num*=10;
				num+=tmp;
				i++;
				if(i==input.length) break;
				if(input[i]=='+' || input[i]=='-') break;
			}
			if(chk) {
				answer+=num;
				if(i<input.length && input[i]=='-') chk=false;//앞으로 나오는 수들은 마이너스
			}else {
				answer-=num;				
			}
		}
		br.close();
		System.out.print(answer);
	}
}
