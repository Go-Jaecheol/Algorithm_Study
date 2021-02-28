#include <iostream>
#include <queue>
using namespace std;

int N, shark_x, shark_y, shark_size = 2, min_x, min_y, min_dist, time = 0;
int** space, ** visited;
int x_ar[4] = { -1, 0, 0, 1 }, y_ar[4] = { 0, -1, 1, 0 };

void get_fish(int x, int y);

int main() {
	cin >> N;

	space = new int* [N];
	visited = new int* [N];
	for (int i = 0; i < N; i++) {
		space[i] = new int[N];
		visited[i] = new int[N];
		for (int j = 0; j < N; j++) {
			cin >> space[i][j];
			if (space[i][j] == 9)
				shark_x = i, shark_y = j, space[i][j] = 0;
		}
	}
	int eat = 0;
	while (1) {
		min_x = -1, min_y = -1, min_dist = 987654321;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				visited[i][j] = -1;

		get_fish(shark_x, shark_y);
		if (min_x != -1 && min_y != -1) {
			time += visited[min_x][min_y];
			eat++;
			if (eat == shark_size)
				eat = 0, shark_size++;

			space[min_x][min_y] = 0;
			shark_x = min_x, shark_y = min_y;
		}
		else
			break;
	}

	cout << time;
	for (int i = 0; i < N; i++) {
		delete[] space[i];
		delete[] visited[i];
	}
	delete[] space;
	delete[] visited;
	return 0;
}

void get_fish(int x, int y) {
	queue<pair<int, int>> q;
	visited[x][y] = 0;
	q.push(make_pair(x, y));

	while (!q.empty()) {
		int cur_x = q.front().first, cur_y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int new_x = cur_x + x_ar[i], new_y = cur_y + y_ar[i];

			if (new_x < 0 || new_x > N - 1 || new_y < 0 || new_y > N - 1) continue;
			if (visited[new_x][new_y] != -1 || space[new_x][new_y] > shark_size) continue;

			visited[new_x][new_y] = visited[cur_x][cur_y] + 1;
			if (space[new_x][new_y] != 0 && space[new_x][new_y] < shark_size) {
				if (min_dist > visited[new_x][new_y]) {
					min_x = new_x, min_y = new_y;
					min_dist = visited[new_x][new_y];
				}
				else if (min_dist == visited[new_x][new_y]) {
					if (min_x == new_x) {
						if (min_y > new_y)
							min_y = new_y;
					}
					else if (min_x > new_x)
						min_x = new_x, min_y = new_y;
				}
			}
			q.push(make_pair(new_x, new_y));
		}
	}
}