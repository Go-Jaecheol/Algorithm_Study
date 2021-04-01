#include <iostream>
#include <vector>
#include <queue>
#include <utility>

#define INF 100000000

using namespace std;
int v, e;
vector<pair<int, int>> adj[20001];

vector<int> dijkstra(int src) {
    vector<int> dist(v + 1, INF);
    dist[src] = 0;
    priority_queue<pair<int, int>> pq;
    pq.push(make_pair(0, src));
    while (!pq.empty()) {
        int cost = -pq.top().first;
        int here = pq.top().second;
        pq.pop();
        // 만약 지금 꺼낸 것보다 더 짧은 경로를 알고 있다면 지금 꺼낸 것을 무시한다.
        if(dist[here] < cost) continue;
        for (int i = 0; i < adj[here].size(); i++) {
            int there = adj[here][i].first;
            int nextDist = cost + adj[here][i].second;
            // 더 짧은 경로를 발견하면, dist[]를 갱신하고 우선순위 큐에 넣는다.
            if (dist[there] > nextDist) {
                dist[there] = nextDist;
                pq.push(make_pair(-nextDist, there));
            }
        }
    }
    return dist;
}

int main() {
    int start, end;
    cin >> v >> e;
    for (int i = 0; i < e; i++) {
        int tu, tv, tw;
        cin >> tu >> tv >> tw;
        adj[tu].push_back(make_pair(tv, tw));
    }
    cin >> start >> end;
    vector<int> dist = dijkstra(start);
    cout << dist[end] << '\n';
}

