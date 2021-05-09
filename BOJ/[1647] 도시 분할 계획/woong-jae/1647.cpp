#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>

using namespace std;

const int MAX_V = 100001;
int V, E;
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

int kruskal() {
    int ret = 0, cut = 0;
    vector<pair<int, pair<int, int>>> edges;
    for (int u = 1; u < V + 1; u++) {
        for (int i = 0; i < adj[u].size(); i++) {
            int v = adj[u][i].first, cost = adj[u][i].second;
            edges.push_back(make_pair(cost, make_pair(u, v)));
        }
    }
    sort(edges.begin(), edges.end());
    DisjointSet sets(V + 1);
    for (int i = 0; i < edges.size(); i++) {
        int cost = edges[i].first;
        int u = edges[i].second.first, v = edges[i].second.second;
        if (sets.find(u) == sets.find(v)) continue;
        sets.merge(u, v);
        cut = max(cut, cost);
        ret += cost;
    }
    return ret - cut;
}

int main() {
    cin >> V >> E;
    for (int i = 0; i < E; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        adj[u].push_back(make_pair(v, w));
    }
    cout << kruskal() << '\n';
}

