# [42746] 가장 큰 수 - Python

## :mag: Algorithm

### Sort

## :round_pushpin: Logic

💡 주어진 `numbers`의 원소들을 문자로 변경하고, 아래의 함수를 `key`로 한 **정렬**을 수행한다.

```python
def comp(a, b):
    return 1 if a+b <= b+a else -1
```

## :memo: Review

문자열의 특성을 반영한 기초적인 정렬 문제이다.

또 다른 방법으로, `numbers`의 각 원소들을 문자로 변경한 뒤, 각 원소(문자) * 100을 더해주어 정렬해도 풀린다.

그냥 궁금해서 해봤는데 된다.. (대신 코드가 길어진다.)