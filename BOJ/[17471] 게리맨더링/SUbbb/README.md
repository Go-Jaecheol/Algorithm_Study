# [17471] 게리맨더링 - Java

## :pushpin: **Algorithm**

그래프 이론, 브루트포스, 그래프 탐색, DFS, BFS, 비트마스킹

## :round_pushpin: **Logic**

```java
class Dosi {
    ArrayList<Integer>[] dosi;
    int[] population;
    int[] area;
    boolean[] visited;
    int size;
    int answer = Integer.MAX_VALUE;
}
```

- 선거구의 정보를 담당하는 클래스이다.

```java
public int searchDivision();
```

- 선거구 분할 메소드를 호출하고, 최솟값을 비교해 최종적으로 출력해야 할 값을 반환하는 함수이다.

```java
private void dfs(int n);
```

- 재귀적으로 호출되면서, 모든 선거구 분할법을 DFS방식으로 완전 탐색하며 선거구가 2개로 분할 가능한 경우에만 인구수 차이를 계속 업데이트하는 메소드이다.

```java
private void bfs(int idx, int areaN);
```

- 선거구 분할 후, 방문여부를 업데이트하기 위해 BFS 방식으로 수행되는 메소드이다.

## :black_nib: **Review**

- 대략적으로 구상한 방법은,
  - 분할이 가능한 방법으로 선거구를 두 개로 분할
  - 분할한 경우 중, 인구 차이를 계속 업데이트하는 방식으로 가장 최소가 되는 분할법을 탐색
- 그런데 어떻게 선거구를 분할해야하는가가 고민이었다. 그래서 게시판에서 "0번 구역이 포함된 선거구 vs 0번 구역이 포함되지 않은 선거구" 라는 아이디어를 발견해 생각해보았다.
  - 역시나 구현에서 막혀 아래 블로그를 참고했다...
- 매번 문제를 시작할 때 어떻게 하면 깔끔하게 입력을 받아 저장할 수 있을까를 고민하는데, 이번에는 좀 새로운 문법을 사용해보았다. 
  - `String[] tokens` 에 `split(" ")` 한 결과를 매번 담았다가 정수로 파싱하여 다시 저장했는데, 이번엔 문자열 한 줄을 받아 공백 기준으로 나누면서 바로 정수형 배열에 저장하는 방식을 사용해보았다.

## 참고
- https://moonsbeen.tistory.com/254