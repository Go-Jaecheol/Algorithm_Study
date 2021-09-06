#include <iostream>
#include <vector>
#include <string>
#include <queue>
#include <utility>

using namespace std;
// Clockwise
int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};

vector<string> field(12);

void adjustPuyo() {
    for (int r = 11; r >= 0; r--) {
        for (int c = 0; c < 6; c++) {
            if (field[r][c] != '.') {
                int crow = r;
                while (crow + 1 < 12 && field[crow + 1][c] == '.') {
                    char color = field[crow][c];
                    field[crow + 1][c] = color;
                    field[crow][c] = '.';
                    crow++;
                }
            }
        }
    }
}

int getChain() {
    int res = 0;
    while (1) {
        bool foundChain = false;
        vector<vector<bool>> visited(12, vector<bool> (6));
        for (int r = 0; r < 12; r++) {
            for (int c = 0; c < 6; c++) {
                if (field[r][c] != '.' && !visited[r][c]) {
                    queue<pair<int, int>> q;
                    vector<pair<int, int>> st;
                    int count = 1;
                    char color = field[r][c];
                    
                    q.push(make_pair(r, c));
                    st.push_back(make_pair(r, c));
                    visited[r][c] = true;
                    while (q.size()) {
                        pair<int, int> cur = q.front();
                        
                        for (int dir = 0; dir < 4; dir++) {
                            int nr = cur.first + dr[dir], nc = cur.second + dc[dir];
                            if (0 <= nr && nr < 12 && 0 <= nc && nc < 6 && field[nr][nc] == color && !visited[nr][nc]) {
                                q.push(make_pair(nr, nc));
                                visited[nr][nc] = true;
                                st.push_back(make_pair(nr, nc));
                                count++;
                            }
                        }
                        q.pop();
                    }
                    
                    if (count >= 4) { // 연쇄 발견
                        foundChain = true;
                        for (int i = 0; i < st.size(); i++) {
                            pair<int, int> cur = st[i];
                            field[cur.first][cur.second] = '.';
                        }
                    }
                }
            }
        }
        if (foundChain) {
            adjustPuyo();
            res++;
        }
        else break;
    }
    
    
    return res;
}

int main() {
    for (int i = 0; i < 12; i++) {
        cin >> field[i];
    }
    int res = getChain();
    cout << res << '\n';
}
