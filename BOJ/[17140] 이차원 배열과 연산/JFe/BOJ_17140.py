import sys
r, c, k = map(int, sys.stdin.readline().split())
A = [[int(x) for x in sys.stdin.readline().split()] for _ in range(3)]
row_size, col_size = 3, 3

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