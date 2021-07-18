import java.io.*;
import java.util.*;

public class Main_bj_s5_1181_단어정렬 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1181.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashSet<String> set = new HashSet<String>();
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			set.add(br.readLine());
		}
		
		ArrayList<String> list = new ArrayList<>(set);
		
		Collections.sort(list,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int dif = Integer.compare(o1.length(), o2.length());
				if(dif==0) return o1.compareTo(o2);
				return dif;
			}
		});
		
		for(int i=0;i<list.size();i++) {
			sb.append(list.get(i)).append("\n");
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}
