#include <iostream>
#include <utility>

using namespace std;
int N, M, r, c, d;
int area[51][51];

int clean() {
    int ret = 1;
    int dr[4] = {-1, 0, 1, 0};
    int dc[4] = {0, 1, 0, -1};
    int spinCount = 0;
    
    area[r][c] = -1;
    pair<pair<int, int>, int> cur = make_pair(make_pair(r, c), d);
    while (1) {
        pair<int, int> left = make_pair(cur.first.first + dr[(cur.second + 3) % 4], cur.first.second + dc[(cur.second + 3) % 4]);
        if (spinCount == 4) {
            pair<int, int> behind = make_pair(cur.first.first + dr[(cur.second + 2) % 4], cur.first.second + dc[(cur.second + 2) % 4]);
            if (0 <= behind.first && behind.first < N && 0 <= behind.second && behind.second < M) {
                if (area[behind.first][behind.second] != 1) {
                    cur.first = behind;
                    spinCount = 0;
                }
                else {
                    break;
                }
            }
        }
        else if (0 <= left.first && left.first < N && 0 <= left.second && left.second < M && area[left.first][left.second] == 0) {
            area[left.first][left.second] = -1;
            ret++;
            spinCount = 0;
            cur = make_pair(left, (cur.second + 3) % 4);
        }
        else {
            cur.second = (cur.second + 3) % 4;
            spinCount++;
        }
    }
    
    return ret;
}

int main() {
    cin >> N >> M >> r >> c >> d;
    for (int r = 0; r < N; r++) {
        for (int c = 0; c < M; c++) {
            cin >> area[r][c];
        }
    }
    cout << clean() << '\n';
}
