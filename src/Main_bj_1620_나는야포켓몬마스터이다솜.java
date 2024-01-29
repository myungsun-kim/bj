import java.io.*;
import java.util.*;
// N:도감에 수록되어 있는 포켓몬의 개수
// M:내가 맞춰야 하는 문제의 개수
// 포켓몬의 이름은 모두 영어로 첫 글자만 대문자이고 나머지 문자는 소문자. 최대 길이는 20
// 문제가 알파벳으로만 들어오면 포켓몬 번호를, 숫자로만 들어오면 포켓몬 번호에 해당하는 문자 출력
public class Main_bj_1620_나는야포켓몬마스터이다솜 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1620.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		Map<String, String> poket = new HashMap<>();
		
		for(int i=1;i<=N;i++) {//포켓몬 값 저장
			String poketmon = br.readLine();
			String num = Integer.toString(i);
			poket.put(num, poketmon);
			poket.put(poketmon, num);
		}
		for(int i=0;i<M;i++) {
			sb.append(poket.get(br.readLine())).append('\n');
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb.toString());
	}
}
