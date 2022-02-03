import java.io.*;
// 책 10권의 총 가격과 가격을 읽을 수 있는 9권 가격이 주어졌을 때, 가격을 읽을 수 없는 책의 가격을 구하는 프로그램을 작성하시오.
// 책 가격은 10000 이하의 양수
public class Main_bj_b3_5565_영수증 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_5565.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int price; //책의 총 가격
		final int count = 9; //가격을 읽을 수 있는 책의 개수
		price = Integer.parseInt(br.readLine());
		for(int i=0;i<count;i++) price-=Integer.parseInt(br.readLine());
		br.close();
		System.out.print(price);
	}
}
