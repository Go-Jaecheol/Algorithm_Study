#include <iostream>
#include <algorithm>

using namespace std;

int N;
int* arr;
int* nums;
int* dp;
int idx = 0;

int main() {
	cin >> N; 
	int max = 0, max_idx = 0;

	arr = new int[N];
	nums = new int[N];
	dp = new int[N];
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
		dp[i] = 1;
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j <= i; j++) {
			if ((arr[i] > arr[j]) && (dp[i] <= dp[j])) {
				dp[i] = dp[j] + 1;
			}
		}
	}
	for (int i = 0; i < N; i++) {
		if (max < dp[i]) {
			max = dp[i];
			max_idx = i;
		}
	}
	nums[idx++] = arr[max_idx];
	for (int i = max_idx - 1; i >= 0; i--) {
		if (dp[max_idx] - dp[i] == 1) {
			nums[idx++] = arr[i];
			max_idx = i;
		}
	}

	cout << max << endl;
	for (int i = idx - 1; i >= 0; i--) {
		cout << nums[i];
		if (i != 0)
			cout << " ";
	}
		
	delete[] arr, nums, dp;
	return 0;
}