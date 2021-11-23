package study_21_11;

/*���� 19539��
 * Ǯ�� ���: 1��ŭ �����Ű�� ���Ѹ����� 2��ŭ �����Ű�� ���Ѹ����� ���ÿ� ����ϹǷ� ������ ������ ���� 3�� ����̴�.
 * ��, ������ ���̰� Ȧ���̸� �ݵ�� 1��ŭ �����Ű�� ���Ѹ����� ����� ���̹Ƿ� 1��ŭ �����Ű�� ���Ѹ����� �ּ� ������ ���̰� Ȧ���� ������ �����̴�.
 * ������ ����� ���� ����Ѵ�.
 * ������� ��: ���� ������.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ19539_AppleTree {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] h = new int[N]; //������ ����
		int sum = 0;
		int odd = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			h[i] = Integer.parseInt(st.nextToken());
			sum += h[i];
			if(h[i]%2 == 1)
				odd++;
		}
		if(sum%3==0 && sum/3 >= odd )
			System.out.println("YES");
		else
			System.out.println("NO");
		br.close();
		
	}

}
