/*���� 15904��
 * Ǯ�� ���:������ �Է¹ް� ���� �迭 �ȿ� U, C, P, C�� �����ص� ����
 * ���ϴ� ���ڸ� ã�� ������ ���� ������ �ϳ��� �������� ���� ���ڰ� �ִ��� Ȯ���Ѵ�.
 * ���� ������ 4�̸� �� �̻� Ȯ������ �ʰ�, �� ��� U, C, P, C�� �� �ִٴ� ���̹Ƿ� I love UCPC�� ����ϰ�
 * ���� ������ 4�� �ƴϸ� I hate UCPC�� ����Ѵ�. 
 * ������� ��: U, C, P, C�� ��� ������� ������ �ִ��� Ȯ������ ����� ���� �ߴ�.
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
