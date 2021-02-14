#include <iostream>

using namespace std;

int row, col, cnt = 0, max_area = 0;
int** map;
int** visited;
int x_ar[4] = { -1, 0, 0, 1 };
int y_ar[4] = { 0, -1, 1, 0 };

int picture(int x, int y, int area);

int main() {
	int area;
	cin >> row >> col;

	map = new int* [row];
	visited = new int* [row];
	for (int i = 0; i < row; i++) {
		map[i] = new int[col];
		visited[i] = new int[col];
		for (int j = 0; j < col; j++) {
			cin >> map[i][j];
			visited[i][j] = -1;
		}
	}

	for (int i = 0; i < row; i++) {
		for (int j = 0; j < col; j++) {
			area = 0;
			if (map[i][j] == 1 && visited[i][j] == -1) {
				area = picture(i, j, area);
				cnt++;
			}
			if (max_area < area)
				max_area = area;
		}
	}
	cout << cnt << endl << max_area;

	for (int i = 0; i < row; i++) {
		delete[] map[i];
		delete[] visited[i];
	}
	delete[] map;
	delete[] visited;
	return 0;
}

int picture(int x, int y, int area) {
	if (visited[x][y] == -1) {
		area++;
		visited[x][y] = 1;
		for (int i = 0; i < 4; i++) {
			int new_x = x + x_ar[i];
			int new_y = y + y_ar[i];

			if (new_x >= 0 && new_x < row && new_y >= 0 && new_y < col)
				if (map[new_x][new_y] == 1) {
					area = picture(new_x, new_y, area);
				}
		}
	}
	return area;
}