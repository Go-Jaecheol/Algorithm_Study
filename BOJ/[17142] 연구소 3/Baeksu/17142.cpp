#include <iostream>
#include <algorithm>
#include <utility>
#include <queue>
#include <stack>

using namespace std;

int N, virus, idx0 = 0, idx2 = 0, min_time = 9999999, arr_idx = 0;
int map[50][50], visited[50][50] = { 0, };
int x_ar[4] = { -1, 0, 1, 0 };
int y_ar[4] = { 0, 1, 0, -1 };
pair <int, int> active_virus[64];
pair <int, int> blank[64];
pair <int, int> active[10];

void covid(int idx, int virus);
void spreadout(int x, int y);
int map_set();

int main() {
	cin >> N >> virus;

	int time = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> map[i][j];
			if (map[i][j] == 1)
				map[i][j] = -1;
			if (map[i][j] == 2)
				active_virus[idx2].first = i, active_virus[idx2++].second = j;
			else if (map[i][j] == 0)
				blank[idx0].first = i, blank[idx0++].second = j;
		}
	}

	covid(0, virus);

	cout << min_time;
	return 0;
}

void covid(int idx, int w) {
	if (w == 0) { // 활성 바이러스를 모두 선택한 경우
		for (int i = 0; i < arr_idx; i++)
			spreadout(active[i].first, active[i].second);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				cout << visited[i][j];
			cout << endl;
		}
		cout << endl;
		int time = map_set();
		if (time != -1 && time < min_time)
			min_time = time;
	}
	else {
		w--;
		for (int i = idx; i < idx2; i++) {
			active[arr_idx].first = active_virus[i].first, active[arr_idx++].second = active_virus[i].second;
			covid(i + 1, w);
			arr_idx--;
		}
	}
}

void spreadout(int x, int y) {
	queue <pair<int, int> > q;
	q.push(make_pair(x, y));
	pair<int, int> cur;

	while (!q.empty()) {
		cur = q.front();
		q.pop();
		for (int j = 0; j < 4; j++) {
			pair<int, int> next = make_pair(cur.first + x_ar[j], cur.second + y_ar[j]);

			if (next.first >= 0 && next.first < N && next.second >= 0 && next.second < N) {
				if (map[next.first][next.second] == 0) {
					if (visited[next.first][next.second] == 0) {
						q.push(make_pair(next.first, next.second));
						visited[next.first][next.second] = visited[cur.first][cur.second] + 1;
					}
					else if (visited[next.first][next.second] != visited[cur.first][cur.second]) {
						q.push(make_pair(next.first, next.second));
						visited[next.first][next.second] = min(visited[cur.first][cur.second], visited[next.first][next.second]) + 1;
					}
				}
			}
		}
	}
}

int map_set() {
	int check = 0, max_time = 0;
	for (int i = 0; i < idx0; i++) {
		if (map[blank[i].first][blank[i].second] == 0 && visited[blank[i].first][blank[i].second] <= 0)
			check++;
		if (visited[blank[i].first][blank[i].second] > max_time) {
			max_time = visited[blank[i].first][blank[i].second];
		}
		visited[blank[i].first][blank[i].second] = 0;
	}
	if (check > 0)
		return -1;
	return max_time;
}