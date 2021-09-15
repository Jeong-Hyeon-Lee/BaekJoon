/*14891번
풀이 방법: 톱니바퀴를 회전시키는 함수를 만들고, 왼쪽에 있고 오른쪽에 있는 톱니바퀴가 돌아가는 조건이면 회전시키는 함수를 만든다. 입력값을 받은 후 함수를 실행하고, 답을 출력한다.
어려웠던 점: 톱니바퀴 하나를 회전시키는 것이 아니라 조건에 따라 옆의 톱니바퀴가 회전할 수 있고 또 그에 따라 그 옆의 톱니바퀴가 회전할 수도 있기 때문에 이런 부분을 생각하는 것이 어려웠다.
*/

package Study_21_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14891 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [][] status = new int[4][8];
		for(int i=0; i<4; i++) {
			String s = br.readLine();
			for(int j=0; j<8; j++)
				status[i][j] = s.charAt(j) - '0'; //처음에는 그냥 char값을 넣어서 틀렸다.
		}
		int K = Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int gear = Integer.parseInt(st.nextToken()) - 1; //배열은 0부터 시작하므로! (주의)
			int turn = Integer.parseInt(st.nextToken());
			left(status, gear-1, -turn);
			right(status, gear+1, -turn);
			turngear(status, gear, turn);
		}
		System.out.println(status[3][0]);
		int answer = status[0][0] + 2*status[1][0] + 4*status[2][0] + 8*status[3][0];
		System.out.print(answer);
		br.close();
	}
	
	static void turngear(int [][] status, int gear, int turn) {
		if(turn == 1) {
			int temp = status[gear][7];
			for(int j=7; j>0; j--)
				status[gear][j] = status[gear][j-1];
			status[gear][0] = temp;
		}
		else if(turn == -1) {
			int temp = status[gear][0];
			for(int j=0; j<7; j++)
				status[gear][j] = status[gear][j+1];
			status[gear][7] = temp;
		}
	}
	static void left(int [][] status, int gear, int turn) {
		if(gear < 0)
			return;
		else if(status[gear][2] != status[gear+1][6]) {
			left(status, gear-1, -turn);
			turngear(status, gear, turn);
		}
	}
	static void right(int [][] status, int gear, int turn) {
		if(gear > 3)
			return;
		else if(status[gear][6] != status[gear-1][2]) {
			right(status, gear+1, -turn);
			turngear(status, gear, turn);
		}
	}

}
