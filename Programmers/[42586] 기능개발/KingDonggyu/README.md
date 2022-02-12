# [42586] 기능개발 - Python

## :mag: Algorithm

### Queue

## :round_pushpin: Logic

**Problem: "어떤 기능이 먼저 완성되었더라도 앞에 있는 모든 기능이 완성되지 않으면 배포가 불가능합니다."**

💡 **큐**를 이용한다.

- **주어진 `progresses`를 큐로 사용한다.**

1. 먼저 `progresses`에 반복문을 통해 각 `speeds` 값을 더한다.

2. 만약 `progress[0]`이 100 이상이면, `progress`와 `speeds` 모두 `pop(0)` 한다.

3. 2번을 `while`을 통해 `progress`의 100 이상인 맨 앞 원소를 모두 pop하고, 그 횟수를 `answer`에 추가한다.

4. 1~3 과정을 `progress`가 비어질 때까지 `while`을 통해 반복한다.

## :memo: Review

굳이 큐를 사용하지 않고 다른 많은 방법으로 문제를 해결할 수 있을 것 같다.

나는 큐를 이용하는 방법이 가장 먼저 떠올랐고, 이로 구현하여 쉽게 해결할 수 있었다.
