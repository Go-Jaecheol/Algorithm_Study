#include <iostream>

using namespace std;

int row, col;
int** map;
int** dp;
int x_ar[4] = { -1, 0, 0, 1 };
int y_ar[4] = { 0, -1, 1, 0 };

int check_down(int x, int y);

int main() {
	cin >> row >> col;

	map = new int* [row];
	dp = new int* [row];
	for (int i = 0; i < row; i++) {
		map[i] = new int[col];
		dp[i] = new int[col];
		for (int j = 0; j < col; j++) {
			cin >> map[i][j];
			dp[i][j] = -1;
		}
	}

	cout << check_down(0, 0);

	for (int i = 0; i < row; i++) {
		delete[] map[i];
		delete[] dp[i];
	}
	delete[] map;
	delete[] dp;
	return 0;
}

int check_down(int x, int y) {
	if (x == row - 1 && y == col - 1)
		return 1;
	else if (dp[x][y] != -1)
		return dp[x][y];

	dp[x][y] = 0;
	for (int i = 0; i < 4; i++) {
		int new_x = x + x_ar[i];
		int new_y = y + y_ar[i];

		if (new_x >= 0 && new_x < row && new_y >= 0 && new_y < col)
			if (map[x][y] > map[new_x][new_y])
				dp[x][y] += check_down(new_x, new_y);
	}
	return dp[x][y];
}