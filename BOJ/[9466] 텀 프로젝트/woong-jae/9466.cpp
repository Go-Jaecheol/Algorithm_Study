#include <iostream>
#include <vector>

using namespace std;

int n, cnt;
vector<int> results, choice;
vector<bool> visited, done;


void dfs(int cur) {
    visited[cur] = true;
    
    int next = choice[cur];
    if(!visited[next]) dfs(next);
    else if (!done[next]) {
        for (int i = next; i != cur; i = choice[i]) {
            cnt++;
        }
        cnt++;
    }
    done[cur] = true;
}

int main() {
    int T;
    cin >> T;
    for (int i = 0; i < T; i++) {
        // 초기화
        cnt = 0;
        cin >> n;
        choice = vector<int> (n + 1);
        visited = vector<bool> (n + 1);
        done = vector<bool> (n + 1);
        for (int j = 1; j <= n; j++) {
            cin >> choice[j];
        }
        
        for (int j = 1; j <= n; j++) {
            if(!visited[j]) dfs(j);
        }
        results.push_back(n - cnt);
    }
    for (int i = 0; i < results.size(); i++) {
        cout << results[i] << '\n';
    }
}


