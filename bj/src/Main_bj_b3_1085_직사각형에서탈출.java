import java.io.*;
import java.util.*;

public class Main_bj_b3_1085_직사각형에서탈출 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1085.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int x = Integer.parseInt(st.nextToken());//현 위치 x
		int y = Integer.parseInt(st.nextToken());//현 위치 y
		int w = Integer.parseInt(st.nextToken());//오른쪽 위 꼭지점 x
		int h = Integer.parseInt(st.nextToken());//오른쪽 위 꼭지점 y
		br.close();
		System.out.print(Math.min(Math.min(Math.abs(x-w), x), Math.min(Math.abs(y-h),y)));
	}
}
