# [2668] 숫자고르기
## 💡Algorithm

그래프, DFS, 사이클 찾기

## 💡Logic

숫자를 뽑아보면, 순환되는 구간이 생성되는 경우 첫째 줄과 둘째 줄의 수의 집합이 같아진다. 이 순환되는 구간을 구하려면 어디에서 cycle이 형성되는지 알아내면 된다.

```visited``` 배열에 이때까지 방문한 노드를 저장하고 ```check``` 배열에 현재 탐색 중에 방문한 노드를 저장한다. 아직 방문하지 않은 노드에서 시작해서 DFS로 방문하지 않은 노드를 돌면서 ```check``` 에 들어있는 노드를 다시 방문하게 되면 cycle이 된다.

아래 함수는 cycle이 발견되는 시점의 노드를 반환한다.

```c++
int check_cycle(int s) {
    vector<int> v;
    int check[101] = {0, };
    v.push_back(s);
    check[s] = 1;
    visited[s] = 1;
    while(v.size()) {
        int cur = v.back();
        v.pop_back();
        for (int i = 1; i <= n; i++) {
            if (graph[cur][i] == 1) {
                if (check[i] == 1) {//cycle 발견
                    return i;
                }
                if (visited[i] != 1) {
                    v.push_back(i);
                    check[i] = 1;
                    visited[i] = 1;
                }
                break;
            }
        }
    }
    return 0;
}
```

그리고 이 노드부터 다시 이 노드가 나올 때까지 DFS를 돌면서 숫자를 저장하면 원하는 값을 얻을 수 있다.

```c++
void getNum(vector<int>& res, int start, int compare) {
    res.push_back(start);
    for (int i = 1; i <= n; i++) {
        if (graph[res.back()][i] == 1 && res.at(compare) != i) {
            getNum(res, i, compare);
        }
    }
}
```

## 💡Review

사이클 찾기를 너무 오랜만에 해서 어떻게 짜야할지 몰라 우왕좌왕했다.

맨날 단순 순회 문제를 풀다가 이런 문제를 만나니 신기했다.
