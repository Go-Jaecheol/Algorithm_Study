#include <iostream>
#include <vector>
#include <queue>
#include <cstdlib>
using namespace std;

int migration();

int N, L, R;
int map[50][50];
int x_way[4] = { -1, 0, 1, 0 }, y_way[4] = { 0, 1, 0, -1 };

int main() {
	cin >> N >> L >> R;
	int ans = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> map[i][j];
		}
	}

	while (migration() != 0) {
		ans++;
	}
	cout << ans;
	return 0;
}

int migration() {
	int visited[50][50] = { 0, }, move_cnt = 0;

	for (int x = 0; x < N; x++) {
		for (int y = 0; y < N; y++) {
			if (visited[x][y] != 1) {
				queue <pair <int, int>> q, s;
				int people = map[x][y];
				visited[x][y] = 1;
				q.push(make_pair(x, y));
				s.push(make_pair(x, y));

				while (!q.empty()) {
					int cur_x = q.front().first, cur_y = q.front().second;
					q.pop();
					for (int i = 0; i < 4; i++) {
						int nx = x_way[i] + cur_x, ny = y_way[i] + cur_y;
						if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
							if (visited[nx][ny] != 1) {
								if (abs(map[nx][ny] - map[cur_x][cur_y]) >= L && abs(map[nx][ny] - map[cur_x][cur_y]) <= R) {
									visited[nx][ny] = 1;
									people += map[nx][ny];
									q.push(make_pair(nx, ny));
									s.push(make_pair(nx, ny));
								}
							}
						}
					}
				}
				if (s.size() >= 2) {
					int div = s.size();
					move_cnt++;
					while (!s.empty()) {
						int x = s.front().first, y = s.front().second;
						map[x][y] = people / div;
						s.pop();
					}
				}
			}
		}
	}
	return move_cnt;
}