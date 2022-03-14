import java.io.*;
// 택시 기하학에서 두 점 사이의 거리는 |x1-x2|+|y1-y2|
// 반지름 R이 주어졌을 때, 유클리드 기하학에서 원의 넓이와 택시 기하학에서 원의 넓이를 구하여라
// 유클리드 기하학에서의 원의 넓이 PI*R*R
// 택시 기하학에서의 원의 넓이 2*R*R
public class Main_bj_3053_택시기하학 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_3053.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double R = Double.parseDouble(br.readLine());//반지름 
		double p = Math.PI;
		System.out.println(String.format("%.6f", p*R*R));
		System.out.print(String.format("%.6f", 2*R*R));
		br.close();
	}
}
