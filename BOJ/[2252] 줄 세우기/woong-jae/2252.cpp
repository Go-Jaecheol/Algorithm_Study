#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, M;
vector<vector<int>> adj_list;
vector<int> in_degree, res;

void make_sequence() {
    queue<int> q;
    for (int i = 1; i <= N; i++) {
        if (in_degree[i] == 0) q.push(i);
    }
    
    while (q.size()) {
        int cur = q.front();
        q.pop();
        res.push_back(cur);
        for (int j = 0; j < adj_list[cur].size(); j++) {
            int next = adj_list[cur][j];
            if (--in_degree[next] == 0) {
                q.push(next);
            }
        }
    }
}

int main() {
    cin >> N >> M;
    adj_list = vector<vector<int>> (N + 1);
    in_degree = vector<int> (N + 1, 0);
    for (int i = 0; i < M; i++) {
        int a, b;
        cin >> a >> b;
        adj_list[a].push_back(b);
        in_degree[b]++;
    }
    
    make_sequence();
    
    for (int i = 0; i < res.size(); i++) {
        cout << res[i] << ' ';
    }
    cout << '\n';
}
