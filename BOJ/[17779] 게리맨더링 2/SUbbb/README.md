# [17779] 게리맨더링2 - Java

## :pushpin: **Algorithm**

구현, 시뮬레이션, 브루트포스 알고리즘

## :round_pushpin: **Logic**

```java
class Dosi {
    int N;
    int minDiff = Integer.MAX_VALUE;
    int[][] map;
    int[][] copyMap;
    int[] rangeX = { -1, 0, 1, 0 };
    int[] rangeY = { 0, 1, 0, -1 };
    ...

}
```

- 선거구의 정보를 담당하는 클래스이다.

```java
public int vote() {...}
```

- 주어진 기준에 따라 선거구를 나누고, 인구 수를 합산하는 로직을 실행하는 메소드이다.

```java
private void setLine(int x, int y, int d1, int d2) {...}
```

- 5번 선거구의 가장자리를 긋고, 내부 영역을 탐색하는 `isConnected` 를 실행하는 메소드이다.

```java
private void isConnected(int x, int y) {...}
```

- 재귀적으로 5번 선거구의 내부를 탐색한다.

## :black_nib: **Review**

- 처음에는 게리맨더링이랑 비슷한 줄 알았는데 조금은 달라서 생각해보는데 시간이 좀 걸렸다. 
- 선거구를 나누는 로직을 구현하는데 시간이 걸렸고, 게시판을 참고해서 나름대로 풀어봤는데, 최종적으로 인구수를 합산해 차이의 최소를 구하는 로직이 자꾸 틀렸다.
  - 어차피 나눠진 선거구의 인구 수를 나눌 때마다 합산하고 선거구를 다 나눈 뒤 (즉, 인구 수 합산까지 완료된 상태) 차이를 구하고 이를 업데이트하는 방식은 왜 틀리는지 모르겠다.
