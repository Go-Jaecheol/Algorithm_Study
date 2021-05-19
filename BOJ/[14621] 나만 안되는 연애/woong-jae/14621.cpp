#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>

#define MAX_V 1001
#define INF 987654321

using namespace std;
int N, M; // 학교의 수, 도로의 개수
vector<char> university(MAX_V);
vector<pair<int, int>> adj[MAX_V];

struct DisjointSet {
    vector<int> parent, rank;
    DisjointSet(int n): parent(n), rank(n + 1) {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    int find(int u) {
        if (u == parent[u]) return u;
        return parent[u] = find(parent[u]);
    }
    void merge(int u, int v) {
        u = find(u); v = find(v);
        if (u == v) return;
        if (rank[u] > rank[v]) swap(u, v);
        parent[u] = v;
        if (rank[u] == rank[v]) ++rank[v];
    }
};

int kruskal(vector<pair<int, int>> &selected) {
    int ret = 0;
    vector<pair<int, pair<int, int>>> edges;
    for (int u = 0; u < N; u++) {
        for (int i = 0; i < adj[u].size(); i++) {
            int v = adj[u][i].first, cost = adj[u][i].second;
            edges.push_back(make_pair(cost, make_pair(u, v)));
        }
    }
    sort(edges.begin(), edges.end());
    DisjointSet sets(N);
    for (int i = 0; i < edges.size(); i++) {
        int cost = edges[i].first;
        int u = edges[i].second.first, v = edges[i].second.second;
        if (sets.find(u) == sets.find(v)) continue;
        sets.merge(u, v);
        selected.push_back(make_pair(u, v));
        ret += cost;
    }
    return ret;
}

int main() {
    vector<pair<int, int>> selected;
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        cin >> university[i];
    }
    for (int i = 0; i < M; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        if (university[u - 1] != university[v - 1]) adj[u - 1].push_back(make_pair(v - 1, w));
    }
    int res = kruskal(selected);
    if (selected.size() == N - 1) cout << res << '\n';
    else cout << -1 << '\n';
}
