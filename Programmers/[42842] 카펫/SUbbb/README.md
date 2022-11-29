# [42842] 카펫

## :pushpin: **Algorithm**

완전 탐색

## :round_pushpin: **Logic**

```java
int sum = brown + yellow;
int horizontal = (int) Math.sqrt(sum);
int vertical = 0;

for (; horizontal < sum; horizontal++) {
    if (sum % horizontal != 0) {
        continue;
    }
    vertical = sum / horizontal;
    if (horizontal >= vertical && isCarpet(brown, horizontal, vertical)) {
        break;
    }
}
```

- brown + yellow의 약수 쌍을 탐색하면서, 카펫을 완성시키는 경우를 찾는다.

## :black_nib: **Review**

- 주어진 테스트 케이스와 문제를 읽어보니, brown + yellow의 약수 쌍이 정답이 되는 문제였다.
- 약수 쌍 중, 조건을 만족하는 경우가 정답이었다.
