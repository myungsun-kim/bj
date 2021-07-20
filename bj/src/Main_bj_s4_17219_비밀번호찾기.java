import java.io.*;
import java.util.*;

public class Main_bj_s4_17219_비밀번호찾기 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_17219.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<String, String> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N=Integer.parseInt(st.nextToken());//저장된 사이트 주소의 수
		int M=Integer.parseInt(st.nextToken());//비밀번호를 찾으려는 사이트 주소의 수
		
		for(int i=0;i<N;i++) {//주소와 비밀번호 입력 받기
			st = new StringTokenizer(br.readLine()," ");
			map.put(st.nextToken(), st.nextToken());
		}
		for(int i=0;i<M;i++) {//해당 주소의 비밀번호 찾기
			sb.append(map.get(br.readLine())).append('\n');
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb.toString());
	}
}
