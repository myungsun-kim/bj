import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 전공 평점 계산
// 학점이 P인 경우엔 계산에서 제외
public class Main_bj_25206_너의평점은 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_25206.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int size = 20;
		double answer = 0.0;
		double sumCredit = 0.0;
		double sumGrade = 0.0;

		for(int i=0;i<size;++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			st.nextToken();
			double credit = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();
			if(!"P".equals(grade)) {
				sumCredit += credit;
				if("A+".equals(grade)) {
					sumGrade += 4.5*credit;
				}else if("A0".equals(grade)) {
					sumGrade += 4.0*credit;
				}else if("B+".equals(grade)) {
					sumGrade += 3.5*credit;
				}else if("B0".equals(grade)) {
					sumGrade += 3.0*credit;
				}else if("C+".equals(grade)) {
					sumGrade += 2.5*credit;
				}else if("C0".equals(grade)) {
					sumGrade += 2.0*credit;
				}else if("D+".equals(grade)) {
					sumGrade += 1.5*credit;
				}else if("D0".equals(grade)) {
					sumGrade += 1.0*credit;
				}
			}
		}
		answer = sumGrade/sumCredit;
		br.close();
		System.out.print(answer);
		
	}
}
