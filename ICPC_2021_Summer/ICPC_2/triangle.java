/*���� 1448��
������� ��: ���� ó������ ����for ���� �̿��ߴٰ� �޸� �ʰ��� ����, �ʿ��� �κи� ������ �����ϴ� ������ Ǯ�̸� �ٲپ����� Scanner ������� �� �޸� �ʰ��� ����.
Ǯ�� ���: ������ ���̸� �����ؼ� ������ ���� ū ������� �ﰢ���� ���� �� �ִٸ� break�Ѵ�. Scanner�� BufferedReader�� �ٲپ����� Ǯ�̰� �¾Ҵ�.*/
package ICPC_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class triangle {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //������ ����
		int [] straw = new int[N];
		for(int i=0; i<N; i++)
			straw[i] = Integer.parseInt(br.readLine()); //������ ���� ����
		br.close();
		Arrays.sort(straw); //���� ���� �� ����
		
		int sum = -1; //���� ������ �� (�ﰢ�� ������ -1 �״��)
		
		for(int i=N-1; i>=2; i--) {
			if(straw[i-2]+straw[i-1] > straw[i]) { //�ﰢ���� ���� �� �ִٸ�
				sum = straw[i-2]+straw[i-1]+straw[i];
				break;
			}
		}
		System.out.print(sum);
			
	}

}
