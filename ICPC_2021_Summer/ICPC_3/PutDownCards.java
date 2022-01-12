/*백준 18115번
 * 특정한 실행 이후 결과를 보고 실행 전 상태를 찾는 건데, 실행 순서를 역순으로 하고 실행도 반대로 생각해서
 * 원래 상태를 반대로 찾아나간다.
 * 처음에는 BufferedWriter 대신 System.out.print를 사용했더니 시간초과 문제 발생했음
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
			wayreverse[i] = Integer.parseInt(st.nextToken()); //카드 기술 역순으로 저장
		
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
