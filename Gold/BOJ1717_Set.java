package study_21_11;

/*백준 1717번
 * 풀이 방법: union&find를 이용해 집합을 서로 묶고 같은 집합인지 확인한다.
 * 어려웠던 점: 없었다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1717_Set {
	
	static int [] parent;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		for(int i=1; i<=n; i++)
			parent[i] = i;
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(k == 0) {
				union(a, b);
			}
			else if(k == 1) {
				if(isSameParent(a, b))
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
		br.close();
	}
	static int find(int x) {
		if(x == parent[x])
			return x;
		return parent[x] = find(parent[x]);
	}
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) {
			if(x < y)
				parent[y] = x;
			else
				parent[x] = y;
		}
	}
	static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);	
		if(x == y)
			return true;
		return false;
	}

}
