#include <iostream>
#include <utility>
#include <queue>

using namespace std;

int row, col;
char** map;
int** visited;
int x_ar[4] = { -1, 0, 1, 0 };
int y_ar[4] = { 0, 1, 0, -1 };

void maze(int x, int y);

int main() {
	cin >> row >> col;

	map = new char* [row];
	visited = new int* [row];
	for (int i = 0; i < row; i++) {
		map[i] = new char[col];
		visited[i] = new int[col];
		for (int j = 0; j < col; j++) {
			cin >> map[i][j];
			visited[i][j] = -1;
		}
	}

	visited[0][0] = 1;
	maze(0, 0);
	cout << visited[row - 1][col - 1];

	for (int i = 0; i < row; i++) {
		delete[] map[i];
		delete[] visited[i];
	}
	delete[] map;
	delete[] visited;
	return 0;
}

void maze(int x, int y) {
	queue <pair<int, int> > q;
	pair<int, int> cur = make_pair(x, y);
	q.push(cur);
	while (!q.empty()) {
		cur = q.front();
		q.pop();
		for (int i = 0; i < 4; i++) {
			pair<int, int> next = make_pair(cur.first + x_ar[i], cur.second + y_ar[i]);

			if (next.first >= 0 && next.first < row && next.second >= 0 && next.second < col) {
				if (map[next.first][next.second] == '1' && visited[next.first][next.second] == -1) {
					if (visited[next.first][next.second] == -1 || (visited[next.first][next.second] > visited[cur.first][cur.second] + 1))
						visited[next.first][next.second] = visited[cur.first][cur.second] + 1;
					q.push(make_pair(next.first, next.second));
				}
			}
		}
	}
}