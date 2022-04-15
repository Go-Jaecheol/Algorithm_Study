# [42748] K번째 수 - Java

## :pushpin: **Algorithm**

정렬

## :round_pushpin: **Logic**

```java
for (int i = 0; i < commands.length; i++) {
    int from = commands[i][0];
    int to = commands[i][1];
    int k = commands[i][2];
    
    int[] tmp = Arrays.copyOfRange(array.clone(), from - 1, to);
    Arrays.sort(tmp);
    list.add(tmp[k - 1]);
}
```

- 주어진 명령어들을 이용하여 기존 배열에서 추출한 `tmp` 배열을 정렬하여 원하는 값을 `List` 에 저장한다. 

## :black_nib: **Review**

- 매우 간단한 문제였다.
