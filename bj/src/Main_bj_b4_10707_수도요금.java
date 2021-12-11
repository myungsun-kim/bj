import java.io.*;
// x사: 1리터당 a엔
// y사: 기본 요금 b엔, 사용량이 c리터가 넘을 경우 b+(사용량-c)*d
// 한 달간 쓰는 수도의 양은 p
public class Main_bj_b4_10707_수도요금 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_10707.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine()); //x사의 1리터당 요금
		int b = Integer.parseInt(br.readLine()); //y사의 기본요금
		int c = Integer.parseInt(br.readLine()); //y사의 요금이 기본요금이 되는 상한 c
		int d = Integer.parseInt(br.readLine()); //1리터당 추가요금
		int p = Integer.parseInt(br.readLine()); //한 달간 사용하는 수도의 양
		
		int answer = Math.min(a*p, p>c?b+d*(p-c):b);
		
		br.close();
		System.out.print(answer);
	}
}
