#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

struct graph {
	int x;
	int y;
	int w;
};

int N, M, K, cost = 0;
bool generator[1001];
vector <int> parent;
vector <graph> g;

bool cmp(graph a, graph b) {
	if (a.w == b.w)
		return a.x < b.x;
	return a.w < b.w;
}

int getRoot(int a) {
	if (a == parent[a])
		return a;
	return parent[a] = getRoot(parent[a]);
}

bool checkParent(int a, int b) {
	int r1 = getRoot(a);
	int r2 = getRoot(b);
	if ((r1 == r2) || (generator[r1] && generator[r2]))
		return true;
	return false;
}

void unionParent(int a, int b) {
	int r1 = getRoot(a);
	int r2 = getRoot(b);
	
	if (r1 == r2)
		return;
	if (generator[r1])
		parent[r2] = r1;
	else if (generator[r2])
		parent[r1] = r2;
	else
		parent[r2] = r1;
}

int main() {
	int a, b, c;
	cin >> N >> M >> K;
	parent.resize(N + 1);

	for (int i = 0; i < K; i++) {
		int s;
		cin >> s;
		generator[s] = true;
	}

	for (int i = 0; i < M; i++) {
		graph tmp;
		cin >> a >> b >> c;
		tmp.x = a, tmp.y = b, tmp.w = c;
		g.push_back(tmp);
	}

	sort(g.begin(), g.end(), cmp);

	for (int i = 1; i < N + 1; i++)
		parent[i] = i;

	for (int i = 0; i < g.size(); i++) {
		if (!checkParent(g[i].x, g[i].y)) {
			unionParent(g[i].x, g[i].y);
			cost += g[i].w;
		}
	}
	cout << cost;
	return 0;
}