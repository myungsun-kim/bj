import java.io.*;

//이진수 m이 2^k로 나누어떨어지는지 여부를 판별하는 프로그램 작성
public class Main_bj_b1_22950_이진수나눗셈 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_22950.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //이진수 m의 자리수
		char[] tmp = br.readLine().toCharArray();
		boolean[] m = new boolean[n];
		boolean check=true; //나누어떨어지는지 여부
	
		for(int i=0;i<n;i++) {
			m[i] = tmp[n-1-i]-'0'==1?true:false;
		}
		
		int k = Integer.parseInt(br.readLine()); //나누는 수 2^k의 k
		
		for(int i=0;i<k;i++) {
			if(i>=n) break;
			if(m[i]) {
				check=false;
				break;
			}
		}
		
		br.close();
		if(check) System.out.print("YES"); 
		else System.out.print("NO"); 
	}
}
