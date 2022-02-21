# [42748] K번째수 - Python

## :mag: Algorithm

### Sort

## :round_pushpin: Logic

💡 주어진 입력에 따라 **정렬**하고, k번째의 수를 리턴한다.

```python
def solution(array, commands):
    return list(map(lambda x: sorted(array[x[0]-1:x[1]])[x[2]-1], commands))
```

## :memo: Review

이 문제에 대한 리뷰를 작성할 필요가 있을까 싶다..
