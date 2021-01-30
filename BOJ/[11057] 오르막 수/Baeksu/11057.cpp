#include <iostream>

using namespace std;
int N;
int dp[1000][10];

int ascent(int num);

int main() {
	cin >> N;
	for (int i = 0; i < 10; i++) {
		dp[0][i] = 1;
	}

	cout << ascent(N);

	return 0;
}

int ascent(int n) {
	int sum = 0;
	for (int i = 1; i < N; i++) {
		dp[i][9] = 1;
		for (int j = 8; j >= 0; j--) {
			dp[i][j] = dp[i][j + 1] + dp[i - 1][j];
			dp[i][j] %= 10007;
		}
	}

	for (int i = 0; i < 10; i++) {
		sum += dp[n - 1][i];
	}
	return sum % 10007;
}