package study_21_11;

/*���� 4386��
 * Ǯ�� ���: ���� ����� ������ ����� ������ ������ ������ �ּ� ������� ������ ��� ������ �� �ִ� ����� ����� ã�� ����Ѵ�.
 * ������ ����Ǿ� �ִ��� union&find�� �̿��� Ȯ���Ѵ�.
 * ������� ��: ������.
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
		int n = Integer.parseInt(br.readLine()); //���� ����
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
		Collections.sort(connection); //cost�� �������� ����
		
		parent = new int[n];
		for(int i=0; i<n; i++)
			parent[i] = i;
		
		double answer = 0;
		
		//ũ�罺Į �˰���
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
