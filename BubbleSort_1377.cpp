/*
백준 1377번
풀이 방법: 주어진 코드의 출력값은 버블정렬이 몇번째에서 완성되냐이다.
sort를 이용해 정렬을 한 후 vector에 pair로 같이 저장해둔 인덱스 값을 이용해 횟수를 구한다.
숫자가 왼쪽으로 이동한 횟수가 버블정렬이 일어난 횟수이므로 (정렬 전 인덱스값)-(정렬 후 인덱스값)+1을 출력한다.
어려웠던 점: 버블정렬이 일어난 횟수를 구하는 방법을 생각하는게 좀 걸렸다.
*/
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    int N, i;
    cin >> N;
    vector < pair<int, int>> A(N+1);

    for (i = 1; i <= N; i++) {
        cin >> A[i].first;
        A[i].second = i;
    }

    sort(A.begin(), A.end());

    int answer = 0;

    for (i = 1; i <= N; i++) {
        if (answer < A[i].second - i)
            answer = A[i].second - i;
    }

    cout << answer + 1;
}