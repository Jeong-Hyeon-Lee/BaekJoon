/*
 ���� 2841��
 Ǯ�� ���: ��Ÿ�� �� �ٿ� ���� ������ ���� ���� �迭�� ����� ������ ������ ���ÿ� �߰��Ѵ�.
 ������� ��: �� ��Ȳ�� ���� ������ ������ ���� ���� �򰥷ȴ�.
 + ���� ���ظ� ó���� �߸��߾��µ� �� �ȵǸ� �ٽ� ���� �� �����ߴ��� �����غ���!
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2841_AlienGuitar {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		Stack<Integer> [] s = new Stack[N+1];
		for(int i=0; i<N; i++)
			s[i] = new Stack<>();
		int move = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			if(s[n].isEmpty()) { //n��° �ٿ� ������ �ִ� ������ ������
				s[n].add(p);
				move++;
			}
			else { //n��° �ٿ� ������ �ִ� ������ ���� ��
				if(p > s[n].peek()) {
					s[n].add(p);
					move++;
				}
				else if(p < s[n].peek()) {
					if(s[n].contains(p)) {
						while(s[n].peek() != p) {
							s[n].pop();
							move++;
						}
					}
					else {
						while(!s[n].isEmpty() && s[n].peek() > p) {
							s[n].pop();
							move++;
						}
						s[n].add(p);
						move ++;
					}
				}
				else
					continue;
					
			}
		}
		
		System.out.print(move);
	}

}
