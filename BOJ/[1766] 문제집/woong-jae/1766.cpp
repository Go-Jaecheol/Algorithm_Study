#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, M;
vector<vector<int>> adj_list;
vector<int> degree;

vector<int> create_seq() {
    vector<int> res;
    priority_queue<int, vector<int>, greater<int>> q;
    
    for (int i = 1; i <= N; i++) {
        if (degree[i] == 0) q.push(i);
    }
    
    while (q.size()) {
        int cur = q.top();
        q.pop();
        res.push_back(cur);
        
        for (int i = 0; i < adj_list[cur].size(); i++) {
            int next = adj_list[cur][i];
            if (--degree[next] == 0) q.push(next);
        }
    }
    
    return res;
}

int main() {
    cin >> N >> M;
    adj_list = vector<vector<int>> (N + 1);
    degree = vector<int> (N + 1);
    for (int i = 0; i < M; i++) {
        int a, b;
        cin >> a >> b;
        adj_list[a].push_back(b);
        degree[b]++;
    }
    
    vector<int> res = create_seq();
    for (int i = 0; i < res.size(); i++) {
        cout << res[i] << ' ';
    }
    cout << '\n';
}
