/*
﻿dp 배열에 인덱스 위치까지의 LCS를 저장하기로 하고 점화식을 만들었다.
만약 A의 i번째 알파벳과 B의 j번째 알파벳이 같다면 그 전까지의 LCS에 1을 더해주고,
알파벳이 다르다면 그 전까지의 LCS들을 비교해 큰 값을 해당 위치에 저장한다. 마지막 문자까지 다이나믹 프로그래밍을 완료한 후 답을 출력한다.
*/
#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int dp[1001][1001]; //인덱스 위치까지의 LCS

int main() {
	string A, B;
	int i, j;

	cin >> A >> B;

	for (i = 1; i <= A.size(); i++) {
		for (j = 1; j <= B.size(); j++) {
			if (A[i-1] == B[j-1])
				dp[i][j] = dp[i-1][j-1] + 1;
			else
				dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
		}
	}

	cout << dp[A.size()][B.size()] << endl;
	return 0;
}