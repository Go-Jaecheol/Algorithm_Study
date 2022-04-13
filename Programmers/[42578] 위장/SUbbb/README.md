# [42578] 위장 - Java

## :pushpin: **Algorithm**

해시

## :round_pushpin: **Logic**

```java
for (String[] cloth : clothes) {
    if (map.containsKey(cloth[1]))
        map.put(cloth[1], map.get(cloth[1]) + 1);
    else
        map.put(cloth[1], 1);
}
```

- 의상 종류를 `Key` 로, 해당 종류에 몇 가지의 의상이 존재하는지를 `value` 로 저장한다.

## :black_nib: **Review**

- `HashMap` 의 `Key` 와 `Value` 를 어떻게 활용할지는 떠올렸지만, 정답 도출을 위한 식을 모르겠어서 질문 게시판을 참고했다.
- 단순한 조합식이긴 한데... 기억이 안 났다;