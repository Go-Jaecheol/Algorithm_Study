# [12904] A와 B

## :pushpin: **Algorithm**

그리디 알고리즘, 구현, 문자열

## :round_pushpin: **Logic**

```java
Queue<String> words = new LinkedList<>();
words.add(target);
for (int index = 0; index < target.length() - original.length(); index++) {
    if (words.isEmpty()) {
        System.out.println(ZERO);
        return;
    }

    String word = words.poll();
    if (isLastA(word)) {
        words.add(deleteLastWord(new StringBuilder(word)).toString());
    } else {
        words.add(reverseWord(deleteLastWord(new StringBuilder(word))).toString());
    }
}
```

- 연산은 원본 문자열과 목표 문자열의 길이 차만큼만 수행한다.
  - 한 연산을 수행할때마다 길이가 1씩 증가하기 때문이다.
- 아직 연산을 수행해야하는 경우인데, 연산을 수행할 대상 문자열이 없다면 만들 수 없음을 의미한다.
- 큐에서 대상 문자열을 꺼내 주어진 연산을 반대로 수행하면서 새로운 문자열을 생성한다.

## :black_nib: **Review**
- 처음에는 원본 문자열로부터 모든 연산을 해보면서 문자열을 생성했는데, 메모리 초과가 떴다.
- 그렇다면 반대로 하면 저장할 문자열이 줄어들 것 같아 바로 수정했다.