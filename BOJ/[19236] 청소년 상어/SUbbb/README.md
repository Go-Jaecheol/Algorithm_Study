# [19236] 청소년 상어 - Java

## :pushpin: **Algorithm**

구현, 시뮬레이션, 스택

## :round_pushpin: **Logic**

```java
Node[][] fishes = new Node[4][4];
```

- 좌표별 물고기의 좌표, 번호, 방향을 저장한다.

```java
private static void huntingShark(Node[][] fishes, Node shark, int sum)
```

- 물고기를 이동시키고, 상어가 움직일 수 있는 후보 좌표를 스택에 저장한다.
- 이후 스택이 빌 때까지 상어를 움직여보고 재귀적으로 호출한다.

```java
private static void moveFish(Node[][] fishes)
```

- 1부터 16까지 물고기 번호를 찾으면서, 각 물고기의 방향에 맞게 교체한다.

## :black_nib: **Review**

- 구현, 시뮬레이션을 사용하는 문제니까 ... 하라는 대로 하면 되는데 처음에 떠오르지 않았던 것은 **탐색의 종료가 언제냐**였다.
  - 무조건 모든 물고기를 다 먹을 수 있지 않나 싶었기 때문에
- 하지만 그렇지 않았고 .. 탐색하다보면 더 이상 못 나아가는 경우가 있어서 Stack을 사용해서 다음 탐색할 좌표를 볼때 조건만 잘 확인해주면 종료될 수 밖에 없었다.
- 흠 ... 아쉽