import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// s는 r1과 r2의 평균
// r1과 s가 주어졌을때 r2의 값 구하기
public class Main_bj_3046_R2 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_3046.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int r1 = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int r2 = s*2-r1;
		br.close();
		System.out.print(r2);
	}
}
