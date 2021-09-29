/* ���� 20040��
 * Ǯ�� ���: find �Լ��� union �Լ��� ������
 * ������� ��: union&find ������ ���� �� Ǯ����� �� ������ ���� �� ó���� � �˰����� �̿��Ͽ� Ǯ������� �� �������� �ʾҴ�.
 */
package Study_21_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20040_CycleGame {
	
	static int parent[];

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n];
		for(int i=0; i<n; i++)
			parent[i] = i;
		int cyclemade = 0;
		for(int i=0; i<m; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			if(union(a, b) && cyclemade==0) {
				cyclemade = i+1;
			}
		}
		System.out.print(cyclemade);
		br.close();
	}
	
	static int find(int n) {
		if(parent[n] == n)
			return n;
		else {
			parent[n] = find(parent[n]);
			return parent[n];
		}
	}
	
	static boolean union(int a, int b) {
		if(find(a) == find(b)) //����Ŭ ������ ����
			return true;
		else {
			parent[b] = find(a);
			return false;
		}
	}
}
