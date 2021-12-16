import java.io.*;
import java.util.*;
// 카드는 빨R 파B 노Y 녹G 으로 1-9까지 있음
// 아래와 같은 규칙이 있음
// 1. 카드 5장이 모두 같은 색이면서 숫자가 연속적> 점수는 가장 높은 숫자 + 900
// 2. 카드 5장 중 4장의 숫자가 같음 > 점수는 같은 숫자 + 800
// 3. 카드 5장 중 3장의 숫자가 같고 나머지 2장도 숫자가 같음 > 점수는 3장이 같은 숫자x10 + 2장이 같은 숫자 + 700
// 4. 5장의 카드 색깔이 모두 같을 때 > 점수는 가장 높은 숫자+600
// 5. 5장의 숫자가 연속적일때 > 점수는 가장 높은 숫자 + 500
// 6. 카드 5장 중 3장의 숫자가 같을 때 > 점수는 같은 숫자 + 400
// 7. 카드 5장 중 2장의 숫자가 같고 또 다른 2장의 숫자가 같을 때 > 점수는 같은 숫자 중 큰 숫자x10 + 같은 숫자 중 작은 숫자 + 300
// 8. 카드 5장 중 2장의 숫자가 같을 때 > 점수는 같은 숫자 + 200
// 9. 위의 어떤 경우에도 해당하지 않을 때 > 점수는 가장 큰 숫자 + 100
// 카드 5장이 주어질 때 게임의 점수를 구하는 프로그램 작성
// 색깔은 모두 같은 경우 체크
// 숫자는 연속적인 경우, 4장의 숫자가 같은 경우, 3장/2장의 숫자가 같은 경우, 3장의 숫자가 같은 경우, 2/2장의 숫자가 같은 경우, 2장의 숫자가 같은 경우
public class Main_bj_s4_2621_카드게임 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_2621.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int cardCount = 5; //카드의 개수 
		
		char color = ' ';
		int[] number = new int[cardCount];
		int[] count = new int[10]; //어떤 숫자가 몇 번 나왔는지
		int answer = 0;
		int maxNumber = 0;
		
		boolean sameColor = true; //색이 모두 같은지
		
		for(int i=0;i<cardCount;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			char tmp = st.nextToken().charAt(0);
			if(i==0) color = tmp; //처음 색깔
			if(sameColor && color != tmp) sameColor = false; //색깔이 다르다면
			
			number[i] = Integer.parseInt(st.nextToken());
			count[number[i]]++;
			if(maxNumber<number[i]) maxNumber = number[i];
			
		}
		
		boolean continuous = false; //연속적인지 체크 
		int calNumber1=0, calNumber2=0, calNumber3=0; 
		//계산에 들어갈 수
		//3장의 숫자가 같은 경우 calNumber3에 먼저 저장
		//2/2장의 숫자가 같을 경우>1,2 / 2/3장의 숫자가 같을 경우>2,3 / 3장의 숫자가 같을 경우>3 / 2장의 숫자가 같을 경우>2 / 나머지는 1
		
		for(int i=0;i<count.length;i++) { //숫자 정보 체크
			if(count[i]==1 && i<=5) {//연속적인 수인지 체크
				boolean check = true;
				for(int j=i;j<i+5;j++) {
					if(count[j]!=1) {
						check = false;
						break;
					}
				}
				if(check) {
					continuous = true;
				}
				if(continuous) break;
			}
			if(count[i]>=4) {//4장의 숫자가 같은 경우
				calNumber1 = i;
			}
			if(count[i]==3) {//3장의 숫자가 같은 경우
				calNumber3 = i;
			}
			if(count[i]==2) {
				if(calNumber2==0) {
					calNumber2=i;
				}else {
					calNumber1=i;
				}
			}
		}
		
		if(sameColor && continuous) { //1번조건
			answer = 900+maxNumber;
		}else if(calNumber1!=0 && calNumber2==0 && calNumber3==0) { //2번조건
			answer = 800+calNumber1;
		}else if(calNumber2!=0 && calNumber3!=0) {//3번 조건
			answer = 700+calNumber3*10+calNumber2;
		}else if(sameColor) {//4번 조건
			answer = 600+maxNumber;
		}else if(continuous) {//5번 조건
			answer = 500+maxNumber;
		}else if(calNumber3!=0) {//6번 조건
			answer = 400+calNumber3;
		}else if(calNumber1!=0 && calNumber2!=0) {//7번 조건
			answer = 300+Math.max(calNumber1, calNumber2)*10+Math.min(calNumber1, calNumber2);
		}else if(calNumber2!=0) {//8번 조건
			answer = 200+calNumber2;
		}else {//그 외
			answer = 100+maxNumber;
		}
		
		br.close();
		System.out.print(answer);
	}
}
