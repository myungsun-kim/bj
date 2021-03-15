import java.io.*;
import java.util.*;

public class Main_bj_2751_수정렬하기2 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2751.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(arr);
		//배열 정렬보다 Collection 정렬이 더 빠름
		for(int i=0;i<n;i++) {
			sb.append(arr.get(i)).append("\n");
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}
