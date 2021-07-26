//���� 10828��
//Scanner ��� BufferedReader�� ���� �Է� �ޱ�
//Switch-case���� Ȱ��
package ICPC_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackEx {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch(st.nextToken()){
			case "push":
				int x = Integer.parseInt(st.nextToken());
				stack.push(x);
				break;
			case "pop":
				if(stack.empty()) {
					System.out.println(-1);
				}
				else{
					System.out.println(stack.peek());
					stack.pop();
				}
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				if(stack.empty())
					System.out.println(1);
				else
					System.out.println(0);
				break;
			case "top":
				if(!stack.empty())
					System.out.println(stack.peek());
				else
					System.out.println(-1);
				break;
			default:
				break;
			}
		}
		br.close();
	}

}
