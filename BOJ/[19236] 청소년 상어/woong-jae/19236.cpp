#include <iostream>
#include <vector>
#include <utility>
#include <map>

using namespace std;

typedef struct shark {
    int r;
    int c;
    int dir;
} shark;

int dr[8] = {-1, -1, 0, 1, 1, 1, 0, -1};
int dc[8] = {0, -1, -1, -1, 0, 1, 1, 1};

void printMap(vector<vector<pair<int, int>>> fishMap) {
    cout << endl;
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            cout << fishMap[i][j].first << ' ';
        }
        cout << endl;
    }
}

int teenageShark(shark curShark, vector<vector<pair<int, int>>> fishMap) {
    int eaten = fishMap[curShark.r][curShark.c].first;
    int ret = eaten;
    vector<vector<pair<int, int>>> movedFishMap = fishMap;
    movedFishMap[curShark.r][curShark.c].first = 0;
    // 물고기 움직임
    map<int, pair<int, int>> fishes;
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            if (movedFishMap[i][j].first != 0) {
                fishes.insert(make_pair(movedFishMap[i][j].first, make_pair(i, j)));
            }
        }
    }
    for(auto it = fishes.begin(); it != fishes.end(); it++) {
        pair<int, int> cur = it->second;
        for (int dir = 0; dir < 8; dir++) {
            int ndir = (movedFishMap[cur.first][cur.second].second + dir) % 8;
            int nr = cur.first + dr[ndir];
            int nc = cur.second + dc[ndir];
            if (0 <= nr && nr < 4 && 0 <= nc && nc < 4 && !(curShark.r == nr && curShark.c == nc)) {
                if (movedFishMap[nr][nc].first != 0) {
                    fishes[movedFishMap[nr][nc].first] = cur;
                }
                it->second = make_pair(nr, nc);
                movedFishMap[cur.first][cur.second].second = ndir;
                swap(movedFishMap[cur.first][cur.second], movedFishMap[nr][nc]);
                break;
            }
        }
    }
    // 상어 움직임
    pair<int, int> next;
    next.first = curShark.r + dr[curShark.dir];
    next.second = curShark.c + dc[curShark.dir];
    while (1) {
        if (0 <= next.first && next.first < 4 && 0 <= next.second && next.second < 4) {
            if (movedFishMap[next.first][next.second].first != 0) {
                shark nextShark;
                nextShark.r = next.first; nextShark.c = next.second;
                nextShark.dir = movedFishMap[next.first][next.second].second;
                ret = max(ret, eaten + teenageShark(nextShark, movedFishMap));
            }
        } else break;
        next.first = next.first + dr[curShark.dir];
        next.second = next.second + dc[curShark.dir];
    }
    
    return ret;
}

int main() {
    vector<vector<pair<int, int>>> fishMap(4, vector<pair<int, int>> (4));
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            cin >> fishMap[i][j].first;
            cin >> fishMap[i][j].second;
            fishMap[i][j].second--;
        }
    }
    shark initShark;
    initShark.r = 0;
    initShark.c = 0;
    initShark.dir = fishMap[0][0].second;
    cout << teenageShark(initShark, fishMap) << '\n';
}
