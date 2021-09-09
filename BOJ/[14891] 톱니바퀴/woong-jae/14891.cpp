#include <iostream>
#include <string>
#include <utility>
#include <vector>
#include <queue>

using namespace std;

int K;
string gears[4];
vector<pair<int, int>> spin_dir;

void spinGears(int idx, int dir) {
    queue<pair<int, int>> q;
    vector<pair<bool, int>> isSpin(4);
    
    // 오른쪽
    isSpin[idx] = make_pair(true, dir);
    for (int r = idx + 1; r < 4; r++) {
        if (gears[r - 1][2] != gears[r][6]) isSpin[r] = make_pair(true, -isSpin[r - 1].second);
        else break;
    }
    // 왼쪽
    for (int l = idx - 1; l >= 0; l--) {
        if (gears[l + 1][6] != gears[l][2]) isSpin[l] = make_pair(true, -isSpin[l + 1].second);
        else break;
    }
    for (int i = 0; i < 4; i++) {
        if (isSpin[i].first) {
            if (isSpin[i].second == 1) { // 시계방향
                gears[i] = gears[i].back() + gears[i].substr(0, 7);
            }
            else { // 반시계방향
                gears[i] = gears[i].substr(1) + gears[i].front();
            }
        }
    }
}

int getScore() {
    int res = 0;
    int score[4] = {1, 2, 4, 8};
    
    for (int i = 0; i < 4; i++) {
        if (gears[i][0] == '1') res += score[i];
    }
    
    return res;
}

int main() {
    for (int i = 0; i < 4; i++) {
        cin >> gears[i];
    }
    cin >> K;
    for (int i = 0; i < K; i++) {
        int idx, dir;
        cin >> idx >> dir;
        spin_dir.push_back(make_pair(idx - 1, dir));
    }
    
    for (int i = 0; i < spin_dir.size(); i++) {
        spinGears(spin_dir[i].first, spin_dir[i].second);
    }
    cout << getScore() << '\n';
}
