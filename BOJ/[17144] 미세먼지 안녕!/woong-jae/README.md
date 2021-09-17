# [17144] 미세먼지 안녕!
## Algorithm
- Simulation
## Logic
1. 미세먼지 확산
미세먼지 확산할 때 중요한 것은 동시에 확산되어야 한다는 것이다. 그렇기 때문에 확산된 먼지를 다른 공간에 저장했다가 계산이 다 끝난 후 원래 방에 적용시켜 줘야한다.
```cpp
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
```
2. 공기청정기 작동
문제에 나와있는 그대로 구현하면 된다.
```cpp
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
```
## Review
어려운 문제는 아니고 좀 귀찮은 문제. 공기청정기 작동 방향을 위 아래 반대로 해놔서 살짝 해맸다.

