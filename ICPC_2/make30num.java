/*���� 10610��
 * String���� ���� �Է¹޾Ƽ� �迭�� �����Ҷ� char ���·� �����ϰ�,
 * int�� ���� �ʿ��� ���� �ƽ�Ű �ڵ� ���� ������ 48��ŭ�� ���൵ �ȴ�.
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
		String N = br.readLine(); //���� ����
		
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
