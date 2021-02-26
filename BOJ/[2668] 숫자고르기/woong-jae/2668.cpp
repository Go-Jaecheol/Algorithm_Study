#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
int n;
int graph[101][101], visited[101];

void getNum(vector<int>& res, int start, int compare) {
    res.push_back(start);
    for (int i = 1; i <= n; i++) {
        if (graph[res.back()][i] == 1 && res.at(compare) != i) {
            getNum(res, i, compare);
        }
    }
}

int check_cycle(int s) {
    vector<int> v;
    int check[101] = {0, };
    v.push_back(s);
    check[s] = 1;
    visited[s] = 1;
    while(v.size()) {
        int cur = v.back();
        v.pop_back();
        for (int i = 1; i <= n; i++) {
            if (graph[cur][i] == 1) {
                if (check[i] == 1) {//cycle 발견
                    return i;
                }
                if (visited[i] != 1) {
                    v.push_back(i);
                    check[i] = 1;
                    visited[i] = 1;
                }
                break;
            }
        }
    }
    return 0;
}

int main() {
    vector<int> res;
    
    cin >> n;
    for (int i = 1; i <= n; i++) {
            int temp;
            cin >> temp;
            graph[i][temp] = 1;
        }
    
    for (int i = 1; i <= n; i++) {
        if (visited[i] != 1) {
            int r = check_cycle(i);
            if (r) {
                getNum(res, r, (int)res.size());
            }
        }
    }
    sort(res.begin(), res.end());
    cout << res.size() << '\n';
    for (int i = 0; i < res.size(); i++) {
        cout << res[i] << '\n';
    }
}

