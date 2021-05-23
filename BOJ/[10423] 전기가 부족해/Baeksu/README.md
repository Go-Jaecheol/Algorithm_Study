# [10423] 전기가 부족해 - C ++

## :pushpin: **Algorithm**

- 그래프 이론, 최소 스패닝 트리


## :round_pushpin: **Logic**

```c++
struct graph {
	int x;
	int y;
	int w;
};
```

- cable정보를 좀 쉽게 사용하기 위해 구조체 선언

```c++
bool checkParent(int a, int b) {
	int r1 = getRoot(a);
	int r2 = getRoot(b);
	if ((r1 == r2) || (generator[r1] && generator[r2]))
		return true;
	return false;
}
```

- 각자의 `root`가 동일하거나, 둘 다 발전소가 위치한 지역이라면 연결되면 안되기에 필요한 조건
- `false`인 경우 `unionParent`를 수행

```c++
void unionParent(int a, int b) {
	int r1 = getRoot(a);
	int r2 = getRoot(b);
	
	if (r1 == r2)
		return;
	if (generator[r1])
		parent[r2] = r1;
	else if (generator[r2])
		parent[r1] = r2;
	else
		parent[r2] = r1;
}
```

- 발전소가 위치한 지역을 우선적으로 `root`로 지정해야 하기에 이에 대한 조건

## :black_nib: **Review**

- 이번주차 제일 어려웠던 문제
- 처음으로 **Kruskal Algorithm**을 이용, 기본 개념을 이해하니 이 문제에 대한 응용 조건만 추가하면 되는 거였음..