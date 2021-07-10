import java.io.*;
import java.util.*;

public class Main_bj_s4_1764_듣보잡 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1764.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N=Integer.parseInt(st.nextToken());//듣도 못한 사람의 수
		int M=Integer.parseInt(st.nextToken());//보도 못한 사람의 수
		Map<String, String> map = new HashMap<>();
		for(int i=0;i<N;i++) {
			String input=br.readLine();//듣도 못한 사람
			map.put(input, input);
		}
		ArrayList<String> list = new ArrayList<>();
		for(int i=0;i<M;i++) {
			String in=br.readLine();//보도 못한 사람
			if(map.get(in)!=null) {//듣도 보도 못한 사람일 경우
				list.add(map.get(in));//리스트에 입력
			}
		}
		Collections.sort(list);
		sb.append(list.size()).append('\n');
		for(int i=0;i<list.size();i++) {
			sb.append(list.get(i)).append('\n');
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb.toString());
	}
}
