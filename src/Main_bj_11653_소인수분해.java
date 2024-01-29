import java.io.*;

public class Main_bj_11653_소인수분해 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_11653.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N==1) return;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=2;i<=N;i++) {
			while(N%i==0) {
				N/=i;
				sb.append(i).append('\n');
			}
			if(N==1) break;
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb.toString());
	}
}
