# [15685] 드래곤 커브
## Algorithm
- Simulation
## Logic
기존 방향에서 90도 방향을 트는 것이기 때문에, 시계 방향이든 반시계 방향이든 4개짜리 배열로 표현하면 패턴을 찾을 수 있을 것 같았다.
### 패턴
현재 드래곤 커브 끝 점에서 거꾸로 가면서 새로운 드래곤 커브를 만들 수 있다.
`(이전 점에서 현재 점으로의 방향 + 3) % 4`를 하면 다음 점을 알 수 있다.
이것을 반복하면 새로운 세대의 드래곤 커브를 만들 수 있다.
```cpp
void drawDragonCurve(dragonCurve cur) {
    vector<pair<int, int>> dots;
    
    dots.push_back(make_pair(cur.y, cur.x));
    map[dots.back().first][dots.back().second] = 1;
    dots.push_back(make_pair(cur.y + dr[cur.d], cur.x + dc[cur.d]));
    map[dots.back().first][dots.back().second] = 1;
    for (int i = 1; i <= cur.g; i++) { // 몇 세대
        int size = (int)dots.size() - 1;
        for (int i = size; i > 0; i--) { // 이번 세대 드래곤 커브 그리기
            int nr = dots[i - 1].first - dots[i].first, nc = dots[i - 1].second - dots[i].second;
            
            for (int dir = 0; dir < 4; dir++) { // 다음 점 찾기
                if (dr[dir] == nr && dc[dir] == nc) {
                    dots.push_back(make_pair(dots.back().first + dr[(dir + 3) % 4], dots.back().second + dc[(dir + 3) % 4]));
                    map[dots.back().first][dots.back().second] = 1;
                    break;
                }
            }
        }
    }
}
```
## Review
말이 주저리 주저리 긴 것에 비해 어렵지 않았던 문제. 
드래곤 커브를 그릴 때 90도 꺾는 거에서 패턴이 있을 거란걸 알아차리는게 중요한 듯.
점점 시뮬레이션에 익숙해져간다!
