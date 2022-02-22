# [17281] ⚾ - Python

## 🔍 Algorithm
**Brute Force**

## 💻 Logic

```Python
def hit_result(batter):
    global out, run, b1, b2, b3
    hit = inning[cur_inning][batter]
    
    # 아웃
    if hit == 0:
        out += 1
        return
    # 홈런
    if hit == 4:
        run += b1 + b2 + b3 + 1
        b1, b2, b3 = 0, 0, 0
        return
    # 3루 주자 있는 경우
    if b3 == 1:
        b3 = 0
        run += 1
    # 2루 주자 있는 경우
    if b2 == 1:
        b2 = 0
        if hit > 1: run += 1
        else: b3 = 1
    # 1루 주자 있는 경우
    if b1 == 1:
        b1 = 0
        if hit > 2: run += 1
        elif hit == 2: b3 = 1
        else: b2 = 1
    # 타자 주자 이동
    if hit == 1: b1 = 1
    elif hit == 2: b2 = 1
    elif hit == 3: b3 = 1
```

- 타격 결과에 따라 주자 진루하는 함수  
  - **아웃인 경우**  
    `out` 카운트 ***1*** 올려주고 **return**  
  - **홈런인 경우**  
    베이스별 주자 카운트 + 1을 `run`에 더해주고,  
    베이스별 주자 정보 ***0***으로 바꾸고 **return**  
  - **주자 상황별 진루**  
    1루, 2루, 3루 주자 상황에 따라 다르게 계산  
    타자 주자도 `hit` 정보에 따라 진루  

---

```Python
N = int(sys.stdin.readline())
inning = [[int(x) for x in sys.stdin.readline().split()] for _ in range(N)]
order_list = permutations([1,2,3,4,5,6,7,8], 8)
result = 0

for order in order_list:
    order = list(order)
    order.insert(3, 0)
    cur_inning, run, out = 0, 0, 0
    b1, b2, b3 = 0, 0, 0
    while cur_inning < N:
        for batter in order:
            hit_result(batter)
            if out == 3: 
                cur_inning += 1
                out = 0
                b1, b2, b3 = 0, 0, 0
            if cur_inning == N: break
    result = max(result, run)
print(result)
```

- 순열을 이용해 가능한 순서 경우의 수를 다 만들고,  
- 가능한 경우의 수마다 득점을 구해서 **max** 값 출력  


## 📝 Review

야구 관련 문제여서 기대하고 시작했지만 시간초과 때문에 마음에 들지않는 문제였다.  

순열을 사용해야 된다는 것을 알고나서 permutation을 이용해서 문제를 해결했지만, 시간초과가 발생했다.  
시간초과를 줄일 방법이 생각나지 않아서 다른 사람들의 코드에서 힌트를 얻었고  
리스트로 저장해두었던 base 정보를 각각 b1, b2, b3로 방식을 바꿔서 시간초과 문제를 해결했다.
