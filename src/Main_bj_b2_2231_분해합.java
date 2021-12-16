import java.io.*;
import java.util.*;

public class Main_bj_b2_2231_분해합 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2231.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m=0;
		int m_tmp, tmp;
		
		for(int i=1;i<=n;i++) {
			m_tmp = 0;
			tmp = i;
			m_tmp+=tmp;
			while(tmp>0) {
				m_tmp+=tmp%10;
				tmp/=10;
			}
			if(m_tmp==n) {
				m=i;
				break;
			}
		}
		br.close();
		System.out.print(m);
	}
}
