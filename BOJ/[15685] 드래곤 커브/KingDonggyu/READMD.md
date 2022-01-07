# [15685] 드래곤 커브 - Python

## :mag: Algorithm

Simulation

## :round_pushpin: Logic

```python
def set_dragon_curve():
    direction = {0: (0, 1), 1: (-1, 0), 2: (0, -1), 3: (1, 0)}  # 우, 상, 좌, 하
    for x, y, start_d, g in dragon_curve:
        grid[y][x] = 1
        d_info = [[start_d]]
        for i in range(g+1):
            d_temp = []
            for d in reversed(d_info[i]):
                y += direction[d][0]
                x += direction[d][1]
                grid[y][x] = 1
                if d == 3: d = 0
                else: d += 1
                d_temp.append(d)
            if i != 0: d_temp = d_info[i] + d_temp
            d_info.append(d_temp)
    print(find_square())
```

`d_info` 리스트에 1세대부터 `g` 세대까지의 드래곤 커브의 모든 방향 정보를 담는다.

- 예를 들어, `start_d`(시작 방향)가 0, `g`(세대)가 4일 경우 `d_info`는 아래와 같다.

```python
# 0: 우, 1: 상, 2: 좌, 3: 하
[[0], [1], [1, 2], [1, 2, 3, 2], [1, 2, 3, 2, 3, 0, 3, 2]]
```

- 즉, **이전 세대의 방향 정보 + 역순으로 업데이트한 방향 정보** 를 뜻한다.

- **방향만 알면 다음 세대의 드래곤 커브를 표현할 수 있다.**

## :memo: Review

이 문제의 핵심은 **드래곤 커브를 90도로 회전하여 끝 점에 붙이는 것을 어떻게 구현하느냐** 이다.

예제1에 관하여 그림을 그려보니 **방향만 알면 다음 세대의 드래곤 커브를 구현할 수 있다**는 것을 금방 알 수 있었고, 이를 적용하여 문제를 금방 해결할 수 있었다.
