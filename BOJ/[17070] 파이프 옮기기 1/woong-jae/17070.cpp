#include <iostream>
#include <cstring>

using namespace std;
int n;
int cache[17][17][3];
int house[17][17];

// state는 파이프의 가로(0), 대각선(1), 세로(2) 상태를 나타낸다.
int total_move(int cur_r, int cur_c, int state) {
    if (cur_r == n && cur_c == n) return 1;
    int &ret = cache[cur_r][cur_c][state];
    if (ret != -1) return ret;
    
    ret = 0;
    switch (state) {
        case 0:
            if (cur_c + 1 <= n && house[cur_r][cur_c + 1] != 1) ret += total_move(cur_r, cur_c + 1, 0);
            if (cur_r + 1 <= n && cur_c + 1 <= n && house[cur_r + 1][cur_c + 1] != 1 && house[cur_r][cur_c + 1] != 1 && house[cur_r + 1][cur_c] != 1) ret += total_move(cur_r + 1, cur_c + 1, 1);
            break;
        case 1:
            if (cur_c + 1 <= n && house[cur_r][cur_c + 1] != 1) ret += total_move(cur_r, cur_c + 1, 0);
            if (cur_r + 1 <= n && house[cur_r + 1][cur_c] != 1) ret += total_move(cur_r + 1, cur_c, 2);
            if (cur_r + 1 <= n && cur_c + 1 <= n && house[cur_r + 1][cur_c + 1] != 1 && house[cur_r][cur_c + 1] != 1 && house[cur_r + 1][cur_c] != 1) ret += total_move(cur_r + 1, cur_c + 1, 1);
            break;
        case 2:
            if (cur_r + 1 <= n && house[cur_r + 1][cur_c] != 1) ret += total_move(cur_r + 1, cur_c, 2);
            if (cur_r + 1 <= n && cur_c + 1 <= n && house[cur_r + 1][cur_c + 1] != 1 && house[cur_r][cur_c + 1] != 1 && house[cur_r + 1][cur_c] != 1) ret += total_move(cur_r + 1, cur_c + 1, 1);
            break;
        default:
            break;
    }
    
    return ret;
}

int main() {
    cin >> n;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            cin >> house[i][j];
        }
    }
    memset(cache, -1, sizeof(cache));
    cout << total_move(1, 2, 0) << '\n';
}
