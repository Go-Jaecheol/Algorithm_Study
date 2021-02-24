#include <iostream>

using namespace std;

int N, weak_cnt = 0, normal_cnt = 0;
char** picture;
int** visited;
int x_ar[4] = { -1, 0, 0, 1 };
int y_ar[4] = { 0, -1, 1, 0 };

void normal(int x, int y);
void weak(int x, int y);

int main() {
	cin >> N;

	picture = new char* [N];
	visited = new int* [N];
	for (int i = 0; i < N; i++) {
		picture[i] = new char[N];
		visited[i] = new int[N];
		for (int j = 0; j < N; j++) {
			cin >> picture[i][j];
			visited[i][j] = -1;
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (visited[i][j] == -1) {
				normal(i, j);
				normal_cnt++;
			}
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (visited[i][j] == 1) {
				weak(i, j);
				weak_cnt++;
			}
		}
	}

	cout << normal_cnt << " " << weak_cnt;
	for (int i = 0; i < N; i++) {
		delete[] picture[i];
		delete[] visited[i];
	}
	delete[] picture;
	delete[] visited;
	return 0;
}

void normal(int x, int y) {
	if (visited[x][y] == -1) {
		char color = picture[x][y];
		visited[x][y] = 1;

		for (int i = 0; i < 4; i++) {
			int new_x = x + x_ar[i], new_y = y + y_ar[i];

			if (new_x >= 0 && new_x < N && new_y >= 0 && new_y < N) {
				if (visited[new_x][new_y] == -1 && picture[new_x][new_y] == color) {
					normal(new_x, new_y);
				}
			}
		}
	}
}

void weak(int x, int y) {
	if (visited[x][y] == 1) {
		char color = picture[x][y];
		visited[x][y] = -1;

		for (int i = 0; i < 4; i++) {
			int new_x = x + x_ar[i], new_y = y + y_ar[i];

			if (new_x >= 0 && new_x < N && new_y >= 0 && new_y < N) {
				if (visited[new_x][new_y] == 1) {
					if (color == picture[new_x][new_y])
						weak(new_x, new_y);
					else if (color == 'R' && picture[new_x][new_y] == 'G')
						weak(new_x, new_y);
					else if (color == 'G' && picture[new_x][new_y] == 'R')
						weak(new_x, new_y);
				}
			}
		}
	}
}