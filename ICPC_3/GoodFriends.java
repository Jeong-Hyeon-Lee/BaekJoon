//���� 3078��
/* ������� ��:
 * ť �迭�� ���ڼ����� ���� �����߰ڴٴ� ������ �ϱ� �������. �ؼ��� ã�ƺ��� ���� ������ �� �־���.
 * ��, pair�� �ڷ����� int�� �ƴ϶� long���� �޾ƾ� �ϴµ�, �ڷ����� ������ �� �Ű��߰ڴ�.
 * Ǯ�̹��:
 * �̸��� ���ڼ��� 2~20�����̹Ƿ� ũ�Ⱑ 21�� ť �迭�� ����� �迭�� �ε����� Ȱ���� �̸��� ���̰� ���� �л��� ���� ť�� �����Ѵ�.
 * ��� ���̰� K�̻� ���� ģ���� while���� �̿��� ť���� �����ϰ�,
 * ť�� �� �л��� �߰��ϱ� ���� �ش� ť�� �ִ� �л��� ���� ���ϸ�
 * �� �л��� ���� �̷�� ����ŭ ���� �� ������ �ߺ� ���� ���� ģ���� ������� ���� �� �ִ�.
 */
package ICPC_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class GoodFriends {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long pair = 0;

		Queue<Integer> [] q = new Queue[21];
		for(int i=2; i<=20; i++)
			q[i] = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			int name = br.readLine().length();
			while(!q[name].isEmpty() && i - q[name].peek() > K) //�տ� ������ q[name].peek()�� null�̸� ���������
				q[name].poll(); // ��� ���̰� K ������ ť���� ����
			
			pair += q[name].size(); //�̹� �ݺ��� ���� �л��� ���� �̷�� �л�(�� ���� ���� �л� ��) ����ŭ ���ϱ�
			q[name].offer(i); //�̹� �ݺ��� ���� �л� ť�� �߰�
		}
		
		/*�� ������� �ߴ��� ���� for�� �������� �ð��ʰ��� ���´�.
		int [] name = new int[N];
		for(int i=0; i<N; i++)
			name[i] = br.readLine().length();
			
		for(int j=1; j<=K; j++) {
			for(int i=0; i<N-j; i++) {
				if(name[i] == name[i+j])
					pair++;
			}
		}
		*/
		System.out.print(pair);
		br.close();
	}

}
