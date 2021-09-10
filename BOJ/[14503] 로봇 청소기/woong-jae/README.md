# [14503] 로봇 청소기
## Algorithm
- Simulation
## Logic
왼쪽으로 도는 것을 구현하는 것이 핵심인 것 같다.

배열 `dr`, `dc`의 인덱스 '0 1 2 3'에 '북 동 남 서'를 매핑했다.
현재 방향을 `dir`라고 한다면, 왼쪽을 `(dir + 3) & 4`, 그리고 뒤를 `(dir + 3) % 4`로 표현할 수 있다.

위에 표현한 방법으로 왼쪽을 확인한다. 청소할 공간이 있으면 왼쪽으로 가면 된다.
왼쪽에 청소할 공간이 없으면 회전시키고 `spinCount`를 증가시키다, `4`가 되면 한 바퀴 돌았다는 뜻이므로 뒤로 가거나 종료시키면 끝이다.
```cpp
int clean() {
    int ret = 1;
    int dr[4] = {-1, 0, 1, 0};
    int dc[4] = {0, 1, 0, -1};
    int spinCount = 0;
    
    area[r][c] = -1;
    pair<pair<int, int>, int> cur = make_pair(make_pair(r, c), d);
    while (1) {
        pair<int, int> left = make_pair(cur.first.first + dr[(cur.second + 3) % 4], cur.first.second + dc[(cur.second + 3) % 4]);
        if (spinCount == 4) { // 한 바퀴 돌았음
            pair<int, int> behind = make_pair(cur.first.first + dr[(cur.second + 2) % 4], cur.first.second + dc[(cur.second + 2) % 4]);
            if (0 <= behind.first && behind.first < N && 0 <= behind.second && behind.second < M) {
                if (area[behind.first][behind.second] != 1) { // 뒤에 뚫려있으면 이동
                    cur.first = behind;
                    spinCount = 0;
                }
                else { // 막혀있음 -> 종료
                    break;
                }
            }
        }
        // 왼쪽에 청소할 곳 있음
        else if (0 <= left.first && left.first < N && 0 <= left.second && left.second < M && area[left.first][left.second] == 0) {
            area[left.first][left.second] = -1;
            ret++;
            spinCount = 0;
            cur = make_pair(left, (cur.second + 3) % 4);
        }
        else { // 청소할 곳 없음 -> 회전
            cur.second = (cur.second + 3) % 4;
            spinCount++;
        }
    }
    
    return ret;
}
```
## Review
문제를 잘 읽고 시키는 대로 구현하면 어렵지 않게 풀 수 있는 문제. 왼쪽을 확인하는 방법을 정돈화 하지 않으면 코드가 복잡해져서 실수가 나올 수도 있겠다고 생각했다.
