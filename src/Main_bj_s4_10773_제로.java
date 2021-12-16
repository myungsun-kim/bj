import java.io.*;
import java.util.*;

public class Main_bj_s4_10773_제로 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_10773.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int input;
		int sum=0;
		Stack<Integer> s = new Stack<>();
		for(int i=0;i<N;i++) {
			input = Integer.parseInt(br.readLine());
			if(input==0) {
				sum-=s.pop();
			}else {
				s.push(input);
				sum+=input;
			}
		}
		br.close();
		System.out.print(sum);
	}
}
