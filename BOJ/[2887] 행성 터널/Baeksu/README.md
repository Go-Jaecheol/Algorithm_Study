# [2887] 행성 터널 - C ++

## :pushpin: **Algorithm**

- 그래프 이론, 정렬, 최소 스패닝 트리


## :round_pushpin: **Logic**

```c++
int findParent(int a) {
    if (a == parents[a]) 
        return a;
    return parents[a] = findParent(parents[a]);
}
```

- `parent` 행성을 `return` 하는 함수

```c++
bool unionParent(int a, int b) {
    a = findParent(a);
    b = findParent(b);
    if (a == b) 
        return false;
    if (a > b) 
        parents[a] = b;
    else 
        parents[b] = a;
    return true;
}
```

- `parent`를 비교하여 연결하는 함수

```c++
for (int i = 0; i < N; i++) {
    cin >> a >> b >> c;
    x.push_back({ a, i });
    y.push_back({ b, i });
    z.push_back({ c, i });
}

sort(x.begin(), x.end());
sort(y.begin(), y.end());
sort(z.begin(), z.end());

for (int i = 0; i < N - 1; i++) {
    dist.push_back({ abs(x[i].first - x[i + 1].first), {x[i].second, x[i + 1].second} });
    dist.push_back({ abs(y[i].first - y[i + 1].first), {y[i].second, y[i + 1].second} });
    dist.push_back({ abs(z[i].first - z[i + 1].first), {z[i].second, z[i + 1].second} });
}

sort(dist.begin(), dist.end());

int cnt = 0;
long long cost = 0;

for (int i = 0; i < dist.size(); i++) {
    if (cnt == N - 1)
        break;
    if (unionParent(dist[i].second.first, dist[i].second.second)) {
        cnt++;
        cost += dist[i].first;
    }
}
```

- `x`, `y`, `z`축으로 구분하여 각 `vector`에 저장, 오름차순 정렬
- 각 행성을 연결하는 모든 터널의 비용과, 연결된 행성의 정보를 저장, 오름차순 정렬
- 오름차순 정렬된 `dist`를 모든 행성이 연결되기 전까지 탐색하며 같은 `parent`를 가지지 않는 행성들만 연결하고, 비용 누적합

## :black_nib: **Review**

- 처음에는 각 행성을 연결하는 모든 터널을 저장하고 있는 `vector<pair <int,int>>`를 가지고 **prim algorithm**을 사용하여 해결했는데 **메모리초과**가 발생
- 해결방법을 모르겠어서 블로그 참고 ..