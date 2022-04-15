# [42840] 모의고사 - Java

## :pushpin: **Algorithm**

완전 탐색

## :round_pushpin: **Logic**

```java
private int countScore(int[] answers, int[] std) {
    int score = 0;
    for (int i = 0, idx = 0; i < answers.length; i++) {
        if (idx >= std.length)
            idx = idx % std.length;
        if (std[idx++] == answers[i])
            score++;
    }
    return score;
}
```

- 주어진 학생의 정답 배열을 가지고 점수를 매긴다.
- 다만 주어진 정답 배열의 범위를 벗어나는 경우 (문제 수가 더 많은 경우) 접근 index 값을 `%` 을 사용해 변경한다.

## :black_nib: **Review**

- 완전 탐색 알고리즘답게 단순히 다 돌려보면 되는 문제였다.
