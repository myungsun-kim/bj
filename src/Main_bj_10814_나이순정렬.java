import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Person{
	int age;
	String name;
	
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
}

public class Main_bj_10814_나이순정렬 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_10814.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		ArrayList<Person> list = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			list.add(new Person(Integer.parseInt(st.nextToken()),st.nextToken()));
		}
		Collections.sort(list, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.age, o2.age);
			}
		});
		
		for(int i=0;i<n;i++) {
			sb.append(list.get(i).age).append(" ").append(list.get(i).name).append("\n");
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb.toString());
	}
}
