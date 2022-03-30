# [15685] 드래곤 커브 - Java

## :pushpin: **Algorithm**

구현, 시뮬레이션

## :round_pushpin: **Logic**

```java
class DragonMap {
    int[][] map = new int[101][101];
    int[] rangeX = { 1, 0, -1, 0 };
    int[] rangeY = { 0, -1, 0, 1 };
    ...

}
```

- 드래곤 커브를 그리기 위한 `map` 과 방향에 따른 이동을 위해 사용하는 범위 정보를 저장하는 클래스

```java
public void drawDragonCurves(int x, int y, int d, int g) {
    List<Integer> dirList = new ArrayList<>();
    dirList.add(d);

    for (int i = 0; i < g; i++) {
        for (int j = dirList.size() - 1; j >= 0; j--) {
            dirList.add(getCountClockDir(dirList.get(j)));
        }
    }

    map[x][y] = 1;
    for (Integer dir : dirList) {
        x += rangeX[dir];
        y += rangeY[dir];
        map[x][y] = 1;
    }
}
```

- 리스트에 방향 정보를 저장하고, 마지막에 저장한 방향 정보부터 차례로 반시계 방향으로 돌린 방향 정보를 저장한다.

## :black_nib: **Review**

- 매 세대마다 방향이 바뀌는 것에 대해, 이를 리스트에 저장하고 계속 업데이트해주는 방식은 생각했지만, 왜인지 리스트도 큐처럼 `push` , `pop` 을 해야 하니까 비효율적이지 않나 ... 하는 생각에 사로잡혀 혼자 꽉 막혀버렸다.
- 다른 방법은 뭐가 있나 싶어 한 블로그를 봤는데, 생각한 그대로를 구현한 글을 발견해서 나의 무지함을 깨달았다.

## 📕 참고
[15685](https://velog.io/@hammii/%EB%B0%B1%EC%A4%80-15685-%EB%93%9C%EB%9E%98%EA%B3%A4-%EC%BB%A4%EB%B8%8C-java)