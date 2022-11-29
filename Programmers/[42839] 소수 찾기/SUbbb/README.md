# [42839] 소수 찾기

## :pushpin: **Algorithm**

완전 탐색

## :round_pushpin: **Logic**

```java
private static void permutation(int[] output, boolean[] visited, int depth, int n, int r) {
    if (depth == r) {
        int newNumber = arrayToInt(output);
        if (isPrime(newNumber)) {
            primeNumbers.add(newNumber);
        }
        return;
    }
    for (int index = 0; index < n; index++) {
        if (!visited[index]) {
            visited[index] = true;
            output[depth] = numbers[index];
            permutation(output, visited, depth + 1, n, r);
            visited[index] = false;
        }
    }
}
```

- 1 ~ n자리까지의 순열을 생성해 소수라면 Set에 추가한다.

## :black_nib: **Review**

- 순열을 사용해 모든 경우를 구해보고, 소수의 숫자를 카운트하는 쉬운 문제.
