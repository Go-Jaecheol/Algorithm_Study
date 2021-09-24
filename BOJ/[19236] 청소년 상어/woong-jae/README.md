# [19236] 청소년 상어
## Algorithm
- Simulation
## Logic
### 물고기 움직이기
물고기의 움직임을 효율적으로 구현하기 위해 **'map'** 자료형을 사용했다.

'map'은 key를 자동으로 오름차순으로 정렬해주고, 물고기의 위치를 key로 관리할 수 있어 효율적이다. 

특히, 물고기를 차례차례 움직이기 때문에 i번 물고기를 움직일 때는 그 물고기의 위치가 달라졌 수도 있다. 'map'을 사용하지 않으면 전체 배열을 뒤져서 물고기의 위치를 얻어야 한다.
```cpp
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
```
### 상어 움직이기
이동할 수 있으면 가고, 아니면 안가면 된다. 모든 경우의 수를 확인해야하기 때문에, 재귀로 가장 작은 값을 가져온다.
```cpp
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
```
## Review
'map' 자료형을 새로 알게됐다. 아직 모르는게 너무 많은 것 같다. 물고기의 위치를 어떻게 관리하는지가 핵심인 문제같다.
