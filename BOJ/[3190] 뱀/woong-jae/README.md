# [3190] 뱀
## Algorithm
- Simulation
- Queue
## Logic
뱀이 벽 또는 자기자신과 부딪히면 끝나기 때문에, 뱀의 몸이 보드의 어느 좌표에 있는지 기록해두어야 한다.  
이때 **queue** 자료형을 사용하면 쉽게 풀 수 있다.

뱀이 사과를 먹었을 때는 뱀의 머리를 큐에 `push` 만 해주면 된다.

그냥 이동할 때는 꼬리를 없애줘야 한다. 큐 자료형의 특성상 제일 앞에 있는 것이 제일 마지막으로 들어온 것이기 때문에 꼬리이다.
따라서, `pop`을 해준 후 마찬가지로 머리를 `push` 해준다.
```c++
if (board[next.first][next.second] == 0) { // 그냥 이동
    board[s.body.front().first][s.body.front().second] = 0;
    s.body.pop();
} else if (board[next.first][next.second] == 2) { // 사과 발견
  break;
}
s.body.push(next);
s.head = next;
board[next.first][next.second] = 2;
time++;
```
## Review
어렵지 않은 문제. 문제가 좀 더 자세히 적혀있었으면 좋겠다. (0, 0)이 시작인지 (1, 1)이 시작인지 너무 햇갈린다...
