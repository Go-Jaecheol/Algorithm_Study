# [13023] ABCDE - Python

## :mag: Algorithm

**DFS**


## :round_pushpin: Logic

```python
    people = list([] for _ in range(N))
    for _ in range(M):
        x, y = map(int, input().split())
        people[x].append(y)
        people[y].append(x)
```
친구 관계에 대한 입력을 그대로 2차원 리스트로 받지 않고 위 코드와 같이 **인덱스 값에 대한 리스트에 친구 값들을
각각 입력 받았다**.  ( →  **시간초과**를 해결할 수 있었음    )


```python
    for p in people[person]:
        if not visited[p]:
            find_friend(p, friend+1)
            visited[p] = False
```
그 후 리스트 ```people```을 위 코드와 같이 DFS를 통해 탐색하며 깊이(freind)가 4가 되는 순간 1을 출력하고, 프로그램을 종료시킨다.


0부터 N-1까지 반복문을 통해 DFS를 각각 수행했음에도 1을 출력함과 동시에 프로그램이 종료되지 않는다면, 
0을 출력한다.


## :memo: Review

그다지 어려운 문제는 아니였지만, 시간초과로 인해 애먹었다. 어떻게 시간초과를 해결할 수 있을지 고민하다 DFS를 위한
```people```리스트 전체를 반복문으로 돌리는게 눈에 계속 거슬렸고, 위 로직과 같은 방식으로 입력을 받으니 
반복문의 반복을 훨씬 줄일 수 있었다. 그러자 다행히도 시간초과를 해결할 수 있었다. 

시간초과를 해결한 후 갑자기 틀렸다는 결과가 나왔고, 이 때문에 반례를 만들기 위해 계속 시도했다. 결국 반례를 찾았는데, 
한번 방문한 수에 대해 ```True```로 설정해둔 것 때문에 또다시 재방문이 필요한 경우가 제외되버리는 것이었다. 
그래서 재귀 후 방문한 수에 대해 ```False```로 다시 설정해두어 해결했다.

요즘따라 반례를 찾는 것이 참 힘든 것 같다...... 