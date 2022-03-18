# [3190] 뱀 - Java

## :pushpin: **Algorithm**

구현, 시뮬레이션, 자료구조, 덱, 큐

## :round_pushpin: **Logic**

```java
class Info {
    int second;
    char direction;

    public Info (int second, char direction) {
        this.second = second;
        this.direction = direction;
    }
}
```

- 뱀의 방향 전환 정보를 저장하는 클래스

```java
class Dummy {
    Info[] infos;
    Queue<Pair> queue = new LinkedList<>();
    int[][] map;
    int[] rangeX = { -1, 0, 1, 0 };
    int[] rangeY = { 0, 1, 0, -1 };
    int mapSize;
    int directionChanges;
    int count = 0;
    int infoIdx = 0;
    int snakeDir;
    ...

}
```

- Dummy 게임에 필요한 로직을 구현하는 클래스
- `map` 에서 1은 뱀의 위치, 2는 사과의 위치를 나타낸다.

```java
private void moveSnake(int x, int y) { ... }
```

- `Queue` 를 이용해서 뱀의 꼬리 정보를 저장하고, 필요에 따라 먼저 들어온 좌표를 out한다.
- 뱀의 방향 전환을 위해 `snakeDir` 변수로 뱀의 현재 방향을 저장한다. (0, 1, 2, 3 - 북, 동, 남, 서)
- 시간에 따라 `infos` 에서 방향 전환 정보를 확인한다.

## :black_nib: **Review**

- 웹 백엔드 기능을 구현하는 것처럼, 요구사항 하나하나에 해당하는 기능 덩어리를 만들어보자는 생각으로 접근했다. 시뮬레이션은 주어진 로직 그대로 구현만 하면 되는 것 같다.
