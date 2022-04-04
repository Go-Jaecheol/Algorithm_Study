# [17144] 미세먼지 안녕! - Java

## :pushpin: **Algorithm**

구현, 시뮬레이션

## :round_pushpin: **Logic**

```java
class Room {
    Queue<Pair> dustQueue = new LinkedList<>();
    int[][] room;
    int[] rangeX = { -1, 0, 1, 0 };
    int[] rangeY = { 0, 1, 0, -1 };
    int R, C;
    int cleaner1X, cleaner2X;
    ...

}
```

- 미세 먼지와 공기청정기 정보를 저장하는 클래스

```java
public int goodByeFineDust(int time) {
    while(time > 0) {
        spreadDust();
        runCleaner();
        time--;
    }
    return countDust();
}
```

- 코드는 먼지를 확산시키고, 공기청정기를 동작시킨다. 정해진 시간이 경과한 후, 전체 미세 먼지를 반환한다.

```java
private void spreadDust() {...}
```

- `Queue` 에 저장하고 있는 미세 먼지 좌표를 이용해 미세 먼지를 확산시킨다. 
- 이때 업데이트할 미세 먼지 정보를 `int[][] tmp` 에 저장하고, 확산이 끝난 이후 `room` 을 업데이트한다.

```java
private void runCleaner() {...}
```

- 공기 청정기의 바람 방향을 따라 순차적으로 미세 먼지를 이동시킨다. 
- 공기 청정기 바로 앞 좌표는 항상 `0` 으로 업데이트한다.

## :black_nib: **Review**

- 미세먼지를 확산시키는 방법에서 시간을 많이 뺏겼다. 결론적으로는 추가적인 배열을 두고, 미세먼지 확산 정보를 저장해두고, `room` 에 업데이트하는 방식이 필요했다.
- 시뮬레이션은 단순한 듯 하면서 많은 코드량을 요구하는 것 같다...
