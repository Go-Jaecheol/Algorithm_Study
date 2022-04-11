# [43165] 타겟 넘버 - Java

## :pushpin: **Algorithm**

DFS, BFS

## :round_pushpin: **Logic**

```java
private void dfs(int[] numbers, int idx, int target, int sum) {
    if (idx + 1 == numbers.length) {
        if (sum == target) answer++;
        return;
    }
    dfs(numbers, idx + 1, target, sum + numbers[idx + 1]);
    dfs(numbers, idx + 1, target, sum - numbers[idx + 1]);
}
```

- 재귀적인 DFS를 이용해 다음 number를 더하거나 뺴면서 맨 마지막 값이 타겟 넘버와 같은 경우 answer를 증가한다.
- 첫 번째 숫자가 양수인 경우와 음수인 경우 두 가지에 대해 dfs를 호출한다.

## :black_nib: **Review**

- 처음에는 트리를 만들어서 맨 마지막 리프 노드가 타겟 넘버랑 같은 경우의 수를 체크해야하나 생각했다.
- 이전에 DFS 문제를 풀 때 뭔가 재귀 호출을 이용한 DFS로 비슷한 문제를 풀었던 것이 생각나 구현해보니 정답이었다.
- 쓸데없이 트리를 구현할 뻔 했다.
