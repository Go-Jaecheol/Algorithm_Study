# [42862] 체육복 - Java

## :pushpin: **Algorithm**

그리디

## :round_pushpin: **Logic**

```java
for (int l : lost) {
  if (map.containsKey(l)) map.computeIfPresent(l, (k, v) -> v - 1);
  else lostMap.put(l, 0);
}

for (int l : lostMap.keySet()) {
  if (map.containsKey(l - 1) && map.get(l - 1) > 0) {
    map.computeIfPresent(l - 1, (k, v) -> v - 1);
    map.put(l, 0);
  } else if (map.containsKey(l + 1) && map.get(l + 1) > 0) {
    map.computeIfPresent(l + 1, (k, v) -> v - 1);
    map.put(l, 0);
  } else map.put(l, -1);
}
```

- 학생과 체육복 개수 정보를 `Map` 으로 저장한다.
  - `reserve` 에 있는 학생들은 모두 체육복 수를 1개로 지정한다.
- 먼저 `lost` 와 `reserve` 둘 다에 있는 학생의 경우는 자기 체육복을 자기가 써야 하므로, 체육복을 도난당한 학생 목록인 `lostMap` 에 넣지 않고, 해당 학생의 체육복 수는 0으로 update한다.
- `lostMap` 에는 이제 체육복을 빌려야 하는 학생들만 존재한다.
  - 앞 번호의 학생들에게 빌릴 수 있는지 확인하고, 체육복 개수 정보를 수정한다.
- 최종적으로 체육복 개수가 0 이상인 학생들의 수를 센다.

## :black_nib: **Review**

- 그리디는 이해도 안되고, 코드도 안 이쁜 것 같다.
- 존재 여부를 확인하기 위한 `Map` 은 유용한 것 같다.
