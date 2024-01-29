import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_bj_9519_졸려 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_9519.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> hash = new HashMap<>(); //주기찾기
		int x = Integer.parseInt(br.readLine()); //깜빡인 눈의 횟수
		char[] word = br.readLine().toCharArray();
		int length = word.length;
		int k = length/2; //깜빡일때 뒤에서 k번째 단어가 앞에서 k번째 단어와 k+1번째 단어 사이로 이동
		int count = 1;
		
		String answer = "";

		for(int i=0;i<x;++i) {
			for(int j=0;j<k;++j) {
				int before = j+1; 
				int after = length-before;
				char beforeWord = word[before];
				
				for(int l=before;l<after;++l) {
					word[l] = word[l+1];
				}
				word[after] = beforeWord;
			}
			String tmp = String.valueOf(word);
			if(hash.containsKey(tmp)) break;
			hash.put(tmp, count++);
		}
		int size = hash.size();
		int index = x%size==0?size:x%size;
		
		for(String key : hash.keySet()) {
			int cur = hash.get(key);
			if(index == cur) answer = key;
			
		}
		
		br.close();
		System.out.print(answer);

	}
}
