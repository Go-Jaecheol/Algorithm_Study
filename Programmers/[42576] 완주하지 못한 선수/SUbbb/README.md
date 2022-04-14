# [42576] 기능개발 - Java

## :pushpin: **Algorithm**

해시

## :round_pushpin: **Logic**

```java
for (String p : participant)
    map.put(p, map.getOrDefault(p, 0) + 1);

for (String c : completion)
    map.put(c, map.get(c) - 1);

for (Map.Entry<String, Integer> entry : map.entrySet())
    if (entry.getValue() != 0) answer = entry.getKey();
```

- 먼저 `participant` 에 있는 이름을 `HashMap` 에 `put` 하는데, `getOrDefault()` 메소드로 해당 이름이 이미 있는지 확인하여 있다면, 그 이름에 해당하는 `value` 에 + 1 하여 저장한다.
- 이후 `completion` 에 있는 이름으로 다시 `HashMap` 을 수정하는데, 이미 있는 이름에 - 1 한 값으로 업데이트한다.
- 최종적으로 `value` 가 0이 아닌 이름이 완주하지 못한 선수가 된다.

## :black_nib: **Review**

- `HashMap` 을 사용하여 `completion` 에 없는 이름을 출력해야 한다는 것은 알았지만, 해시 알고리즘을 처음 풀어봐서 어떻게 해야 효율적으로 구현할 수 있을지가 헷갈렸다.
- 어떻게 했나 싶어서 블로그를 참고했는데 한 `HashMap` 에다가 넣으면서 value를 줄여주는 방법이 진짜 신기했다. 

## 📕 참고
- [참고 블로그(https://coding-grandpa.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%99%84%EC%A3%BC%ED%95%98%EC%A7%80-%EB%AA%BB%ED%95%9C-%EC%84%A0%EC%88%98-%ED%95%B4%EC%8B%9C-Lv-1)