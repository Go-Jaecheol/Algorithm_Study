# [14891] 톱니바퀴
## Algorithm
- Simulation
## Logic
회전 시킨 방법에서 얻는 톱니바퀴부터 시작해서 왼쪽과 오른쪽 톱니바퀴에 어떤 영향을 미치는지 확인하는 것을 총 회전 수만큼 반복한다.

그 다음 점수를 계산하면 된다.
```cpp
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
```
## Review
문제에서 말한 그대로를 구현하면 아주 쉽게 풀 수 있다. 시뮬레이션 문제는 구현 방향만 잘 생각하면 쉽게 풀 수 있는 것 같다.
