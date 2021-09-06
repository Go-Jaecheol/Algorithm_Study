# [11559] Puyo Puyo
## Algorithm
- BFS
## Logic
1. 필드를 순회하면서 아직 방문하지 않은 뿌요를 찾는다.
2. 뿌요가 체인이 만들어지는지 확인한다.
  - 체인이 만들어지면 그 뿌요들을 '.'으로 바꿔준다.
3. 체인이 존재했다면, 뿌요들이 중력의 영향을 받아 내려오게 해준다.
4. 체인이 존재하지 않을 때까지 반복
```cpp
int getChain() {
    int res = 0;
    while (1) {
        bool foundChain = false;
        vector<vector<bool>> visited(12, vector<bool> (6));
        for (int r = 0; r < 12; r++) {
            for (int c = 0; c < 6; c++) {
                if (field[r][c] != '.' && !visited[r][c]) {
                    queue<pair<int, int>> q;
                    vector<pair<int, int>> st;
                    int count = 1;
                    char color = field[r][c];
                    
                    q.push(make_pair(r, c));
                    st.push_back(make_pair(r, c));
                    visited[r][c] = true;
                    while (q.size()) {
                        pair<int, int> cur = q.front();
                        
                        for (int dir = 0; dir < 4; dir++) {
                            int nr = cur.first + dr[dir], nc = cur.second + dc[dir];
                            if (0 <= nr && nr < 12 && 0 <= nc && nc < 6 && field[nr][nc] == color && !visited[nr][nc]) {
                                q.push(make_pair(nr, nc));
                                visited[nr][nc] = true;
                                st.push_back(make_pair(nr, nc));
                                count++;
                            }
                        }
                        q.pop();
                    }
                    
                    if (count >= 4) { // 연쇄 발견
                        foundChain = true;
                        for (int i = 0; i < st.size(); i++) {
                            pair<int, int> cur = st[i];
                            field[cur.first][cur.second] = '.';
                        }
                    }
                }
            }
        }
        if (foundChain) {
            adjustPuyo();
            res++;
        }
        else break;
    }
    
    
    return res;
}
```
## Review
쉽지만 귀찮은 문제. 문제가 설명한 규칙대로 차근차근 구현하면 풀 수 있다.
