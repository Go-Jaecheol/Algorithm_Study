# [1541] 잃어버린 괄호

## :pushpin: **Algorithm**

그리디 알고리즘

## :round_pushpin: **Logic**

```java
int prevNumber = -1;
while(st.hasMoreTokens()) {
    String word = st.nextToken();

    if (prevNumber != -1) {
        numbers.push(prevNumber + Integer.parseInt(word));
        prevNumber = -1;
        continue;
    }

    if (word.equals(PLUS)) {
        prevNumber = numbers.pop();
    } else if (!word.equals(MINUS)) {
        numbers.push(Integer.parseInt(word));
    }
}
```

- 스택에는 숫자만 저장한다.
- 만약 + 연산자가 들어온 경우, 스택 제일 위에 있는 숫자를 저장해둔다.
  - 이후, 다음 숫자를 읽어 합한 후, 스택에 넣는다.
- + 연산이 끝난 후 - 연산을 수행해야 할 숫자들만 스택에 남는다.

## :black_nib: **Review**
- 예전에 풀었던 수식 최대화 문제처럼 풀어야 하나 싶었는데, 연산자의 개수가 +, -로만 제한되어 있었고, 더 간단한 방법이 있을 것 같았다.
- 수학적으로 + 연산을 먼저 다 한 후, - 연산을 해야 최솟값이 나오는지 절대 시간 안에 유추할 순 없었을 것 같다... 구현은 쉬웠다.