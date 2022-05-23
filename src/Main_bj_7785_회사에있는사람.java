import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_bj_7785_회사에있는사람 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_7785.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashSet<String> set = new HashSet<>();
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String name = st.nextToken();
			String separate = st.nextToken(); //출근인지 퇴근인지
			
			if(separate.equals("enter")) set.add(name);
			else set.remove(name);
		}
		
		ArrayList<String> list = new ArrayList<String>(set);//정렬을 위해 list로 변환
		Collections.sort(list, Collections.reverseOrder());//역정렬
		
		for(int i=0;i<list.size();i++) {
			sb.append(list.get(i)).append('\n');
		}
		
		System.out.print(sb.toString());
		
	}
}
