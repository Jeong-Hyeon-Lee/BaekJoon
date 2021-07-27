//백준 2304번
package ICPC_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class makeAreaSmallest {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] L = new int[N];
		HashMap<Integer, Integer> h = new HashMap<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L[i] = Integer.parseInt(st.nextToken());
			h.put(L[i], Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(L);
		int max = h.get(L[0]), maxval=0, maxval2=-1;
		for(int i=0; i<N; i++) {
			if(h.get(L[i]) > max) {
				max = h.get(L[i]);
				maxval = i;
			}
			if(i> maxval && h.get(L[i]) == max)
				maxval2 = i;
		}
		Stack<Integer> LeftH = new Stack<>();
		Stack<Integer> LeftL = new Stack<>();
		Stack<Integer> RightH = new Stack<>();
		Stack<Integer> RightL = new Stack<>();
		
		for(int i=maxval; i>=0; i--) {
			if(LeftH.empty()) {
				LeftH.push(h.get(L[i]));
				LeftL.push(L[i]);
			}
			else {
				while(!LeftH.empty() && LeftH.peek()<=h.get(L[i])) {
					LeftH.pop();
					LeftL.pop();
				}
				LeftH.push(h.get(L[i]));
				LeftL.push(L[i]);
			}
		}
		if(maxval2 ==-1)
			maxval2 = maxval;
		for(int i=maxval2; i<N; i++) {
			if(RightH.empty()) {
				RightH.push(h.get(L[i]));
				RightL.push(L[i]);
			}
			else {
				while(!RightH.empty() && RightH.peek()<=h.get(L[i])) {
					RightH.pop();
					RightL.pop();
				}
				RightH.push(h.get(L[i]));
				RightL.push(L[i]);
			}
		}
		int area;
		int areaL=0, areaM, areaR=0;
		int a = LeftL.size(), b = RightL.size();
		for(int i=0; i<a-1; i++) {
			int tempL = LeftL.pop();
			areaL += LeftH.peek() * (LeftL.peek() - tempL);
			LeftH.pop();
			//처음에 이거 위치 앞에 둬서 틀림
		}
		areaM = max * (L[maxval2] - L[maxval] + 1);
		for(int i=0; i<b-1; i++) {
			int tempL = RightL.pop();
			areaR += RightH.peek() * (tempL - RightL.peek());
			RightH.pop();
		}
		area = areaL + areaM + areaR;
		System.out.print(area);
		br.close();
	}

}
