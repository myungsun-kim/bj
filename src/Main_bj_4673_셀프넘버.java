// 양의 정수 n에 대해서 d(n)을 n과 n의 각 자리수를 더하는 함수라고 정의하자. 예를 들어, d(75) = 75+7+5 = 87
// 양의 정수 n이 주어졌을 때, 이 수를 시작해서 n, d(n), d(d(n)), d(d(d(n))), ...과 같은 무한 수열을 만들 수 있다.
// n을 d(n)의 생성자라고 하고 생성자가 없는 숫자를 셀프 넘버라고 함
// 10000 보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 출력
public class Main_bj_4673_셀프넘버 {
	static boolean[] isNotSelfNumber;
	static final int range = 10000;
	
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		isNotSelfNumber = new boolean[range+1];
		for(int i=1;i<=range;i++) {
			d(i); //현재의 수로 d(n)의 값 구하기
			if(!isNotSelfNumber[i]) { //현재 수가 셀프 넘버라면
				sb.append(i).append('\n');
			}
		}
		System.out.print(sb.toString());
	}
	
	static void d(int number) {
		if(number>range) return; // 범위를 넘었다면
		
		int constructure = number;
		
		while(number>0) { // 연산
			constructure+=number%10;
			number/=10;
		}
		
		if(constructure>range) return; // 구한 생성자가 범위를 넘었을 경우
		
		if(isNotSelfNumber[constructure]) return; // 셀프 넘버가 아니라면
		
		isNotSelfNumber[constructure] = true; // 현재 구한 생성자 = 셀프넘버
		
		d(constructure);
	}
}
