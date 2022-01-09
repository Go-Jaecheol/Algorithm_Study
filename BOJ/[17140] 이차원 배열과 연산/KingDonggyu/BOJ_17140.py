import copy
r, c, k = map(int, input().split()); r -= 1; c-=1
A = [[int(i) for i in input().split()] for _ in range(3)]

def init_dict(list):
    dict = {}
    for v in list:
        if v == 0: continue
        if v in dict: dict[v] += 1
        else: dict[v] = 1
    return dict

def sort(dict):
    list = [];
    for key, value in sorted(dict.items()):
        if len(list) == 100: break
        list += [key, value]; cnt = len(list)
        while cnt >= 4 and list[cnt-1] < list[cnt-3]:
            list[cnt-4], list[cnt-2] = list[cnt-2], list[cnt-4]
            list[cnt-3], list[cnt-1] = list[cnt-1], list[cnt-3]
            cnt -= 2
    return list

def R():
    global col_cnt
    line_cnt = 0
    for i in range(row_cnt):
        A[i] = sort(init_dict(A[i]))
        if line_cnt < len(A[i]): line_cnt = len(A[i])
        col_cnt = line_cnt
    # 0 채우기
    for i in range(row_cnt):
        for _ in range(col_cnt - len(A[i])): A[i].append(0)

def C():
    global A, row_cnt
    line_cnt = 0
    next_A = [[0 for _ in range(col_cnt)] for _ in range(col_cnt)]
    for i in range(col_cnt):
        temp = sort(init_dict([a[i] for a in A]))
        if line_cnt < len(temp): line_cnt = len(temp)
        row_cnt = line_cnt
        # 배열 A 업데이트 및 0 채우기
        for x, v in enumerate(temp):
            try: next_A[x][i] = v
            except:
                next_A.append([0 for _ in range(col_cnt)])
                next_A[x][i] = v
    A = copy.deepcopy(next_A)

def start_calculation():
    second = 0
    for s in range(101):
        try: 
            if A[r][c] == k: break
        except: pass
        if row_cnt >= col_cnt: R()
        else: C()
        second = s + 1
    if second == 101: return -1
    return second

row_cnt, col_cnt = 3, 3
print(start_calculation())