# [4485] 녹색 옷 입은 애가 젤다지? - C++

## :pushpin: **Algorithm**

그래프 이론, 다익스트라

## :round_pushpin: **Logic**

```c++
vector <vector <int>> map;
vector <vector <int>> dist;
```

- 입력받은 지도 정보를 저장할 `map` 배열과 `map` 배열에서 각각 위치로의 최소 비용을 저장하는 `dist` 배열

```c++
typedef struct xyw {
	int x, y, w;
} xyw;

struct cmp {
	bool operator() (xyw a, xyw b) {
		if (a.w == b.w)
			return a.x + a.y < b.x + b.y;
		return a.w > b.w;
	}
};
```

- 우선순위 큐 사용 시, 좌표와 가중치 값을 함께 저장하기 위해 필요한 자료형과 해당 자료형을 가중치 기준 오름차순으로 저장하기 위한 사용자 정의 연산자 선언

```c++
int thief_rupee() {
	priority_queue<xyw, vector <xyw>, cmp> pq;
	pq.push({ 0, 0, map[0][0] });

	while (!pq.empty()) {
		int now_x = pq.top().x, now_y = pq.top().y, now_w = pq.top().w;
		pq.pop();

		for (int i = 0; i < 4; i++) {
			int nx = now_x + x_ary[i], ny = now_y + y_ary[i];
			if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if (dist[nx][ny] > map[nx][ny] + now_w) {
					dist[nx][ny] = map[nx][ny] + now_w;
					pq.push({ nx,ny,dist[nx][ny] });
				}
			}
		}
	}

	return dist[n - 1][n - 1];
}
```

- 출발점에서 도착점까지 가는 모든 좌표에 대한 최단 거리를 계산하는 함수
- 우선순위 큐를 이용하여 4방향 중 가장 최소의 `rupee`를 빼앗기는 좌표와 해당 값을 `push`

## :black_nib: **Review**

- 처음 사용한 방법은 `BFS` 문제 풀듯이 `queue`에 현 지점에서 갈 수 있는 4방향을 모두 확인하며 가장 최솟값을 가지는 좌표와 해당 값을 더하여 종점에 도착했을 때 `while`문을 탈출하는 방식이었으나, **50%**에서 **시간초과**가 떴고, **우선순위 큐**를 이용하는 방법으로 방문여부 또한 사용하지 않아 시간초과에서 탈출
- 구조체의 유용성을 많이 깨달은 문제 ... 그전엔 `pair`를 여러 개 사용해서 `x`, `y`, `weight`를 저장해야 하나 .. 했지만 구조체를 이용하여 쉽게 저장하고 정렬할 수 있었음