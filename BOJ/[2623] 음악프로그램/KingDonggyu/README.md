# [2623] 음악프로그램 - Python

## :mag: Algorithm

### Topological Sort (위상 정렬)

## :round_pushpin: Logic

"각 보조 PD가 정한 순서들"을 가공하여 그래프로 표현한다.

```python
for _ in range(M):
    order = [int(i) for i in sys.stdin.readline().split()]
    for i in range(1, order[0]):
        graph[order[i]].append(order[i+1])
```

이후, 그래프를 통해 진입차수 리스트를 생성하여 위상정렬을 수행하기만 하면된다.

## :memo: Review

원래 하루에 문제 하나씩 풀었는데, 이전 위상정렬 문제([1766] 문제집)가 너무 금방 끝나 이번 문제 또한 풀었다.

그런데 이번 문제는 이전 문제보다 더 쉬웠다 😅