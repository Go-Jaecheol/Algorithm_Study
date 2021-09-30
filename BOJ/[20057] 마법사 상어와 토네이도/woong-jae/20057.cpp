#include <iostream>
#include <utility>
#include <vector>
#include <cmath>

using namespace std;
int N, ret = 0;
vector<vector<int>> map;

int dr[4] = {0, 1, 0, -1}; // 좌 아래 우 위
int dc[4] = {-1, 0, 1, 0};


void checkAndAdd(int r, int c, int sand) {
    if (0 <= r && r < N && 0 <= c && c < N) {
        map[r][c] += sand;
    } else {
        ret += sand;
    }
}

void magicSharkAndTornado() {
    int move = 1, count = 0, dir = 0;
    pair<int, int> cur = make_pair(N / 2, N / 2);
    while(1) {
        bool end = false;
        for (int m = 0; m < move; m++) {
            pair<int, int> next = make_pair(cur.first + dr[dir], cur.second + dc[dir]);
            int sand = map[next.first][next.second], out = 0;
            int ndir;
            map[next.first][next.second] = 0;
            
            int nr = next.first + dr[dir] * 2, nc = next.second + dc[dir] * 2;
            checkAndAdd(nr, nc, floor(sand * 0.05)); // 진행방향
            // 진행방향 좌측
            ndir = (dir + 1) % 4;
            nr = next.first + dr[ndir]; nc = next.second + dc[ndir];
            checkAndAdd(nr, nc, floor(sand * 0.07));
            checkAndAdd(nr + dr[ndir], nc + dc[ndir], floor(sand * 0.02));
            checkAndAdd(nr + dr[(ndir + 3) % 4], nc + dc[(ndir + 3) % 4], floor(sand * 0.1));
            checkAndAdd(nr + dr[(ndir + 1) % 4], nc + dc[(ndir + 1) % 4], floor(sand * 0.01));
            // 진행방향 우측
            ndir = (dir + 3) % 4;
            nr = next.first + dr[ndir]; nc = next.second + dc[ndir];
            checkAndAdd(nr, nc, floor(sand * 0.07));
            checkAndAdd(nr + dr[ndir], nc + dc[ndir], floor(sand * 0.02));
            checkAndAdd(nr + dr[(ndir + 1) % 4], nc + dc[(ndir + 1) % 4], floor(sand * 0.1));
            checkAndAdd(nr + dr[(ndir + 3) % 4], nc + dc[(ndir + 3) % 4], floor(sand * 0.01));
            out += floor(sand * 0.05) + 2 *(floor(sand * 0.07) + floor(sand * 0.02) + floor(sand * 0.1) + floor(sand * 0.01));
            
            checkAndAdd(next.first + dr[dir], next.second + dc[dir], sand - out);
            
            if (next.first == 0 && next.second == 0) {
                end = true;
                break;
            }
            cur = next;
        }
        if (end) break;
        if (++count == 2) {
            if (move < N - 1) move++;
            count = 0;
        }
        dir = (dir + 1) % 4;
    }
}

int main() {
    cin >> N;
    map = vector<vector<int>> (N, vector<int> (N));
    for (int r = 0; r < N; r++) {
        for (int c = 0; c < N; c++) {
            cin >> map[r][c];
        }
    }
    magicSharkAndTornado();
    cout << ret << '\n';
}
