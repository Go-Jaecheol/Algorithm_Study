#include <iostream>

using namespace std;

int N;
int dp[100][10];

void dp_stair(int num);

int main() {
	cin >> N;
	for (int i = 0; i < 10; i++) {
		dp[0][i] = 1;
	}

	dp_stair(N);
	return 0;
}

void dp_stair(int num) {
	long long sum = 0;
	for (int i = 1; i < N; i++) {
		dp[i][9] = dp[i - 1][8] % 1000000000;
		dp[i][0] = dp[i][9];
		for (int j = 8; j > 0; j--) {
			dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
			dp[i][j] %= 1000000000;
		}
	}

	for (int i = 1; i < 10; i++) {
		sum += dp[num - 1][i];
	}

	cout << sum % 1000000000;
}