#include <iostream>
#include <vector>

using namespace std;

typedef struct dragonCurve {
    int x;
    int y;
    int d;
    int g;
} dragonCurve;

int N;
int map[101][101] = {0, };
int dr[4] = {0, -1, 0, 1};
int dc[4] = {1, 0, -1, 0};

int getResult() {
    int ret = 0;
    
    for (int r = 0; r < 100; r++) {
        for (int c = 0; c < 100; c++) {
            if (map[r][c] != 0 && map[r][c + 1] != 0 && map[r + 1][c] != 0 && map[r + 1][c + 1] != 0)
                ret++;
        }
    }
    
    return ret;
}

void drawDragonCurve(dragonCurve cur) {
    vector<pair<int, int>> dots;
    
    dots.push_back(make_pair(cur.y, cur.x));
    map[dots.back().first][dots.back().second] = 1;
    dots.push_back(make_pair(cur.y + dr[cur.d], cur.x + dc[cur.d]));
    map[dots.back().first][dots.back().second] = 1;
    for (int i = 1; i <= cur.g; i++) {
        int size = (int)dots.size() - 1;
        for (int i = size; i > 0; i--) {
            int nr = dots[i - 1].first - dots[i].first, nc = dots[i - 1].second - dots[i].second;
            
            for (int dir = 0; dir < 4; dir++) {
                if (dr[dir] == nr && dc[dir] == nc) {
                    dots.push_back(make_pair(dots.back().first + dr[(dir + 3) % 4], dots.back().second + dc[(dir + 3) % 4]));
                    map[dots.back().first][dots.back().second] = 1;
                    break;
                }
            }
        }
    }
}

int main() {
    cin >> N;
    for (int i = 0; i < N; i++) {
        dragonCurve in;
        cin >> in.x >> in.y >> in.d >> in.g;
        drawDragonCurve(in);
    }
    cout << getResult() << '\n';
}
