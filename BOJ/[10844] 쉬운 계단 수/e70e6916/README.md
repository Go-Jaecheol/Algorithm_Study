# [10844] 쉬운 계단 수 - Python

## :mag: Algorithm

Dynamic Programming

## :round_pushpin: Logic

N이 1일 경우 나오면 경우의 수를 뜻하는 ```step = [0, 1, 1, 1, 1, 1, 1, 1, 1, 1]```을 시작으로 
```
    for i in range(10):
        if i == 0: temp[i] = step[1]
        elif i == 9: temp[i] = step[8]
        else: temp[i] = step[i-1] + step[i+1]
```
위 제어문을 N만큼 반복하여 ```step```을 업데이트한다.

## :memo: Review

N에 부합하는 수들에 집중한 나머지 시간초과가 일어났고 이를 해결하기 위해 N의 변화에 따른 규칙을 찾아야겠다고 생각했다. 그렇게 고민한 끝에 이 문제를 해결 할 수 있었다. 공책 5장 정도 쓴거 같다... 문제 제목과 달리 쉽지 않았다.