# [17779] 게리맨더링 2 - Python

## :mag: Algorithm
**시뮬레이션, Brute Force**

## :computer: Logic

```Python
def divide_area(x, y, d1, d2):
    sum = [0 for _ in range(5)]
    isFiveArea = [[False for _ in range(N)]for _ in range(N)]

    # 5번 선거구 경계선 채우기
    for i in range(d1+1): isFiveArea[x+i][y-i] = True
    for i in range(d2+1): isFiveArea[x+i][y+i] = True
    for i in range(d1+1): isFiveArea[x+d2+i][y+d2-i] = True
    for i in range(d2+1): isFiveArea[x+d1+i][y-d1+i] = True

    # 5번 선거구 경계선 안쪽 채우기
    for i in range(x+1, x+d1+d2):
        check = 0   # 0: default, 1: 5구역 경계 시작, 2: 5구역 경계 끝
        for j in range(N):
            if isFiveArea[i][j]: check += 1
            if check == 1: isFiveArea[i][j] = True
            elif check == 2: break
    
    # 선거구 인구 계산
    for i in range(N):
        for j in range(N):
            if isFiveArea[i][j]:
                sum[4] += population[i][j]
            else:
                if 0 <= j <= y and 0 <= i < x+d1:
                    sum[0] += population[i][j]
                elif y < j < N and 0 <= i <= x+d2:
                    sum[1] += population[i][j]
                elif 0 <= j < y-d1+d2 and x+d1 <= i < N:
                    sum[2] += population[i][j]
                elif y-d1+d2 <= j < N and x+d2 < i < N:
                    sum[3] += population[i][j]
    return max(sum) - min(sum)
```

- 문제에서 제시한 것처럼 순서대로 구역을 나누고 선거구별 인구 계산하는 함수  
  - **5번 선거구 경계선 채우기**  
    5번 선거구인지 아닌지를 나타내는 `isFiveArea` 리스트 선언 후  
    제시된 경계선 나누는 방법에 따라 해당하는 `isFiveArea` 값 **True**로 변경  
  - **5번 선거구 경계선 안쪽 채우기**  
    이중 for문을 이용해서 위에서부터 아래로, 왼쪽에서 오른쪽으로 5번 선거구 경계선 안에 해당하는지 확인  
    해당 행에서 경계선이 나오면 `check` 변수를 **+1**,  
    check가 1이면 경계선 안이기 때문에 해당하는 `isFiveArea` 값을 **True**로 변경  
    해당 행에서 경계선이 끝나는 부분이 나오면 check가 2일 것이므로, **break**  
  - **선거구별 인구 계산**  
    선거구별 인구수 합을 저장할 `sum` 리스트 생성  
    `isFiveArea` 값이 **True**면 5번 선거구 인구 합에 인구수 더함  
    나머지 선거구들도 제시된 식에 맞게 계산해서 해당하는 `sum` 리스트 값에 인구수 더함  
    마지막으로 `sum` 리스트에서 **max값과 min값의 차**를 return  

---

```Python
result = sys.maxsize
for x in range(1, N+1):
    for y in range(1, N+1):
        for d1 in range(1, N+1):
            for d2 in range(1, N+1):
                if 1 <= x < x+d1+d2 <= N and 1 <= y-d1 < y < y+d2 <= N:
                    result = min(result, divide_area(x-1, y-1, d1, d2))
print(result)
```

- **기준점(x,y)과 d1, d2를 설정해서 최솟값 계산**  
  제시된 식에 맞게 **d1, d2**를 설정한 후, `divide_area` 함수 실행,  
  실행된 결과와 원래 `result` 의 **min값**을 다시 `result` 에 저장  
  반복문 실행 후, `result` 출력  

## :memo: Review
처음에는 5번 선거구가 특이 케이스라는 것을 모르고 1번 선거구부터 주어진 식에 맞춰서 나눈 다음에 계산하려고 했다.  
그러다가 뭔가 잘못된 것을 깨닫고 문제를 다시 읽은 후, 문제에서 제시된 순서대로 구현해나갔다.  
(r,c)와 (x,y) 순서에서 계속 헷갈려서 풀이에 시간을 많이 쓴건 흠,,  
다 풀고나니 코드 곳곳에서 효율적이지 않은 부분들이 보이는데 이건 차근차근 고쳐나가야지  
