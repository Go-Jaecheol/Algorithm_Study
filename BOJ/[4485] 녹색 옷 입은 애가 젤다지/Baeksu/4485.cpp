#include <iostream>
#include <vector>
#include <queue>
using namespace std;

typedef struct xyw {
	int x, y, w;
} xyw;

struct cmp {
	bool operator() (xyw a, xyw b) {
		if (a.w == b.w)
			return a.x + a.y < b.x + b.y;
		return a.w > b.w;
	}
};

int n, x_ary[4] = { -1, 1, 0, 0 }, y_ary[4] = { 0, 0, -1, 1 };
vector <vector <int>> map;
vector <vector <int>> dist;

int thief_rupee() {
	priority_queue<xyw, vector <xyw>, cmp> pq;
	pq.push({ 0, 0, map[0][0] });

	while (!pq.empty()) {
		int now_x = pq.top().x, now_y = pq.top().y, now_w = pq.top().w;
		pq.pop();

		for (int i = 0; i < 4; i++) {
			int nx = now_x + x_ary[i], ny = now_y + y_ary[i];
			if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if (dist[nx][ny] > map[nx][ny] + now_w) {
					dist[nx][ny] = map[nx][ny] + now_w;
					pq.push({ nx,ny,dist[nx][ny] });
				}
			}
		}
	}

	return dist[n - 1][n - 1];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int cnt = 1;

	while (1) {
		for (int i = 0; i < n; i++) {
			map[i].clear();
			dist[i].clear();
		}
		map.clear();
		dist.clear();
		
		cin >> n;
		if (n == 0)
			break;
		for (int i = 0; i < n; i++) {
			vector <int> e1, e2;
			for (int j = 0; j < n; j++) {
				int k;
				cin >> k;
				e1.push_back(k);
				e2.push_back(987654321);
			}
			map.push_back(e1);
			dist.push_back(e2);
		}

		int min_money = thief_rupee();
		cout << "Problem " << cnt++ << ": " << min_money << "\n";
	}

	return 0;
}