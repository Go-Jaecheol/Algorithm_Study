# [42576] 완주하지 못한 선수 - Python

## :mag: Algorithm

### Hash

## :round_pushpin: Logic

**Problem: "완주하지 못한 선수의 이름을 return (참가자 중에는 동명이인이 있을 수 있습니다.)"**

💡 선수의 이름을 Key, 동명이인의 수를 Value로 한 **딕셔너리**를 생성한다.

- 반복문을 통해 `completion` 에 Key가 있을 경우 Value를 -1 한다.

- 그 후, 0이 아닌 Key(완주하지 못한 선수의 이름)를 찾아 return한다.

## :memo: Review

딕셔너리를 활용하면 쉽게 해결할 수 있는 문제이다.

코드를 더 간결하고 효율적이게 업그레이드할 수 있을 것 같지만..

안하겠다.