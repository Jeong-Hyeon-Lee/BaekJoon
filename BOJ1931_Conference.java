package study_21_11;

/*���� 1931��
 * Ǯ�� ���: ȸ�Ǹ� ��Ÿ���� class�� ������ ������ �����ϰ� �����Ѵ�.
 * ����ð��� ���� ��(���ٸ� ���� �ð��� ���� ��)���� �����ؼ� ��ġ�� �ʰ� �� �� �ִ� ȸ�Ǹ� ã�� ������ ����Ѵ�.
 * ������� ��: ���� ������.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Conference implements Comparable<Conference>{
	int start, end;
	public Conference(int start, int end) {
		// TODO Auto-generated constructor stub
		this.start = start;
		this.end = end;
	}
	@Override
	public int compareTo(Conference o) {
		// TODO Auto-generated method stub
		if(this.end == o.end)
			return this.start - o.start;
		return this.end - o.end;
	}
}

public class BOJ1931_Conference {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Conference [] c = new Conference[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			c[i] = new Conference(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(c);
		
		int cnt = 0;
		int prev = 0; //���� ȸ�� ���� �ð�
		for(int i=0; i<N; i++) {
			Conference cur = c[i]; //���� ȸ��
			if(prev <= cur.start) {
				cnt ++;
				prev = cur.end;
			}
		}
		System.out.println(cnt);
		br.close();
		
	}

}
