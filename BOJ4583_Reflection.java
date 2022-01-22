/*���� 4583��
 * Ǯ�� ���: if-else���� �̿��� ���ڰ� �ݻ�� ����� ǥ�� �����ϸ�
 * ������� reflection�̶�� ���� �迭�� �����ϰ�, reflection�� ������ �Ųٷ� ����Ѵ�.
 * ǥ���� �Ұ����� ��� possible�̶�� ������ 0���� ������ְ� possible�� 0�̸� INVALID�� ����Ѵ�.
 * ������� ��: ������.
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