//���� 2993��
/*Ǯ�̹��: �ܾ scanner�� �̿��� string���� �Է¹��� �� char �迭�� ���ڸ� �ϳ��� ������ �迭�� ������ �ٲپ� ���ڸ� ������ �� �ְ� �ߴ�.
 ���ڸ� ������ �κ��� reverse �Լ��� ���� �����ؼ� �ݺ��Ǵ� �κ��� �����ϰ� �������,
 ���� �� �ִ� ���ڸ� ���� ArrayList�� ������ �� �� ���������� ���� �ռ��� �ܾ ����ߴ�.
 */
package ICPC_1;
import java.util.ArrayList;
import java.util.Scanner;

public class ThreeParts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String word = sc.next(); //���ĺ� �ҹ���, ���̴� 3�̻� 50����
		int N = word.length();
		char[] arrWord = new char[N];
		sc.close();
		
		ArrayList<String> newword = new ArrayList<>();
		
		int a, b;
		for(a=0; a<N-2; a++) {
			for(b=a+1; b<N-1; b++) {
				
				for(int i=0; i<N; i++)
					arrWord[i] = word.charAt(i);
				//�� �κ��� (a, b �ݺ��ϴ�)for�� �ٱ��� �ּ� �ݺ� ��ȸ �� ������ arrWord�� ������ �ʱ�ȭ�� �� �� ���·� �ٽ� reverse �Ǿ ��� Ʋ�ȴ�!
				//�������ʹ� �����ϱ�
				reverse(0,a, arrWord);
				reverse(a+1, b, arrWord);
				reverse(b+1, N-1, arrWord);
				
				
				String nw = new String(arrWord);
				newword.add(nw);
			}
		}
		
		String minword = newword.get(0);
		for(int i=1; i<newword.size(); i++) {
			if(newword.get(i).compareTo(minword) < 0)
				minword = newword.get(i);
		}

		System.out.println(minword);
	}
	
	static void reverse(int a, int b, char[] arr) {
		for(int i=0; i<(b-a+1)/2; i++) {
			char temp = arr[a+i];
			arr[a+i] = arr[b-i];
			arr[b-i] = temp;
		}
	}
}