import java.io.*;
import java.util.*;

public class Main_bj_s4_10825_국영수 {
	// n명의 학생들의 이름과 국어,영어,수학 점수가 주어짐
	// 국어 점수가 감소하는 순서로(내림차순)
	// 국어 점수 같을시 영어 점수가 증가하는 순서로(오름차순)
	// 국어,영어 점수 같을시 수학 점수가 감소하는 순서로(내림차순)
	// 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서
	// (대문자는 소문자보다 작으므로 사전순으로 앞에 옴)
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_10825.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Student> queue = new PriorityQueue<>();
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			queue.offer(new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		for(int i=0;i<n;i++) {
			sb.append(queue.poll().name).append('\n');
		}
		sb.setLength(sb.length()-1);
		br.close();
		System.out.print(sb.toString());
	}
}

class Student implements Comparable<Student>{
	String name;
	int kor;
	int eng;
	int math;
	
	public Student(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	@Override
	public int compareTo(Student o) {
		int compare1 = Integer.compare(o.kor, this.kor); //국어 점수 비교
		int compare2 = Integer.compare(this.eng, o.eng); //영어 점수 비교
		int compare3 = Integer.compare(o.math, this.math); //수학 점수 비교
		int compare4 = this.name.compareTo(o.name); //이름 비교
		
		if(compare1!=0) return compare1;
		if(compare2!=0) return compare2;
		if(compare3!=0) return compare3;
		
		return compare4;
	}
	
	
}