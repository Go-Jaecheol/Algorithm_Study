# [16234] 인구 이동 - C++

## :pushpin: **Algorithm**

구현, 그래프 이론, 그래프 탐색, BFS, 시뮬레이션

## :round_pushpin: **Logic**

```c++
int migration() {
	int visited[50][50] = { 0, }, move_cnt = 0;

	for (int x = 0; x < N; x++) {
		for (int y = 0; y < N; y++) {
			if (visited[x][y] != 1) {
				queue <pair <int, int>> q, s;
				int people = map[x][y];
				visited[x][y] = 1;
				q.push(make_pair(x, y));
				s.push(make_pair(x, y));

				while (!q.empty()) {
					int cur_x = q.front().first, cur_y = q.front().second;
					q.pop();
					for (int i = 0; i < 4; i++) {
						int nx = x_way[i] + cur_x, ny = y_way[i] + cur_y;
						if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
							if (visited[nx][ny] != 1) {
								if (abs(map[nx][ny] - map[cur_x][cur_y]) >= L && abs(map[nx][ny] - map[cur_x][cur_y]) <= R) {
									visited[nx][ny] = 1;
									people += map[nx][ny];
									q.push(make_pair(nx, ny));
									s.push(make_pair(nx, ny));
								}
							}
						}
					}
				}
				if (s.size() >= 2) {
					int div = s.size();
					move_cnt++;
					while (!s.empty()) {
						int x = s.front().first, y = s.front().second;
						map[x][y] = people / div;
						s.pop();
					}
				}
			}
		}
	}
	return move_cnt;
}
```

- `visited`를 0으로 초기화하고,  방문하지 않은 나라에 대하여 주위 나라와 연합이 가능한지 판단
  - 가능한 경우
    - 주위 나라에 방문 체크, 인구 수 합산
    - `BFS` 탐색을 위해 `queue <pair <int, int>> q`에 좌표 저장
    - 탐색이 끝난 후 인구 이동을 위한 좌표 확인을 위해 `queue <pair <int, int>> s`에 좌표 저장
- `queue s`에 저장된 나라가 2개 이상이라면 인구 이동을 해야 하므로 `map`변경
- 그렇지 않다면 값이 `0`인 `move_cnt`가 리턴되고, 메인 함수에서 `migration`함수가 종료되는 조건이 됨

## :black_nib: **Review**

- **아기 상어**와 같은 시뮬레이션 문제
- 푸는 방법은 돌려보고 상태 확인해서 더 돌릴지 말지 결정하는 느낌..?
  - 그 과정에서 `BFS`사용하는 문제
- 아이디어는 생각보다 금방 잡았지만 결국 코딩으로 구현하는 것에서 막혀 리드미를 참고하였음 ..
- 함수 사용할 때 `void`형 보단 `int`형에 친숙해지자
