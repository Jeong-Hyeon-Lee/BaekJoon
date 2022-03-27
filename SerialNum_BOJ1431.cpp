/*
백준 1431번
풀이 방법: 문제의 조건에 따라 compare 함수를 정의해 sort의 기준으로 삼았다.
어려웠던 점: 없었다.
*/
#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

bool compare(string a, string b) {
	if (a.size() != b.size())
		return a.size() < b.size();

	int sumA = 0, sumB = 0;
	for (int i = 0; i < a.size(); i++) {
		if ('0' <= a[i] && a[i] <= '9')
			sumA += a[i] - '0';
		if ('0' <= b[i] && b[i] <= '9')
			sumB += b[i] - '0';
	}
	if (sumA != sumB)
		return sumA < sumB;

	return a < b;
}

int main() {
	int N, i;
	string serial[50];
	cin >> N;

	for (i = 0; i < N; i++) {
		cin >> serial[i];
	}
	sort(serial, serial + N, compare);
	
	for (i = 0; i < N; i++) {
		cout << serial[i] << endl;
	}
	return 0;
}