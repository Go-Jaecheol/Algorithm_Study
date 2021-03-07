# [17142] 연구소 3 - C++

## :pushpin: **Algorithm**

그래프 이론, 그래프 탐색, BFS

## :round_pushpin: **Logic**

```c++
void covid(int idx, int virus);
```

- 재귀호출을 이용해 바이러스 중 입력받은 `M` = `virus`개의 활성 바이러스를 선택
- 모두 선택하였다면 각각의 활성 바이러스를 기점으로 바이러스를 퍼뜨리는 `spreadoout` 함수 호출
- 바이러스가 퍼진 후 퍼지는 데 걸리는 시간을 리턴해주고, `visited`배열을 초기화해주는 `map_set`함수 호출
- `map_set`에서 리턴된 시간이 최소 시간인지 확인

```c++
void spreadout(int x, int y) {
	queue <pair<int, int> > q;
	q.push(make_pair(x, y));
	pair<int, int> cur;

	while (!q.empty()) {
		cur = q.front();
		q.pop();
		for (int j = 0; j < 4; j++) {
			pair<int, int> next = make_pair(cur.first + x_ar[j], cur.second + y_ar[j]);

			if (next.first >= 0 && next.first < N && next.second >= 0 && next.second < N) {
				if (map[next.first][next.second] == 0) {
					if (visited[next.first][next.second] == 0) {
						q.push(make_pair(next.first, next.second));
						visited[next.first][next.second] = visited[cur.first][cur.second] + 1;
					}
					else if (visited[next.first][next.second] != visited[cur.first][cur.second]) {
						q.push(make_pair(next.first, next.second));
						visited[next.first][next.second] = min(visited[cur.first][cur.second], visited[next.first][next.second]) + 1;
					}
				}
			}
		}
	}
}
```

- 입력받은 좌표를 기점으로 `q`에 삽입하고 `BFS`방식으로 `0`인 좌표를 탐색하며 바이러스가 퍼지는 데 걸리는 시간을 `visited` 에 저장
  - 이때, 어떠한 조건으로 값을 저장해야 할지가 관건 ...

## :black_nib: **Review**

- 풀 수 있을 것 같은데 자꾸 어떤 한 조건에서 걸려서 수정을 반복하는 중
- 시간이 좀 더 있었으면 이번 주 안에 풀 수 있었을 것 같은데 앞 문제들에서 시간을 너무 많이 써버렸음
- 좀만 기다려 ...