import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_bj_1764_듣보잡 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1764.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());//듣도 못한 사람의 수
		int m=Integer.parseInt(st.nextToken());//보도 못한 사람의 수
		HashSet<String> hash = new HashSet<>();//듣도 못한 사람
		ArrayList<String> list = new ArrayList<>(); //듣도 보도 못한 사람
		for(int i=0;i<n;i++) hash.add(br.readLine()); //듣도 못한 사람
		for(int i=0;i<m;i++) {
			String tmp=br.readLine();//보도 못한 사람
			if(hash.contains(tmp)) {//듣도 보도 못한 사람일 경우
				list.add(tmp);//리스트에 입력
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
