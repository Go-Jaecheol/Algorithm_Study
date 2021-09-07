#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <cmath>

using namespace std;

int N;
vector<int> population;
vector<vector<int>> adj_list;

int bfs(vector<int>& perm, int area) {
    int count = 1;
    queue<int> q;
    vector<bool> visited(N + 1);
    
    int start = 0;
    for (int i = 0; i < N; i++) {
        if (perm[i] == area) {
            start = i + 1;
            break;
        }
    }
    
    q.push(start);
    visited[start] = true;
    while (q.size()) {
        int cur = q.front();
        
        for (int i = 0; i < adj_list[cur].size(); i++) {
            int next = adj_list[cur][i];
            if (perm[next - 1] == area && !visited[next]) {
                q.push(next);
                visited[next] = true;
                count++;
            }
        }
        
        q.pop();
    }
    
    return count;
}

int getMin() {
    int ret = -1;
    
    for (int k = 1; k < N; k++) {
        vector<int> num(N), perm(N);
        for (int i = 0; i < N; i++) {
            num[i] = i + 1;
        }
        for (int i = N - k; i < N; i++) {
            perm[i] = 1;
        }
        
        do {
            int area1_cnt = bfs(perm, 1); // bfs로 인접한지 확인
            int area2_cnt = bfs(perm, 0);
            
            if (area1_cnt == k && area2_cnt == N - k) { // 인접하면 인구 차이 구하기
                int area1_pop = 0, area2_pop = 0;
                
                for (int i = 0; i < N; i++) {
                    if (perm[i] == 1) area1_pop += population[i + 1];
                    else area2_pop += population[i + 1];
                }
                
                if (ret == -1) ret = abs(area1_pop - area2_pop);
                else ret = min(ret, abs(area1_pop - area2_pop));
            }
        } while(next_permutation(perm.begin(), perm.end()));
    }
    
    return ret;
}

int main() {
    cin >> N;
    population = vector<int> (N + 1);
    adj_list = vector<vector<int>> (N + 1);
    for (int i = 1; i <= N; i++) {
        cin >> population[i];
    }
    for (int i = 1; i <= N; i++) {
        int adjN;
        cin >> adjN;
        vector<int> adjL(adjN);
        for (int j = 0; j < adjN; j++) {
            cin >> adjL[j];
        }
        adj_list[i] = adjL;
    }
    
    int res = getMin();
    cout << res << '\n';
}
