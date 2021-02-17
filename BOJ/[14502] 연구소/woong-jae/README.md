# [14502] 연구소
## 💡Algorithm

그래프, BFS, Brute Force

## 💡Logic

문제를 크게 세 부분으로 나눴다.

1. 벽 3개를 세우기
2. 바이러스를 퍼뜨리기
3. 안전 구역 구하기

처음에 그래프를 입력받을 때 추가로 안전 구역과 바이러스가 있는 구역을 따로 safe와 virus에 저장했다. 벽을 세울 때 safe를 사용한다. 안전 구역에만 벽을 세울 수 있기 때문이다. 그리고 바이러스를 퍼뜨릴 때 virus를 사용한다.

### 벽 3개 세우기

벽을 세우는 것은 Brute Force로 구현했다. 삼중 for문으로 전체를 순회한다(완전 탐색).
```c++
int putWall(vector<vector<int>>& map) {
    int res = 0;
    
    for(int i = 0; i < safe.size(); i++) {
        map[safe[i].first][safe[i].second] = 1;
        for(int j = i + 1; j < safe.size(); j++) {
            map[safe[j].first][safe[j].second] = 1;
            for(int k = j + 1; k < safe.size(); k++) {
                map[safe[k].first][safe[k].second] = 1;
                res = max(res, spreadVirus(map));//3개를 세웠으니 바이러스를 퍼뜨린다.
                map[safe[k].first][safe[k].second] = 0;
            }
            map[safe[j].first][safe[j].second] = 0;
        }
        map[safe[i].first][safe[i].second] = 0;
    }
    
    return res;
}
```
### 바이러스 퍼뜨리기

BFS를 사용해서 바이러스가 있는 구역을 모두 돌면서 바이러스를 퍼뜨린다. 바이러스를 다 퍼뜨리면 "getSafeArea()" 함수를 사용해서 안전 구역의 넓이를 구해 반환한다.

```
int spreadVirus(vector<vector<int>>& copy) {
    vector<vector<int>> map(copy);
    queue<pair<int, int>> st;
    
    for(int i = 0; i < virus.size(); i++) {
        st.push(pair<int, int> (virus[i].first, virus[i].second));
        while(st.size()) {
            for(int k = 0; k < 4; k ++) {
                int nr = st.front().first + x[k], nc = st.front().second + y[k];
                if(0 <= nc && nc < m && 0 <= nr && nr < n && map[nr][nc] == 0) {
                    st.push(pair<int, int> (nr, nc));
                    map[nr][nc] = 2;
                }
            }
            st.pop();
        }
    }
    
    return getSafeArea(map);
}
```

## 💡Review

다른 부분보다 벽 세우는 부분을 어떻게 구현할지 생각이 안나서 오래 걸렸다. 제일 쉽게 구현했어야 할 부분인 것 같은데...

원래 그래프에서 좌표를 저장할 때 구조체를 선언했었다. 이 문제를 풀면서 "pair" 라는 좋은 것을 발견했다ㅎㅎ.
