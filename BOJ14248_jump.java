/*백준 14248번
 * 풀이 방법: BFS를 이용해 방문 가능한 돌의 boolean visited를 true로 만들어주고 그 개수를 더해 답을 출력한다.
 * 어려웠던 점: BFS 사용은 어려운 점이 딱히 없었지만 LinkedList 배열을 사용하며 처음에 NullPointerException이 발생해 해결이 필요했다.
 */
package study_21_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14248_jump {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] A = new int[n+1];
		LinkedList<Integer>[] link = new LinkedList[n+1];
		boolean [] visited = new boolean[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<n+1; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			link[i] = new LinkedList<>();
			if(i+A[i]<n+1)
				link[i].add(i+A[i]);
			if(i-A[i]>0)
				link[i].add(i-A[i]);
		}
		int s = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		visited[s] = true;
		q.add(s);
		
		while(!q.isEmpty()) {
			s = q.poll();
			Iterator<Integer> it = link[s].listIterator();
			while(it.hasNext()) {
				int w = it.next();
				if(!visited[w]) {
					visited[w] = true;
					q.add(w);
				}
			}
		}
		
		int ans=0;
		for(int i=0; i<visited.length; i++)
			if(visited[i] == true)
				ans++;
		System.out.print(ans);
	}


}