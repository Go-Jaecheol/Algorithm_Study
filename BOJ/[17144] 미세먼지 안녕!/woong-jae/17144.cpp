#include <iostream>
#include <vector>
#include <queue>

using namespace std;
int R, C, T;
int cleaner[2];
int room[51][51];
// Constants
int dr[4] = {0, -1, 0, 1}; // 오른쪽부터 반시계방향
int dc[4] = {1, 0, -1 , 0};
int dr_i[4] = {0, 1, 0, -1}; // 오른쪽부터 시계방향
int dc_i[4] = {1, 0, -1, 0};

int getDust() { // 남아있는 미세먼지 양
    int ret = 0;
    for (int r = 1; r <= R; r++) {
        for (int c = 1; c <= C; c++) {
            if (room[r][c] > 0) ret += room[r][c];
        }
    }
    return ret;
}

void simulateDustCleaner() {
    // 미세먼지 확산
    queue<pair<int, int>> microDusts;
    int nextRoom[51][51] = {0, };
    for (int r = 1; r <= R; r++) { // 미세먼지 있는 칸 확인
        for (int c = 1; c <= C; c++) {
            if (room[r][c] > 0) microDusts.push(make_pair(r, c));
        }
    }
    while(microDusts.size()) {
        int count = 0;
        int amount = room[microDusts.front().first][microDusts.front().second];
        for (int dir = 0; dir < 4; dir++) {
            int nr = microDusts.front().first + dr[dir], nc = microDusts.front().second + dc[dir];
            if (0 < nr && nr <= R && 0 < nc && nc <= C && room[nr][nc] != -1) {
                nextRoom[nr][nc] += amount / 5;
                count++;
            }
        }
        room[microDusts.front().first][microDusts.front().second] = amount - (amount / 5) * count;
        microDusts.pop();
    }
    for (int r = 1; r <= R; r++) {
        for (int c = 1; c <= C; c++) {
            room[r][c] += nextRoom[r][c];
        }
    }
    // 공기청정기 작동
    pair<int, int> next = make_pair(cleaner[0], 1);
    int prev = 0;
    for (int dir = 0; dir < 4 ; dir++) {
        while (1) {
            int nr = next.first + dr[dir], nc = next.second + dc[dir];
            if (0 < nr && nr <= R && 0 < nc && nc <= C && room[nr][nc] != -1) {
                int temp = room[nr][nc];
                room[nr][nc] = prev;
                prev = temp;
                next = make_pair(nr, nc);
            }
            else break;
        }
    }
    next = make_pair(cleaner[1], 1);
    prev = 0;
    for (int dir = 0; dir < 4 ; dir++) {
        while (1) {
            int nr = next.first + dr_i[dir], nc = next.second + dc_i[dir];
            if (0 < nr && nr <= R && 0 < nc && nc <= C && room[nr][nc] != -1) {
                int temp = room[nr][nc];
                room[nr][nc] = prev;
                prev = temp;
                next = make_pair(nr, nc);
            }
            else break;
        }
    }
}

int main() {
    // input
    cin >> R >> C >> T;
    for (int r = 1; r <= R; r++) {
        for (int c = 1; c <= C; c++) {
            cin >> room[r][c];
        }
    }
    // 공기청정기 찾기
    for (int r = 1; r <= R; r++) {
        if (room[r][1] == -1) {
            cleaner[0] = r;
            cleaner[1] = r + 1;
            break;
        }
    }
    
    for (int i = 0; i < T; i++) {
        simulateDustCleaner();
    }
    cout << getDust() << '\n';
}
