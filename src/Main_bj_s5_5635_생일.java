import java.io.*;
import java.util.*;
// 가장 나이가 적은 사람과 가장 많은 사람을 구하는 프로그램 작성
public class Main_bj_s5_5635_생일 {
	static class Person implements Comparable<Person>{
		String name;
		int day;
		int month;
		int year;
		
		public Person(String name, int day, int month, int year) {
			super();
			this.name = name;
			this.day = day;
			this.month = month;
			this.year = year;
		}
		
		@Override
		public int compareTo(Person o) {
			int dif1 = Integer.compare(this.year, o.year);
			if(dif1==0) {
				int dif2 = Integer.compare(this.month, o.month);
				if(dif2==0) return Integer.compare(this.day, o.day);
				return dif2;
			}
			return dif1;
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_5635.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Person[] arr = new Person[n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String name = st.nextToken();
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			arr[i] = new Person(name,day,month,year);
		}
		br.close();
		Arrays.sort(arr);
		System.out.println(arr[n-1].name);
		System.out.print(arr[0].name);
	}
}
