# [14226] 이모티콘 - Java

## :pushpin: **Algorithm**

DP (동적 계획법), 그래프 이론, 그래프 탐색, BFS

## :round_pushpin: **Logic**

```java
visited = new int[1001][1001];
Emoji e = new Emoji(1, 0, 0);
```

- ```visited``` 는 ```[screen에 존재하는 이모티콘 수][clipboard에 존재하는 이모티콘 수]``` 의 방문여부를 저장하는 2차원 배열
- ```Emoji``` 는 ```(screen, clipboard, second)``` 를 저장하는 Class

```java
q.add(new Emoji(cur.screen, cur.screen, cur.second + 1));
if (cur.clip > 0 && cur.screen + cur.clip <= N && visited[cur.screen + cur.clip][cur.clip] != 1) {
    q.add(new Emoji(cur.screen + cur.clip, cur.clip, cur.second + 1));
    visited[cur.screen + cur.clip][cur.clip] = 1;
}
if (cur.screen > 0 && visited[cur.screen - 1][cur.clip] != 1) {
    q.add(new Emoji(cur.screen - 1, cur.clip, cur.second + 1));
    visited[cur.screen - 1][cur.clip] = 1;
}
```

- 복사하는 경우, clip에 현재 screen에 있는 이모티콘 수만큼 붙여지고 second가 증가
- 붙여넣는 경우, 클립보드가 비면 안되고, 붙여넣었을 때, 원하는 개수를 넘지 않아야 하고, 붙여넣은 경우를 이미 수행하지 않았어야 함
- 삭제하는 경우, screen이 비지 않아야 하고, 하나를 삭제한 경우를 이미 수행하지 않았어야 함

## :black_nib: **Review**

- **클립보드에 있는 이모티콘의 수를 확인**하기 위해 ```Class```를 만들어야 한다는 것까지는 생각해서 진행했지만, 방문여부 확인과 ```BFS``` 를 어떻게 수행해야 할 지 감이 잡히지 않아 참고 ..
- **Class**에 대한 조금의 이해를 추가할 수 있었음