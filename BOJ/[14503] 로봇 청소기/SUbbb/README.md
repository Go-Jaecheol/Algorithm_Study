# [14503] 로봇청소기 - Java

## :pushpin: **Algorithm**

구현, 시뮬레이션

## :round_pushpin: **Logic**

```java
class Robot {
    int x;
    int y;
    int dir;
    public Robot(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}
```

- 로봇 청소기의 위치를 저장하는 클래스

```java
public int cleanRoom(int r, int c, int d) {
    int cleanCount = 0;
    queue.add(new Robot(r, c, d));
    while(!queue.isEmpty()) {
        Robot robot = queue.poll();
        if (map[robot.x][robot.y] == 0) {
            map[robot.x][robot.y] = 2;
            cleanCount++;
        }
        if (!checkWallMethod(robot)) {
            moveBack(robot);
        }
    }
    return cleanCount;
}
```

- 문제에서 주어진 작동 로직을 구현한 메소드
- Queue를 이용한 BFS방식으로 청소할 영역을 탐색한다.

## :black_nib: **Review**

- 시뮬레이션 문제는 주어진 조건에 따라 로직을 구현하는 방식으로 이해해, 로봇청소기의 작동원리마다의 메소드를 구현하려 했다.
- 최대한 객체 지향적으로 들여쓰기 횟수도 고려하면서 메소드 추출을 수행했다.
