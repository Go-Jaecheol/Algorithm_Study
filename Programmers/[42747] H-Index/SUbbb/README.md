# [42747] H-Index - Java

## :pushpin: **Algorithm**

정렬

## :round_pushpin: **Logic**

```java
private boolean isHindex(int[] citations, int H) {
  int s = 0, l = 0;
  for (int i = 0; i < citations.length; i++) {
    if (citations[i] >= H) l++;
    if (citations[i] <= H) s++;
  }
  
  if (l >= H && s <= H) return true;
  return false;
}
```

- `H` 가 주어진 H-index 조건을 만족하는지 확인하는 함수

## :black_nib: **Review**

- H-index가 주어진 `citations` 배열에 없을 수도 있다는 생각을 못하고, 주어진 배열 내에서만 H-index를 찾으려다가 테케 1개 빼고 다 실패했다...
- 주어진 배열에 없을 수도 있다는 가정하에 구현하니 바로 해결했다.
