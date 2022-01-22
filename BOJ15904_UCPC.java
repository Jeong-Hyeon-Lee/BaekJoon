/*백준 15904번
 * 풀이 방법:문장을 입력받고 문자 배열 안에 U, C, P, C를 저장해둔 다음
 * 원하는 문자를 찾을 때마다 숫자 변수를 하나씩 증가시켜 다음 문자가 있는지 확인한다.
 * 숫자 변수가 4이면 더 이상 확인하지 않고, 그 경우 U, C, P, C가 다 있다는 것이므로 I love UCPC를 출력하고
 * 숫자 변수가 4가 아니면 I hate UCPC를 출력한다. 
 * 어려웠던 점: U, C, P, C를 어떻게 순서대로 가지고 있는지 확인할지 고민을 조금 했다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15904_UCPC {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		char [] UCPC = {'U', 'C', 'P', 'C'};
		int ucpc = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == UCPC[ucpc])
				ucpc++;
			if(ucpc == 4)
				break;
		}
		
		if(ucpc == 4)
			System.out.println("I love UCPC");
		else
			System.out.println("I hate UCPC");
	}

}
