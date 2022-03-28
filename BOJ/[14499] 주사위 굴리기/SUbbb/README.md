# [14499] 주사위 굴리기 - Java

## :pushpin: **Algorithm**

구현, 시뮬레이션

## :round_pushpin: **Logic**

```java
class Dice {
    int[][] map;
    int[] commands;
    int[] numbers = new int[6];
    int[] rangeX = { 0, 0, -1, 1 };
    int[] rangeY = { 1, -1, 0, 0 };
    int N, M, K;
    int top = 0, front = 4, east = 2;
    ...

}
```

- 주사위와 지도의 정보를 저장하는 클래스
- top, front, east 정보를 계속 변경하는 방식으로 주사위의 숫자 정보를 추적한다.

```java
public void game(int x, int y) {
    for (int i = 0; i < K; i++) {
        int nx = x + rangeX[commands[i] - 1];
        int ny = y + rangeY[commands[i] - 1];

        if (isInTheMap(nx, ny)) continue;

        x = nx;
        y = ny;

        rollDice(commands[i] - 1);

        if (map[x][y] == 0) {
            map[x][y] = numbers[5 - top];
        } else {
            numbers[5 - top] = map[x][y];
            map[x][y] = 0;
        }

        System.out.println(numbers[top]);
    }
}
```

- 명령어에 따라 지도에서의 주사위 위치를 변경시킨다.
  - 지도 범위 안인 경우만 주사위 정보를 수정하고, 상단의 숫자를 출력한다.

```java
private void rollDice(int command) {
    int t, e, f;
    t = top;
    e = east;
    f = front;
    switch (command) {
        case 0:
            top = 5 - e;
            east = t;
            break;
        case 1:
            top = e;
            east = 5 - t;
            break;
        case 2:
            top = f;
            front = 5 - t;
            break;
        case 3:
            top = 5 - f;
            front = t;
    }
}
```

- 주사위의 top, front, east 정보를 업데이트하는 메소드

## :black_nib: **Review**

- 다른 구현은 모두 쉬웠는데, `rollDice()` 구현이 제일 어려웠다.
  - 원래는 명령어가 주어지면, 전역으로 가지고 있는 bottom의 정보를 업데이트하는 방식을 사용하려 했는데, 아무리 생각해도 안되는 경우가 많은 것 같아 게시판을 참고했다.