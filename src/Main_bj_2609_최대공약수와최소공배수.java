import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_2609_최대공약수와최소공배수 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2609.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int n1=Integer.parseInt(st.nextToken());
		int n2=Integer.parseInt(st.nextToken());
		for(int i=Math.min(n1, n2);i>0;i--) {
			if(n1%i==0 && n2%i==0) {
				sb.append(i).append("\n");//최소 공약수
				break;
			}
		}
		int num=Math.max(n1, n2);
		while(true) {//최대 공배수
			if(num%n1==0 && num%n2==0) {
				sb.append(num);
				break;
			}
			num++;
		}
		br.close();
		System.out.print(sb.toString());
	}
}
