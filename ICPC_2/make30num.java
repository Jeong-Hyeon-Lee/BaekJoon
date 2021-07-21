/*백준 10610번
 * String으로 숫자 입력받아서 배열에 저장할때 char 형태로 저장하고,
 * int형 값이 필요할 때는 아스키 코드 값의 차이인 48만큼을 뺴줘도 된다.
 */
package ICPC_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class make30num {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine(); //양의 정수
		
		Character [] n = new Character[N.length()];
		int sum=0;
		
		for(int i=0; i<N.length(); i++) {
			n[i] = N.charAt(i);
			sum += n[i]-48;
		}
		Arrays.sort(n, Collections.reverseOrder());
		
		if(sum%3==0 && n[n.length-1]=='0') 
			for(int i=0; i<n.length; i++)
				System.out.print(n[i]);
		else
			System.out.print(-1);
		br.close();

	}

}
