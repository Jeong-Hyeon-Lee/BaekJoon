/*백준 4583번
 * 풀이 방법: if-else문을 이용해 문자가 반사된 모습이 표현 가능하면
 * 순서대로 reflection이라는 문자 배열에 저장하고, reflection의 순서를 거꾸로 출력한다.
 * 표현이 불가능한 경우 possible이라는 변수를 0으로 만들어주고 possible이 0이면 INVALID를 출력한다.
 * 어려웠던 점: 없었다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4583_Reflection {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String word = br.readLine();
			if(word.equals("#"))
				break;
			
			char [] reflection = new char[10];
			int possible = 1;
			for(int i=0; i<word.length(); i++) {
				if(word.charAt(i) == 'b')
					reflection[i] = 'd';
				else if(word.charAt(i) == 'd')
					reflection[i] = 'b';
				else if(word.charAt(i) == 'p')
					reflection[i] = 'q';
				else if(word.charAt(i) == 'q')
					reflection[i] = 'p';
				else if(word.charAt(i) == 'i' || word.charAt(i) =='o'
						|| word.charAt(i) == 'v' || word.charAt(i) == 'w'
						|| word.charAt(i) == 'x')
					reflection[i] = word.charAt(i);
				else {
					possible = 0;
					break;
				}
			}
			
			if(possible == 1) {
				for(int i=word.length()-1; i>=0; i--) {
					System.out.print(reflection[i]);
				}
				System.out.println();
			}
			else
				System.out.println("INVALID");
		}
	}

}