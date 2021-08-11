import java.io.*;
import java.util.*;
// 주어진 세 각의 크기가 모두 60이면 Equilateral
// 세 각의 합이 180이고, 두 각이 같은 경우에는 Isosceles
// 세 각의 합이 180이고, 같은 각이 없는 경우에는 Scalene
// 세 각의 합이 180이 아닌 경우에는 Error
public class Main_bj_b4_10101_삼각형외우기 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_10101.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] angle = new int[3];
		int sum = 0; //세 각의 합
		boolean equal = true; //정삼각형인지 아닌지

		for(int i=0;i<angle.length;i++) {
			angle[i] = Integer.parseInt(br.readLine());
			sum+=angle[i];
			if(angle[i]!=60) equal=false;
		}
		String answer="Scalene";
		if(equal) answer="Equilateral";
		else {
			if(sum!=180) {
				answer="Error";
			}else if(angle[0]==angle[1] || angle[1]==angle[2] || angle[0]==angle[2]) {
				answer="Isosceles";
			}
		}
		br.close();
		System.out.print(answer);
	}
}
