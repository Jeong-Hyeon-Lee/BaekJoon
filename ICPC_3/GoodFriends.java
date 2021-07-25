//백준 3078번
/* 어려웠던 점:
 * 큐 배열을 글자수별로 따로 만들어야겠다는 생각을 하기 어려웠다. 해설을 찾아보고 나서 납득할 수 있었다.
 * 또, pair의 자료형을 int가 아니라 long으로 받아야 하는데, 자료형의 범위를 잘 신경써야겠다.
 * 풀이방법:
 * 이름의 글자수가 2~20글자이므로 크기가 21인 큐 배열을 만들고 배열의 인덱스를 활용해 이름의 길이가 같은 학생을 같은 큐에 저장한다.
 * 등수 차이가 K이상 나는 친구는 while문을 이용해 큐에서 삭제하고,
 * 큐에 새 학생을 추가하기 전에 해당 큐에 있는 학생의 수를 더하면
 * 새 학생과 쌍을 이루는 수만큼 더할 수 있으니 중복 없이 좋은 친구가 몇쌍인지 구할 수 있다.
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
			while(!q[name].isEmpty() && i - q[name].peek() > K) //앞에 조건은 q[name].peek()이 null이면 오류날까봐
				q[name].poll(); // 등수 차이가 K 넘으면 큐에서 삭제
			
			pair += q[name].size(); //이번 반복에 받은 학생과 쌍을 이루는 학생(그 전에 받은 학생 중) 수만큼 더하기
			q[name].offer(i); //이번 반복에 받은 학생 큐에 추가
		}
		
		/*이 방법으로 했더니 이중 for문 때문인지 시간초과가 나온다.
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
