#include <iostream>
#include <vector>
#include <utility>

#define MAX_V 100001
#define INF 987654321

using namespace std;
int N, M, K; // 도시의 수, 케이블의 수, 발전소의 수
vector<int> powerplant(1001);
vector<pair<int, int>> adj[MAX_V];

int prim() {
    vector<bool> added(N, false);
    vector<int> minWeigtht(N, INF), parent(N, -1);
    
    int ret = 0;
    for (int i = 0; i < K; i++) {
        minWeigtht[powerplant[i]] = parent[powerplant[i]] = 0;
    }
    for (int iter = 0; iter < N; iter++) {
        // 다음에 트리에 추가할 정점 u를 찾는다.
        int u = -1;
        for (int v = 0; v < N; v++) {
            if (!added[v] && (u == -1 || minWeigtht[u] > minWeigtht[v]))
                u = v;
        }
        ret += minWeigtht[u];
        added[u] = true;
        // u에 인접한 간선 (u, v)들을 검사한다.
        for (int i = 0; i < adj[u].size(); i++) {
            int v = adj[u][i].first, weight = adj[u][i].second;
            if (!added[v] && minWeigtht[v] > weight) {
                parent[v] = u;
                minWeigtht[v] = weight;
            }
        }
    }
    return ret;
}

int main() {
    cin >> N >> M >> K;
    for (int i = 0; i < K; i++) {
        cin >> powerplant[i];
        powerplant[i]--;
    }
    for (int i = 0; i < M; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        adj[u - 1].push_back(make_pair(v - 1, w));
        adj[v - 1].push_back(make_pair(u - 1, w));
    }
    int res = prim();
    
    cout << res;
}

