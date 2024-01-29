import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
// 창문에 홀수명의 사람이 오면 열려있고 짝수명의 사람이 오면 닫혀있음
// n의 약수번째 사람이 n 창문을 닫거나 염
// > 약수가 홀수개이면 창문이 열려있음. 약수가 홀수개일 경우는 제곱수
public class Main_bj_13909_창문닫기 {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_bj_13909.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		
		for(int i=1;i*i<=n;++i) {
			++count;
		}
		
		br.close();
		System.out.print(count);
	}
}
