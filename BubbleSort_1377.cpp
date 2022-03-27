/*
���� 1377��
Ǯ�� ���: �־��� �ڵ��� ��°��� ���������� ���°���� �ϼ��ǳ��̴�.
sort�� �̿��� ������ �� �� vector�� pair�� ���� �����ص� �ε��� ���� �̿��� Ƚ���� ���Ѵ�.
���ڰ� �������� �̵��� Ƚ���� ���������� �Ͼ Ƚ���̹Ƿ� (���� �� �ε�����)-(���� �� �ε�����)+1�� ����Ѵ�.
������� ��: ���������� �Ͼ Ƚ���� ���ϴ� ����� �����ϴ°� �� �ɷȴ�.
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