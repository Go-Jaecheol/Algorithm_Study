#include <iostream>
#include <algorithm>

using namespace std;

int N;
int dp[1001][1001];

int main() {
	string str1, str2;

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
	cout << dp[str1.size()][str2.size()];
	return 0;
}