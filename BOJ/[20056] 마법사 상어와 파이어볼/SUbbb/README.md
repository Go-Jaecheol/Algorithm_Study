# [20056] 마법사 상어와 파이어볼 - Java

## :pushpin: **Algorithm**

구현, 시뮬레이션

## :round_pushpin: **Logic**

```java
while(K > 0) {
  ballList = new ArrayList[N + 1][N + 1];
  moveFireBalls();
  
  for (int i = 1; i <= N; i++) {
    for (int j = 1; j <= N; j++) {
      List<FireBall> list = ballList[i][j];
      // null이면 파이어볼이 없는 경우
      if (list == null) continue;
      // 파이어볼이 하나만 있는 경우
      else if (list.size() == 1)
        queue.add(list.get(0));
      // 파이어볼이 2개 이상인 경우
      else
        spreadBalls(list);
    }
  }
  K--;
}
```

- 주요 로직이다.
- 파이어볼은 큐에 담겨있다.
  - `moveFireBalls()`에서 큐에 있는 파이어볼을 하나씩 꺼내 이동시킨다.
  - 이때 `List<>[][]`에 파이어볼을 저장한다. 
- 이제 `List<>[][]`를 탐색하면서, 리스트의 사이즈에 따라 파이어볼이 한 개인지 여러 개인지 판단하여 파이어볼을 분산시키거나 한다.

```java
int nx = x + dir[d][0] * (s % N);
int ny = y + dir[d][1] * (s % N);

// 범위 밖인 경우 처리
if (nx > 0) nx %= N;
if (ny > 0) ny %= N;
if (nx <= 0) nx = N - Math.abs(nx);
if (ny <= 0) ny = N - Math.abs(ny);
```

- 가장 이해하지 못했던 범위를 벗어나는 경우에 대한 연산이다.
- 솔직히 모듈러 연산은 잘 이해가 안되고, 직관적이지 않다고 생각한다.
- 따라서 하나씩 옮겨가면서 벗어나는 경우 1이나 N으로 돌려주는 연산을 택하는 것이 이해는 빠를 것 같다.

## :black_nib: **Review**

- 삼성 기출 문제라고 해서 많이 걱정하고 푼 문제
- 아이디어는 쉬웠다. 근데 파이어볼 이동 시 되도 않는 순환 큐 형태로 돌리라는 설명이 문제 다 푼 지금까지도 이해가 되지 않았다.