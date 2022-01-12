/*���� 18115��
 * Ư���� ���� ���� ����� ���� ���� �� ���¸� ã�� �ǵ�, ���� ������ �������� �ϰ� ���൵ �ݴ�� �����ؼ�
 * ���� ���¸� �ݴ�� ã�Ƴ�����.
 * ó������ BufferedWriter ��� System.out.print�� ����ߴ��� �ð��ʰ� ���� �߻�����
 */
package ICPC_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class PutDownCards {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [] wayreverse = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=N-1; i>=0; i--)
			wayreverse[i] = Integer.parseInt(st.nextToken()); //ī�� ��� �������� ����
		
		Deque<Integer> cards = new ArrayDeque<>();
		for(int i=0; i<N; i++) {
			int way = wayreverse[i];
			switch(way) {
			case 1:
				cards.addFirst(i+1);
				break;
			case 2:
				int temp = cards.pollFirst();
				cards.addFirst(i+1);
				cards.addFirst(temp);
				break;
			case 3:
				cards.addLast(i+1);
				break;
			default:
				break;
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int A = cards.size();
		for(int i=0; i<A; i++)
			bw.write(cards.pollFirst() + " ");
		br.close();
		bw.close();
	}

}
