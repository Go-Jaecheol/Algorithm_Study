# [17140] 이차원 배열과 연산 - Python

## 🔍 Algorithm
**시뮬레이션, 정렬**

## 💻 Logic

```Python
def sort(arr):
    d = {}
    rt = []
    for i in arr:
        # 0은 무시
        if i == 0: continue
        # 값이 key에 있으면 ++
        if i in d.keys(): d[i] += 1
        # 없으면 key-value 추가
        else: d[i] = 1
    # key 기준 sort
    d = dict(sorted(d.items()))
    # value 기준 sort
    temp = sorted(d.items(), key=lambda x:x[1])
    for i in range(len(temp)):
        # 100개 지나면 버림
        if i >= 100: break
        # key, value 순으로 append
        rt.append(temp[i][0])
        rt.append(temp[i][1])
    return rt
```

- 주어진 조건에 맞게 한 배열을 정렬하는 함수  
  - **수와 그 수의 등장 횟수를 key-value 형태로 dictionary에 저장**  
    값이 **key에 있으면** 해당 key의 **value**를 **+1**  
    **key에 없는 값이면** 해당 key를 **value** **1**로 매칭해서 저장  
  - **Sort 과정**  
    등장 횟수가 같으면 수가 커지는 순으로 정렬해야 하기 때문에 먼저, **key 기준으로 sort**  
    등장 횟수가 커지는 순으로 정렬해야 하기 때문에 **value 기준으로 sort**  
  - **리스트에 저장 후 return**  
    결과가 튜플 형태로 리스트에 저장되어 있기 때문에 `rt` 리스트에 key, value 순으로 **append**  
    크기가 **100**을 넘어가면 처음 100개를 제외하고 버려야해서 **break**  

---

```Python
def cal_R():
    global row_size
    # 행마다 정렬하고 최대 길이 계산
    for i in range(len(A)):
        A[i] = sort(A[i])
        row_size = max(len(A[i]), row_size)
    # 최대 길이보다 작으면 그만큼 0 추가
    for i in range(len(A)):
        if len(A[i]) < row_size:
            for _ in range(row_size-len(A[i])):
                A[i].append(0)
```

- R 연산 함수  
  - **행마다 정렬하고 최대 길이 계산**  
    반복문 돌면서 각 행마다 `sort` 함수 실행하고, `row_size` **최대 길이** 저장  
  - **최대 길이보다 작으면 그만큼 0 추가**  

---

```Python
def cal_C():
    global row_size, col_size
    # 열마다 정렬하고 최대 길이 계산
    for i in range(row_size):
        temp = []
        for j in range(col_size):
            temp.append(A[j][i])
            A[j][i] = 0
        temp = sort(temp)
        # 최대 길이보다 작으면 그만큼 0 추가
        for j in range(len(temp)):
            if j >= col_size:
                A.append([0 for _ in range(row_size)])
            A[j][i] = temp[j]
        col_size = max(len(temp), col_size)
```

- C 연산 함수  
  - **열마다 정렬하고 최대 길이 계산**  
    반복문 돌면서 각 열마다 값들을 새로운 `temp` 리스트에 저장한 후,  
    그 `temp` 리스트로 `sort` 함수 실행하고, `col_size` **최대 길이** 저장  
  - **최대 길이보다 작으면 그만큼 0 추가**  

---

```Python
count = 0
while True:
    # boundary 안에서 종료조건 확인
    if 0 < r <= col_size and 0 < c <= row_size:
        if A[r-1][c-1] == k: 
            break
    # 100초 지나면 종료하고 -1 출력
    if count >= 100:
        count = -1
        break
    # 행의 개수 >= 열의 개수면 R 연산
    if row_size <= col_size: cal_R()
    # 행의 개수 < 열의 개수면 C 연산
    else: cal_C()
    count += 1
print(count)
```

- 조건에 맞게 함수 실행하고, 종료 조건이 맞으면 걸린 시간 `count` 출력  


## 📝 Review

정렬하는 방법은 바로 딕셔너리가 생각나서 딕셔너리를 사용해서 빠르게 해결했다.  
행 기준으로 정렬하는 것까지는 빠르게 할 수 있었는데 열 기준으로 정렬하는 과정에서 어떻게 효율적으로 할지 고민을 조오금 했다.  
전치행렬로 바꿔서 하면 되겠다고 생각했는데 numpy는 사용 못한다고 해서 그냥 반복문으로 품,,  

r, c, k 입력에서 r, c 값이 3보다 큰 값이 들어올 수도 있다는 것을 생각 못해서 런타임에러 났었음,,  
