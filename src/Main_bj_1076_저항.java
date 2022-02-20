import java.io.*;
import java.util.*;
// 처음 나오는 두 개의 색은 저항의 값
// 마지막 색은 곱해야 하는 값
public class Main_bj_1076_저항 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1076.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// black, brown, red, orange, yellow, green, blue, violet, grey, white 순
		HashMap<String, Integer> hash = new HashMap<>();
		int value = 0;
		hash.put("black", value++);
		hash.put("brown", value++);
		hash.put("red", value++);
		hash.put("orange", value++);
		hash.put("yellow", value++);
		hash.put("green", value++);
		hash.put("blue", value++);
		hash.put("violet", value++);
		hash.put("grey", value++);
		hash.put("white", value);
		
		long answer = 0;
		
		for(int i=0;i<2;i++) {
			answer+=hash.get(br.readLine())*Math.pow(10, 1-i);
		}
		
		String third = br.readLine();
		for(int i=0;i<hash.get(third);i++) {
			answer*=10;
		}
		
		br.close();
		System.out.print(answer);
	}
}
