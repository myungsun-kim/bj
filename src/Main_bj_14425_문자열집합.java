import java.io.*;
import java.util.*;
// 총 n개의 문자열로 이루어진 집합 S가 주어진다
// 입력으로 주어지는 m개의 문자열 중에서 집합 s에 포함되어 있는 것이 총 몇 개인지 구하여라
public class Main_bj_14425_문자열집합 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_14425.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int count = 0;
		
		String[] input = new String[m]; //입력으로 주어지는 m개의 문자열
		
		HashSet<String> s = new HashSet<>();
		
		for(int i=0;i<n;i++) {
			s.add(br.readLine());
		}
		
		for(int i=0;i<m;i++) {
			input[i] = br.readLine();
		}
		
		for(int i=0;i<m;i++) {
			if(s.contains(input[i])) count++;
		}
		
		br.close();
		System.out.print(count);
		
	}
}
