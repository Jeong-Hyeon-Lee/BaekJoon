/* 백준 20040번
 * 풀이 방법: 부모 노드를 구하는 find 함수와 두 점을 묶어주는 union 함수를 정의해 이용했다. 사이클이 형성되면 union이 true를 반환하도록 해
 * true가 처음으로 나오면 그때 답을 변수에 저장하고 마지막에 출력한다.
 * 어려웠던 점: union&find 문제는 많이 안 풀어봐서 이 문제를 봤을 때 처음에 어떤 알고리즘을 이용하여 풀어야할지 잘 떠오르지 않았다.
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
			if(union(a, b) && cyclemade==0) { //가장 처음 사이클이 형성된 경우
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
		if(find(a) == find(b)) //사이클 형성된 상태
			return true;
		else {
			parent[find(b)] = find(a);
			return false;
		}
	}
}
