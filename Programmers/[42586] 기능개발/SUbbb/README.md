# [42586] 기능개발 - Java

## :pushpin: **Algorithm**

스택, 큐

## :round_pushpin: **Logic**

```java
for (int i = 1; i < progresses.length; i++) {
    int days = getDays(progresses[i], speeds[i]);
    if (head < days) {
      head = days;
      answers.add(count);
      count = 1;
    } else count++;
}
```

- 기능별 남은 일수를 구하고, 먼저 배포되어야 하는 작업(`head`)의 남은 일수보다 같거나 적게 남은 작업까지 카운트한다.
- 먼저 배포되어야 하는 작업보다 더 많은 일수가 남았다면 `head` 를 변경하고 현재의 카운트를 반환할 배열에 추가한다.

## :black_nib: **Review**

- 스택, 큐를 사용하는 알고리즘을 생각했다가 너무 많은 `add`, `poll` 을 사용할 것 같아 포기했다.
- 많이 어렵진 않았다.