# [42746] 가장 큰 수 - Java

## :pushpin: **Algorithm**

정렬

## :round_pushpin: **Logic**

```java
Arrays.sort(strNumbers, new Comparator<String>() {
    public int compare(String obj1, String obj2) {
        return (obj2 + obj1).compareTo(obj1 + obj2);
    }
});
```

- 숫자를 저장할 `strNumbers` 배열에 `compareTo()` 를 이용해 작은 숫자를 앞으로 정렬시킨다.

## :black_nib: **Review**

- 처음에는 주어진 수들 중 가장 큰 수를 찾아 그 자릿수만큼 다른 수들의 자릿수를 변환한 다음, 정렬하여 변환한 수의 경우는 다시 원래 수로 바꿔 `answer` 에 붙이고, 변환하지 않은 수는 그대로 `answer` 에 붙이는 방식으로 구현했다.
  - "0, 0, 0" 인 경우와, 여러 반례에 막혔다..
- 결국 참고 블로그를 통해 `compareTo()` 를 사용하는 방식을 사용했다.
  - 숫자를 비교하는 경우와, 문자를 비교하는 경우마다 반환하는 `int` 값이 달랐고, 이를 잘 활용한 풀이인 것 같다.
- `compareTo()`
  - 숫자의 경우
    - 기준값보다 비교대상이 큰 경우 : -1 반환
    - 기준값보다 비교대상이 작은 경우 : 1 반환
  - 문자의 경우
    - 기준값에 비교대상이 포함되어 있는 경우 : 서로의 문자열 길이의 차이값 반환
    - 기준값과 전혀 다른 문자열인 경우 : 비교가 불가능한 지점 문자의 아스키 코드 값 차이 반환
  - 둘 다 같은 경우는 0 반환
  
## 📕 참고
- [참고 블로그](https://hannamnote.tistory.com/82)
- [compareTo()](https://mine-it-record.tistory.com/133)
