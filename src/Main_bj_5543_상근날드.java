import java.io.BufferedReader;
import java.io.InputStreamReader;

// 세트로 구매시 (햄버거+음료)가격 합계-50 / 가장 싼 세트 메뉴의 가격 출력
// 1-3 버거의 가격 4 콜라의 가격 5 사이다의 가격(가격은 100이상 2000이하)
public class Main_bj_5543_상근날드 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_5543.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int burgerCount = 3;
		final int drinkCount = 2;
		int burger = 2000;
		int drink = 2000;
		
		for(int i=0;i<burgerCount;i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(burger>tmp) burger=tmp;
		}
		for(int i=0;i<drinkCount;i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(drink>tmp) drink=tmp;
		}
		br.close();
		System.out.print(drink+burger-50);
	}
}
