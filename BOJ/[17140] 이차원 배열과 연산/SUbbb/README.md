# [17140] 이차원 배열과 연산

## :pushpin: **Algorithm**

구현, 시뮬레이션, 정렬

## :round_pushpin: **Logic**

```java
for (answer = 0; answer <= 100; answer++) {
    int[][] temp = new int[101][101];
    if (array[r][c] == k) break;

    PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
    int tmpSize = 0;
    int[] countNums;

    // R 연산
    if (rowSize >= colSize) {
        for (int i = 0; i < rowSize; i++) {
            // 빈도를 구하는 로직

            // 우선순위 큐에 숫자, 빈도 쌍을 저장하는 클래스를 삽입

            tmpSize = Math.max(tmpSize, priorityQueue.size());

            // 우선순위 큐의 값을 순서대로 temp에 저장
        }

        // 열 크기를 갱신
        colSize = tmpSize * 2;
        if (colSize > 99) colSize = 99;
    } else {
        ...
    }
    // 옮기기
    array = temp;
}
```

- 행, 열 별로 숫자의 빈도를 구하고, 우선순위큐를 사용해 정렬한 후 순서대로 다시 temp에 저장한다.

## :black_nib: **Review**
- 정렬을 우선순위 큐를 사용해서 한다는 생각은 못했던 것 같다 ... 대단하네
- 처음에는 `array` 에 정렬의 결과를 바로바로 박아넣었는데, 제대로 된 결과가 안 나와서 `temp` 에 저장한 후에 이를 다시 옮겨담는 방식으로 바꾸니까 됐다.
  - 이게 왜 문제가 되는 거지 ...