import java.io.*;
import java.util.*;
// 배 0 등 1
// A도(배 한 개, 등 세 개), B개(배 두 개, 등 두 개), C걸(배 세 개, 등 한 개), D윷(배 네 개), E모(등 네 개)
public class Main_bj_2490_윷놀이 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2490.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int count = 3;
		for(int i=0;i<count;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int zeroCount = 0; //배의 개수 카운트
			while(st.hasMoreTokens()) {
				if(Integer.parseInt(st.nextToken())==0) ++zeroCount;
			}
			switch(zeroCount) {
				case 0:
					sb.append('E');
					break;
				case 1:
					sb.append('A');
					break;
				case 2:
					sb.append('B');
					break;
				case 3:
					sb.append('C');
					break;
				case 4:
					sb.append('D');
					break;
			}
			sb.append('\n');
		}
		br.close();
		System.out.print(sb.toString());
	}
}
