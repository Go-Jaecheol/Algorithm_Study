# [1781] 컵라면 - C ++

## :pushpin: **Algorithm**

자료구조, 그리디 알고리즘, 분리 집합

## :round_pushpin: **Logic**

```c++
for (int i = 0; i < P; i++) {
    int x;
    cin >> x;
    int gate = find(x);
    if (gate == 0)
        break;
    union_set(gate, gate - 1);
    ans++;
}

int find(int i) {
    if (parent[i] == i)
        return i;
    return parent[i] = find(parent[i]);
}

void union_set(int i, int j) {
	i = find(i);
	j = find(j);
	parent[i] = j;
}
```

- 입력받은 수까지의 게이트 중 하나의 게이트를 배정하고, `gate` 와 `gate - 1`를 합침
  - **왜 합치는지 이해 안됨 ..**
- `gate`가 없는 경우 종료

## :black_nib: **Review**

- **분리 집합**을 다루는 문제를 처음 봄
- 분리 집합 알고리즘과 리드미를 보면서 따라해본 문제 ... 아직 잘 이해가 안된다
- 시간 내서 분리 집합 기초 문제부터 해봐야 감이 잡힐 것 같음