package study_21_11;

/*백준 4386번
 * 풀이 방법: 직접 연결된 선들을 비용의 오름차 순으로 정렬해 최소 비용으로 별들을 모두 연결할 수 있는 경우의 비용을 찾아 출력한다.
 * 별들이 연결되어 있는지 union&find를 이용해 확인한다.
 * 어려웠던 점: 없었다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Star{
	int num;
	double x, y;
	public Star(int num, double x, double y) {
		// TODO Auto-generated constructor stub
		this.num = num;
		this.x = x;
		this.y = y;
	}
}

class Edge implements Comparable<Edge>{
	int a, b;
	double cost;
	public Edge(int a, int b, double cost) {
		// TODO Auto-generated constructor stub
		this.a = a;
		this.b = b;
		this.cost = cost;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return (int)(this.cost - o.cost);
	}
}

public class BOJ4386_Constellation {
	
	static int [] parent;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //별의 개수
		Star [] s = new Star[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			s[i] = new Star(i, x, y);
		}
		
		ArrayList<Edge> connection = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				double cost = Math.sqrt(Math.pow(s[i].x-s[j].x, 2) + Math.pow(s[i].y-s[j].y, 2));
				connection.add(new Edge(i, j, cost));
			}
		}
		Collections.sort(connection); //cost로 오름차순 정렬
		
		parent = new int[n];
		for(int i=0; i<n; i++)
			parent[i] = i;
		
		double answer = 0;
		
		//크루스칼 알고리즘
		for(int i=0; i<connection.size(); i++) {
			Edge e = connection.get(i);
			if(find(e.a) != find(e.b)) {
				answer += e.cost;
				union(e.a, e.b);
			}
		}
		System.out.println(answer);
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
		if(x != y)
			parent[y] = x;
	}

}
