import java.io.*;
import java.math.BigInteger;

public class Main_bj_13706_제곱근 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_13706.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		BigInteger n = new BigInteger(br.readLine());
		
		BigInteger answer = null;
		BigInteger left = new BigInteger("1");
		BigInteger right = n;
		
		while(true) {
			BigInteger mid = left.add(right).divide(new BigInteger("2"));
			BigInteger tmp = mid.pow(2); //mid의 제곱
			if(n.compareTo(tmp)==0) {
				answer = mid;
				break;
			}
			if(n.compareTo(tmp)<0){ //현재 answer보다 작은 값
				right = mid.subtract(new BigInteger("1")); 
			}else { //현재 answer보다 큰 값
				left = mid.add(new BigInteger("1"));
			}
		}
		br.close();
		System.out.print(answer);
	}
}