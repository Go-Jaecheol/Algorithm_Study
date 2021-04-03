#include <iostream>
#include <vector>
#include <queue>
#include <utility>

#define INF 140625

using namespace std;
int n;
int dr[4] = {1, 0, -1, 0};
int dc[4] = {0, 1, 0, -1};

int main() {
    int iter = 1;
    while(1) {
        cin >> n;
        if (n == 0) break;
        vector<vector<int>> map(n ,vector<int> (n));
        vector<vector<int>> dist(n, vector<int> (n, INF));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cin >> map[i][j];
            }
        }
        dist[0][0] = map[0][0];
        priority_queue<pair<int, pair<int, int>>> pq;
        pq.push(make_pair(-dist[0][0], make_pair(0, 0)));
        while (!pq.empty()) {
            int cost = -pq.top().first;
            pair<int, int> here = pq.top().second;
            pq.pop();
            if (cost > dist[here.first][here.second]) continue;
            for (int i = 0; i < 4; i++) {
                pair<int, int> there = make_pair(here.first + dr[i], here.second + dc[i]);
                if (0 <= there.first && there.first < n && 0 <= there.second && there.second < n) {
                    int nextDist = cost + map[there.first][there.second];
                    if (dist[there.first][there.second] > nextDist) {
                        dist[there.first][there.second] = nextDist;
                        pq.push(make_pair(-nextDist, make_pair(there.first, there.second)));
                    }
                }
            }
        }
        printf("Problem %d: %d\n", iter++, dist[n - 1][n - 1]);
    }
}

