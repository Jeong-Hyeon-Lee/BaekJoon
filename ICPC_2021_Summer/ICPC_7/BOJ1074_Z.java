/*���� 1074
 * Ǯ�̹��: 4���� �κ����� ������ r�� c���� ����ִ����� ���� ĭ ������ �����ְ� ��� ������ ���Ѵ�.
 * ������� ��: ������ �������� ���ؾ� �ϴµ� ���ϴ� ���� ó���� ó�� ��Ȳ���� ����Ǵ� ������ ��� Ʋ�ȴ�.
 * ��, x, y�� ��/���� ���߱� ���� ������� ���ε� ��ǥ���� �򰥷��� x, y�� �ٲ���. r�� c���̹Ƿ� ��� ���� �翬�ϴ�!
 */
package ICPC_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074_Z {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int count=0;
		int x=0; int y=0;
		
		while(N>0) {
			int n = (int)Math.pow(2, N);
			if(r>=(n/2)+x && c>=(n/2)+y) { //������ �Ʒ�
				count += (n*n)/2 + (n*n)/4;
				x+=n/2; y+=n/2;
			}
			else if(r>=(n/2)+x && c<(n/2)+y) { //���� �Ʒ�
				count += (n*n)/2;
				x+=n/2;
			}
			else if(r<(n/2)+x && c>=(n/2)+y) { //������ ��
				count += (n*n)/4;
				y+=n/2;
			}
			//���� ���� �� �ʿ� ����
			N--;
		}
		System.out.print(count);
		br.close();
	}

}
