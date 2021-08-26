import java.io.*;

// 잔돈 500,100,50,10,5,1이 있음
// 1000 지폐 한 장을 냈을 때 가장 적은 잔돈의 개수를 구함
public class Main_bj_b2_5585_거스름돈 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_5585.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int money = 1000; //받은 금액
		int[] coin = {500, 100, 50, 10, 5, 1};
		int n = Integer.parseInt(br.readLine()); //물건의 가격
		int count = 0; //동전의 개수
		money-=n;
		
		for(int i=0;i<coin.length;i++) {
			count+=money/coin[i];
			money%=coin[i];
			if(money==0) break;
		}
		System.out.print(count);
	}
}
