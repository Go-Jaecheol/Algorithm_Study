#include <iostream>
#include <queue>
#include <cstring>
#include <utility>

using namespace std;
int n;
char pic[100][101];
int normal[100][100], weak[100][100];
int dr[4] = {0, 1, 0, -1};
int dc[4] = {1, 0, -1, 0};

int isSame(char c) {
    if (c == 'B') {
        return 0;
    } else {
        return 1;
    }
}

int weak_area() {
    int res = 0;
    int tr, tc;
    queue<pair<int, int>> q;
    
    for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
            if (weak[r][c] == -1) {
                int rgb = isSame(pic[r][c]);
                q.push(pair<int, int> (r, c));
                weak[r][c] = 1;
                while(q.size()) {
                    for (int i = 0; i < 4; i++) {
                        tr = q.front().first + dr[i]; tc = q.front().second + dc[i];
                        if (0 <= tr && tr < n && 0 <= tc && tc < n && weak[tr][tc] == -1 && rgb == isSame(pic[tr][tc])) {
                            q.push(pair<int, int> (tr, tc));
                            weak[tr][tc] = 1;
                        }
                    }
                    q.pop();
                }
                res++;
            }
        }
    }
    
    return res;
}

int normal_area() {
    int res = 0;
    int tr, tc;
    queue<pair<int, int>> q;
    
    for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
            if (normal[r][c] == -1) {
                char cur = pic[r][c];
                q.push(pair<int, int> (r, c));
                normal[r][c] = 1;
                while(q.size()) {
                    for (int i = 0; i < 4; i++) {
                        tr = q.front().first + dr[i]; tc = q.front().second + dc[i];
                        if (0 <= tr && tr < n && 0 <= tc && tc < n && normal[tr][tc] == -1 && cur == pic[tr][tc]) {
                            q.push(pair<int, int> (tr, tc));
                            normal[tr][tc] = 1;
                        }
                    }
                    q.pop();
                }
                res++;
            }
        }
    }
    
    return res;
}

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> pic[i];
    }
    memset(normal, -1, sizeof(normal));
    memset(weak, -1, sizeof(weak));
    cout << normal_area() << '\n';
    cout << weak_area() << '\n';
}

