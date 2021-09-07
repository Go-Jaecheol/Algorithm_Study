# [17471] 게리맨더링
## Algorithm
- BFS
- Combination
## Logic
1. 선거 구역을 두 개로 나눈다.
 
2. 선거 구역이 인접한지 확인한다.
    - 인접하다면 두 선거 구역의 인구차이를 얻는다.
### 선거 구역 나누기
조합을 사용해서 구역을 나눌 수 있다. cpp에서 제공하는 `next_permutation`을 사용하면 쉽게 조합을 구할 수 있다. 

`next_permutation`을 호출하면, 순열을 구하고 싶은 배열의 다음 순열을 구하고 `true`를 반환한다. 다음 순열이 없으면 `false`를 반환한다.
```cpp
int getMin() {
    int ret = -1;
    
    for (int k = 1; k < N; k++) {
        vector<int> num(N), perm(N);
        for (int i = 0; i < N; i++) {
            num[i] = i + 1;
        }
        for (int i = N - k; i < N; i++) {
            perm[i] = 1;
        }
        
        do {
            int area1_cnt = bfs(perm, 1); // bfs로 인접한지 확인
            int area2_cnt = bfs(perm, 0);
            
            if (area1_cnt == k && area2_cnt == N - k) { // 인접하면 인구 차이 구하기
                int area1_pop = 0, area2_pop = 0;
                
                for (int i = 0; i < N; i++) {
                    if (perm[i] == 1) area1_pop += population[i + 1];
                    else area2_pop += population[i + 1];
                }
                
                if (ret == -1) ret = abs(area1_pop - area2_pop);
                else ret = min(ret, abs(area1_pop - area2_pop));
            }
        } while(next_permutation(perm.begin(), perm.end()));
    }
    
    return ret;
}
```

### BFS로 인접한지 확인
BFS로 인자로 넘겨준 지역에 해당하는 구역을 순회해서 방문한 숫자를 리턴해준다. 방문한 숫자와 선거 구역의 구역 수를 비교해서 인접한지 여부를 확인할 수 있다.
```cpp
int bfs(vector<int>& perm, int area) {
    int count = 1;
    queue<int> q;
    vector<bool> visited(N + 1);
    
    int start = 0;
    for (int i = 0; i < N; i++) {
        if (perm[i] == area) {
            start = i + 1;
            break;
        }
    }
    
    q.push(start);
    visited[start] = true;
    while (q.size()) {
        int cur = q.front();
        
        for (int i = 0; i < adj_list[cur].size(); i++) {
            int next = adj_list[cur][i];
            if (perm[next - 1] == area && !visited[next]) {
                q.push(next);
                visited[next] = true;
                count++;
            }
        }
        
        q.pop();
    }
    
    return count;
}
```
## Review
문제 푸는데 첫 번째 과정인 선거 구역을 나누는 부분에서 굉장히 애먹었다. 조합으로 나누면 될 것 같은건 알았는데, 구현을 못해서 막혀있었다. 그래도 덕분에 `next_permutation`이라는 신기한 함수를 배웠다.
머리가 아프다... 흑흑
