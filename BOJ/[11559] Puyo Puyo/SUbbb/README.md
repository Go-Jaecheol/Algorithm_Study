# [11559] Puyo Puyo - Java

## :pushpin: **Algorithm**

구현, 그래프 이론, 그래프 탐색, BFS, 시뮬레이션

## :round_pushpin: **Logic**

```java
class Puyo {
    char[][] field = new char[12][6];
    int[] x_ary = { -1, 0, 1, 0 };
    int[] y_ary = { 0, 1, 0, -1 };
    List<Pair> remove;
    Queue<Pair> queue;
    int[][] visited;

    ...

}
```
- 뿌요의 필드를 관리하기 위한 클래스를 생성한다.

```java
public boolean searchChains();
```

- BFS방식으로 필드에 발생가능한 연쇄가 있는지 탐색한다.
- 터질 수 있는 뿌요를 `List<Puyo> remove` 에 저장하여, 연쇄 발생 시 해당 뿌요들을 제거할 수 있게 한다.

```java
private void updateField();
```

- 연쇄 탐색 이후, 발생한 연쇄가 있는 경우에만 필드를 업데이트하기 위해 호출되는 메소드이다.

## :black_nib: **Review**

- 주어진 상황에서, 먼저 연쇄가 일어날 수 있는지 파악한다. 여러 개의 연쇄가 가능하다면, 어느 우선순위로 연쇄를 발생시킬지를 고민했다.
  - 생각해보니 연쇄간의 우선순위는 중요하지 않았고, 연쇄 발생 이후 해당 뿌요들을 어떻게 제거하는가가 더 중요했다.
- 연쇄 발생 가능한 뿌요들을 탐색과 동시에 제거할 방법이 없기에 리스트에 저장하면서 연쇄가 발생하는 경우에만 이를 제거하는 방식을 참고하여 해결했다.