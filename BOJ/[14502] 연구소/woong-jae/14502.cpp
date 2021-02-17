#include <iostream>
#include <cstring>
#include <queue>
#include <vector>
#include <utility>

using namespace std;

int n, m;
int x[4] = {1, 0, -1, 0};
int y[4] = {0, 1, 0, -1};
vector<vector<int>> origin(8, vector<int> (8, 0));
vector<pair<int, int>> virus, safe;

int getSafeArea(vector<vector<int>>& map) {
    int a = 0;
    
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(map[i][j] == 0) a++;
        }
    }
    
    return a;
}

int spreadVirus(vector<vector<int>>& copy) {
    vector<vector<int>> map(copy);
    queue<pair<int, int>> st;
    
    for(int i = 0; i < virus.size(); i++) {
        st.push(pair<int, int> (virus[i].first, virus[i].second));
        while(st.size()) {
            for(int k = 0; k < 4; k ++) {
                int nr = st.front().first + x[k], nc = st.front().second + y[k];
                if(0 <= nc && nc < m && 0 <= nr && nr < n && map[nr][nc] == 0) {
                    st.push(pair<int, int> (nr, nc));
                    map[nr][nc] = 2;
                }
            }
            st.pop();
        }
    }
    
    return getSafeArea(map);
}

int putWall(vector<vector<int>>& map) {
    int res = 0;
    
    for(int i = 0; i < safe.size(); i++) {
        map[safe[i].first][safe[i].second] = 1;
        for(int j = i + 1; j < safe.size(); j++) {
            map[safe[j].first][safe[j].second] = 1;
            for(int k = j + 1; k < safe.size(); k++) {
                map[safe[k].first][safe[k].second] = 1;
                res = max(res, spreadVirus(map));
                map[safe[k].first][safe[k].second] = 0;
            }
            map[safe[j].first][safe[j].second] = 0;
        }
        map[safe[i].first][safe[i].second] = 0;
    }
    
    return res;
}

int main() {
    cin >> n >> m;
    
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cin >> origin[i][j];
            if(origin[i][j] == 0) {
                safe.push_back(pair<int, int> (i, j));
            }else if(origin[i][j] == 2) {
                virus.push_back(pair<int, int> (i, j));
            }
        }
    }
    cout << putWall(origin) << '\n';
}

