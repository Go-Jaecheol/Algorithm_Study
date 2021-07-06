#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int K, V, E;

int isBipartiteGraph() {
    int v1, v2;
    queue<int> q;
    vector<int> adj_list[V + 1];
    vector<int> visited(V + 1, -1);
    for (int i = 0; i < E; i++) {
        cin >> v1 >> v2;
        adj_list[v1].push_back(v2);
        adj_list[v2].push_back(v1);
    }
    
    for (int vert = 1; vert <= V; vert++) {
        if (visited[vert] == -1) {
            q.push(vert);
            visited[vert] = 0;
            while(q.size()) {
                int size = (int)q.size();
                for (int i = 0; i < size; i++) {
                    int cur = q.front();
                    int cur_group = visited[cur];
                    for (int j = 0; j < adj_list[cur].size(); j++) {
                        int next = adj_list[cur][j];
                        if (visited[next] == -1) {
                            q.push(next);
                            visited[next] = (cur_group + 1) % 2;
                        }
                        else if (visited[next] == cur_group) return 1;
                    }
                    q.pop();
                }
            }
        }
    }
    return 0;
}

int main() {
    cin >> K;
    for (int iter = 0; iter < K; iter++) {
        cin >> V >> E;
        int res = isBipartiteGraph();
        
        if (res == 0) cout << "YES" << '\n';
        else cout << "NO" << '\n';
    }
}
