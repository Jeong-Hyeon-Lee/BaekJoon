/*���� 21316��
 * Ǯ�� ���: ������ �迭�� �̿��� ��� ���·� ����� ������ �����Ѵ�. ����ī�� �� ���� ���� ����Ǿ� �ְ�, �� �� ���� ���� ���� �� ��, �� ��, �� ���� ���� ����Ǿ� �����Ƿ� for���� �̿��� �׷� ���� ã�´�.
 * ������� ��: Ǯ�� ������ �¾����� int k=0�� ���� for�� ���ʿ� �־ ���� Ŀ���� �ϴµ� �ڲ� �ʱ�ȭ�ǰ� ����� �Ǽ��� �ߴ�. �����δ� �̷� �Ǽ��� ���� �ʵ��� �ؾ߰ڴ�
 */
package ICPC_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21316_Spica {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [][] star = new int[13][13];
		for(int i=0; i<12; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			star[x][y] = 1;
			star[y][x] = 1;
		}
		int [] linkcount = new int[13];
		for(int i=1; i<13; i++)
			for(int j=1; j<13; j++)
				if(star[i][j] == 1)
					linkcount[i]++;
		int [][] spicalink = new int[13][3];
		for(int i=1; i<13; i++) {
			if(linkcount[i] == 3) {
				int k=0; //�̰� �ؿ� �־ �ڲ� �ʱ�ȭ�ƴ�. �̷� �Ǽ� ���� ���� ����..
				for(int j=1; j<13; j++) {
					if(star[i][j] == 1) {
						spicalink[i][k] = j;
						k++;
					}
				}
				if(linkcount[spicalink[i][0]]+linkcount[spicalink[i][1]]+linkcount[spicalink[i][2]] == 6)
					System.out.print(i);
			}
		}
		br.close();
	}

}
