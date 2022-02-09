/*
 백준 2841번
 풀이 방법: 기타의 각 줄에 대해 스택을 만든 스택 배열을 만들고 프렛을 누르면 스택에 추가한다.
 어려웠던 점: 각 상황에 대해 조건을 나누는 것이 조금 헷갈렸다.
 + 문제 이해를 처음에 잘못했었는데 잘 안되면 다시 문제 잘 이해했는지 생각해보기!
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
			
			if(s[n].isEmpty()) { //n번째 줄에 누르고 있는 프렛이 없을때
				s[n].add(p);
				move++;
			}
			else { //n번째 줄에 누르고 있는 프렛이 있을 때
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
