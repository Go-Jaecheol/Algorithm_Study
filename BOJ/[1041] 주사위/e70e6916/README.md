# [1041] 주사위 - Python

## :mag: Algorithm

**Greedy** 


## :round_pushpin: Logic

주사위의 각 면이 2개 또는 3개가 연결되어 있는 경우를 찾아야 한다. 이를 위해서는 
주사위에서 자신의 맞은 편에 있는 면을 제외하고 2개를 더 뽑으면 된다. 

```python
min_list = [min(dice[0], dice[5]), min(dice[1], dice[4]), min(dice[2], dice[3])]
min_list.sort()
```
주사위의 이러한 성질을 이용하여 위 코드처럼 서로 맞은 편에 있는 면 중 더 작은 값을 가진 
면을 뽑아 ```min_list```에 저장했고, 1~3개의 면을 뽑을 때 최소의 값을 가진 면을 뽑아야 함으로
```sort()```로 오름차순 정렬시켰다.

```python
    def create_cube(height):
        _sum, add = 0, 0
        if height == N-1: add = 1
        _sum += 4 * sum(min_list[i] for i in range(2+add))
        _sum += (N-2) * 4 * sum(min_list[i] for i in range(1+add))
        _sum += (N-2)**2 * sum(min_list[i] for i in range(0+add))
        return _sum
```
그 후, 위 코드의 ```create_cube```함수와 같은 정육면체의 층별 규칙적인 수식으로 N이 1보다 큰 경우의 최소값을 구할 수 있으며,
N이 1일 경우에는 주사위 각 면의 값들의 합에서 면들 중 가장 큰 값을 뺀 값을 구하면 된다. 


가장 위 층을 제외한 나머지 층들은 **하나의 층에 대해서만 최소합을 구한 후 그 값에 (N-1)을 곱해주어** 가장 위 층의
최소합에 더해주면 된다. 


## :memo: Review

쉽게 느껴진 문제라 금방 해결했지만 아직 그리디 알고리즘에 대해 감이 잡히진 않은듯 하다. 차차 다른 문제들을
풀어보며 익혀야겠다.