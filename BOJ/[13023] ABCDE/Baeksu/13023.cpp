#include <iostream>
#include <vector>
#include <cstring>
using namespace std;

void dfs(int idx, int depth);

int N, M;
vector<int> v[2000];
int visited[2000];

int main() {
	cin >> N >> M;
	int m = 0;

	while (m != M) {
		int a, b;
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
		visited[m++] = -1;
	}

	for (int i = 0; i < N; i++)
		dfs(i, 0);

	cout << "0";
	return 0;
}

void dfs(int idx, int depth) {
	if (depth >= 4) {
		cout << "1";
		exit(0);
	}

	depth++;
	visited[idx] = 1;
	for (vector<int>::size_type i = 0; i < v[idx].size(); i++) {
		if (visited[v[idx][i]] == -1)
			dfs(v[idx][i], depth);
	}
	visited[idx] = -1;
	depth--;
}