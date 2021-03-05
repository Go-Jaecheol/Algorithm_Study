# [13023] ABCDE - C++

## :pushpin: **Algorithm**

그래프 이론, 그래프 탐색, DFS

## :round_pushpin: **Logic**

```c++
int visited[2000];
```

- 방문 여부를 저장하는 배열, -1로 초기화

```c++
void dfs(int idx, int depth)
```

- 그래프의 깊이 정보를 종료조건으로 하고 방문 여부에 따라 재귀적으로 호출되며 그래프를 탐색하는 함수

```c++
while (m != M) {
    int a, b;
    cin >> a >> b;
    v[a].push_back(b);
    v[b].push_back(a);
    visited[m++] = -1;
}
```

- 방향이 없는 그래프이므로 서로에 대한 친구관계임을 나타내기 위해 각각의 배열에 관계 추가

```c++
void dfs(int idx, int depth) {
	if (depth >= 4) {
		cout << "1";
		exit(0);
	}
	depth++;
	visited[idx] = 1;
	for (vector<int>::size_type i = 0; i < v[idx].size(); i++) {
		if (visited[v[idx][i]] == -1)
			dfs(v[idx][i], depth);
	}
	visited[idx] = -1;
	depth--;
}
```

- `depth`는 0부터 시작하여 4 이상이면 즉, **5명의 관계가 이어진다면 종료**됨
- 그렇지 않은 경우, `depth`를 증가시키고 방문 체크한 후 해당`idx`와 이어진 다른 친구를 반복문에서 탐색
  - 방문하지 않은 경우에 대하여 재귀 호출
- 해당 `idx`에 대한 반복문이 끝나고 나면 방문 여부를 초기화하고, `depth`를 다시 감소시킴
  - 해당 코드를 실행하는 경우는 원하는 답이 나오지 않은 경우뿐

## :black_nib: **Review**

- 지금까지 문제 중 문제 이해하는 데에 가장 오래걸렸던 문제
- 지금껏 `vector`는 잘 사용하지 않았었는데 처음으로 사용해본 문제
  - 익숙해진다면 사용하기 좋은 구조인 것 같음
- `dfs`함수의 반복문에서 `vector<int>::size_type i`를 사용하였는데, 백준에서 경고가 뜨길래`v[idx].size()` 와 자료형을 맞춰주기 위해 사용
- 처음에는 `visited`를 동적 할당 배열로 사용했었는데, 계속 `segmentation fault`가 뜨고 원인을 찾기 어려워 그냥 정적 배열로 사용