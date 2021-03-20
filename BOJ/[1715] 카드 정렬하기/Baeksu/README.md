# [1715] 카드 정렬하기 - C ++

## :pushpin: **Algorithm**

자료구조, 그리디 알고리즘, 우선순위 큐

## :round_pushpin: **Logic**

```c++
priority_queue <int, vector<int>, greater<int>> cards;
```

- 오름차순으로 `int`형 값들을 저장하는 우선순위 큐 선언

```c++
if (N > 1) {
    while (1) {
        int sum = 0;
        for (int i = 0; i < 2; i++) {
            int cur = cards.top();
            cards.pop();
            sum += cur;
        }
        cmp += sum;
        cards.push(sum);
        if (cards.size() == 1)
            break;
    }
}
```

- 가장 작은 카드 뭉치들을 먼저 정렬해야 함

## :black_nib: **Review**

- 우선순위 큐를 처음 사용한 문제
- 우선순위 큐를 가지고 최솟값들을 먼저 더하는 방식으로 구현하니 정답