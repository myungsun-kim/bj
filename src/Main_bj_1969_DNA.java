import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// DNA는 DNA를 이루는 뉴클레외드의 첫글자를 따서 표현
// Hamming Distance = 길이가 같은 두 DNA가 있을 때 각 위치의 뉴클리오드 문자가 다른 것의 개수
// Hamming Distance의 합이 가장 작은 DNA 구하기
public class Main_bj_1969_DNA {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1969.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int hammingDis = 0;
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String[] dna = new String[n];
		for(int i=0;i<n;i++) dna[i] = br.readLine();
		
		for(int i=0;i<m;i++) {
			int[] check = new int[26];
			int idx = 0;
			int max = 0;
			for(int j=0;j<n;j++) {
				int curIdx = dna[j].charAt(i)-'A';
				if(max<++check[curIdx]) {
					idx = curIdx;
					max = check[idx];
				}
				if(max==check[curIdx] && idx>curIdx) idx = curIdx; //사전순 빠른값
			}
			sb.append((char)(idx+65));
			hammingDis += n-max;
		}
		sb.append('\n').append(hammingDis);
		System.out.print(sb.toString());
	}
}
