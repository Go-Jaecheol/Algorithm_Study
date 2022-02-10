# [42839] 소수 찾기 - Python

## :mag: Algorithm

### BruteForce

## :round_pushpin: Logic

**Problem: "문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return"**

("013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.")

💡 **순열**을 통해 나올 수 있는 수의 모든 경우를 소수인지 확인한다.

```python
for i in range(len(numbers)):
    temp = list(map("".join, permutations(numbers, i+1)))
    num += list(map(int, temp))
```

- 주어진 문자열에 대한 순열로 나올 수 있는 조합의 숫자 리스트를 생성한다.

```python
for s in set(num):
        x = int(s)
        if x < 2: continue
        for i in range(2, int(math.sqrt(x))+1):
            if x % i == 0:
                x = False
                break
        if x: answer += 1
```

- 생성한 숫자 리스트를 **`set()`을 통해 중복된 수를 제거**하여 반복문을 시행한다.

- 2부터 **수의 최대 제곱근**(효율적 탐색을 위한)까지의 수를 나누어, 나머지가 0인 경우가 없다면 소수로 판별한다.

## :memo: Review

평범한 브루트포스 문제이다. 

순열을 이용하면 금방 해결할 수 있다.

다만 아쉬운 점이 있다면 처음에 소수를 판별하는 로직을 2부터 `x-1` 까지의 수를 나누도록 했었다..

문제가 풀리긴 했지만 소수를 더 효율적으로 판별할 수 있는 방법이 없을까 알아보다,

2부터 `x`의 제곱근까지의 수를 나누도록 하면 훨씬 효율적으로 탐색할 수 있다는 것을 알게 되었다.

**항상 내 코드에 대해 의문점을 가지며 더 효율적인 방법이 있는지 고민하는 습관을 가지자!**