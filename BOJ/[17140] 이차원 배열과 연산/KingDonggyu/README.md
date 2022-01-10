# [17140] 이차원 배열과 연산 - Python

## :mag: Algorithm

Simulation

## :round_pushpin: Logic

```python
def init_dict(list):
    dict = {}
    for v in list:
        if v == 0: continue
        if v in dict: dict[v] += 1
        else: dict[v] = 1
    return dict
```

- 딕셔너리를 이용하여 각 숫자를 key로, 숫자의 수를 value로 설정했다.

```python
def sort(dict):
    list = [];
    for key, value in sorted(dict.items()):
        if len(list) == 100: break
        list += [key, value]; cnt = len(list)
        while cnt >= 4 and list[cnt-1] < list[cnt-3]:
            list[cnt-4], list[cnt-2] = list[cnt-2], list[cnt-4]
            list[cnt-3], list[cnt-1] = list[cnt-1], list[cnt-3]
            cnt -= 2
    return list
```

- 생성한 **딕셔너리를 key를 기준으로 오름차순 정렬**한 것을 반복문을 통해 문제에서 제시한 조건으로 정렬한다.

- 배열에 반복문을 통해 딕셔너리의 key와 value를 append하며, **append한 value보다 큰 값을 가진 값이 `(cnt-1) - 2` ((append한 value가 위치한 index) - 2 : 바로 이전에 append한 value의 index)' 에 위치한다면,** `cnt-4` 와 `cnt-2` (key), `cnt-3` 와 `cnt-1` (value) 의 값을 서로 바꾼다.

## :memo: Review

딕셔너리를 사용하여 금방 해결할 수 있었다.

배열의 index overflow (indexError) 부분이 어쩔 수 없이 생겼는데, 이를 error handling `try - except` 을 통해 예외 처리를 할 수 있었다.

