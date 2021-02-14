#include <iostream>
#include <algorithm>

using namespace std;

int N;
int dp[1001][1001];

int main() {
	string str1, str2;
	char lcs[1000];
	int idx = 0;

	cin >> str1;
	cin >> str2;

	for (int i = 0; i < str1.size(); i++) {
		for (int j = 0; j < str2.size(); j++) {
			if (str1[i] == str2[j])
				dp[i + 1][j + 1] = dp[i][j] + 1;
			else
				dp[i + 1][j + 1] = max(dp[i][j + 1], dp[i + 1][j]);
		}
	}

	cout << dp[str1.size()][str2.size()] << endl;

	for (int i = str1.size(), j = str2.size(); i >= 1, j >= 1;) {
		if (dp[i][j] == dp[i][j - 1])
			j--;
		else if (dp[i][j] == dp[i - 1][j])
			i--;
		else {
			lcs[idx++] = str1[i - 1];
			i--; j--;
		}
	}
	for (int i = idx - 1; i >= 0; i--) {
		cout << lcs[i];
	}

	return 0;
}