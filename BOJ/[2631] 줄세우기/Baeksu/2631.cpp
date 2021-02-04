#include <iostream>
#include <algorithm>

using namespace std;

int N, max_dp = 0;
int* arr;
int* dp;

int main() {
	cin >> N;

	arr = new int[N];
	dp = new int[N];
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
		dp[i] = 1;
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < i; j++) {
			if ((arr[i] > arr[j]) && dp[i] <= dp[j]) {
				dp[i] = dp[j] + 1;
			}
			if (max_dp < dp[i])
				max_dp = dp[i];
		}
	}

	cout << N - max_dp;
	delete[] arr;
	delete[] dp;
	return 0;
}