# [42883] 큰 수 만들기 - Python

## :mag: Algorithm

### Greedy

## :round_pushpin: Logic

**Problem: <u>number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return</u>**

💡 **스택**을 이용한다.

```python
answer = []
for num in number:
    while 0 < len(answer) and answer[-1] < num and k > 0:
        answer.pop()
        k -= 1
    answer.append(num)
```

- 해당 숫자가 스택의 마지막 원소보다 클 경우 스택을 **pop**한다.

- 조건에 관계없이 해당 숫자를 스택애 **push** 한다.

- 만약 반복문이 종료되었을 때 k가 0이 아니라면, 스택의 k 개수의 원소를 pop한다.

## :memo: Review

이번 문제 또한 아이디어를 떠올리느라 애 먹었다..

이전 문제와 이번 문제를 보아 내가 그리디 문제에 약한 편인 것 같다 😂