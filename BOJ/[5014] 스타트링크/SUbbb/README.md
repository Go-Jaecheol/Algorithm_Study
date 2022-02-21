# [5014] 스타트 링크 - Java

## :pushpin: **Algorithm**

그래프 이론, 그래프 탐색, BFS

## :round_pushpin: **Logic**

```java
class Pair {
    int floor;
    int cnt;

    public Pair(int floor, int cnt) {
        this.floor = floor;
        this.cnt = cnt;
    }
}
```
- 층 정보와 버튼 누른 횟수를 저장하기 위해 `Pair` **class**를 생성했다.

```java
Queue<Pair> q = new LinkedList<>();
q.add(new Pair(S, 0));
visited[S] = true;

while(!q.isEmpty()) {
    Pair now = q.poll();
    int now_floor = now.floor;
    int now_cnt = now.cnt;

    if (now_floor == G) {
        System.out.println(now_cnt);
        return;
    }

    for (int go : upDown) {
        int nxFloor = now_floor + go;
        if (nxFloor <= 0 || nxFloor > F) continue;
        if (visited[nxFloor]) continue;

        q.add(new Pair(nxFloor, now_cnt + 1));
        visited[nxFloor] = true;
    }
}
```
- 현재 층에서 목표 층까지 가기 위해 **BFS**로 이동 가능한 층과 버튼 누른 횟수를 `Queue` 에 저장한다.

## :black_nib: **Review**

- BFS 문제라는 것을 알고 풀어서 아이디어는 금방 잡았던 문제이다. 알고리즘 분류를 안 보고 아이디어를 생각해내는 연습이 필요할 것 같다.
- 저번과 동일하게 방문 여부를 저장하는 부분에서의 **메모리 초과**를 피할 수 없었다. 좀 더 자세하게 생각해보는 연습이 필요할 것 같다.