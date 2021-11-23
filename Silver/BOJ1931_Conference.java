package study_21_11;

/*백준 1931번
 * 풀이 방법: 회의를 나타내는 class를 정의해 정보를 저장하고 정렬한다.
 * 종료시간이 빠른 순(같다면 시작 시간이 빠른 순)으로 정렬해서 겹치지 않고 할 수 있는 회의를 찾아 개수를 출력한다.
 * 어려웠던 점: 딱히 없었다.
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
		int prev = 0; //이전 회의 종료 시간
		for(int i=0; i<N; i++) {
			Conference cur = c[i]; //현재 회의
			if(prev <= cur.start) {
				cnt ++;
				prev = cur.end;
			}
		}
		System.out.println(cnt);
		br.close();
		
	}

}
