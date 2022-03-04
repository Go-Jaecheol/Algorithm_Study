import sys, copy
from itertools import combinations

def prior_cal(comb):
    cnt, new_num, new_operator, check = [], [], [], False
    temp = copy.deepcopy(copy_num)
    # 조합에 따라 계산
    for i in comb:
        first, second = copy_num[i], copy_num[i+1]
        cnt.append(i)
        cnt.append(i+1)
        # 연산자에 맞게 계산
        if copy_operator[i] == "+": temp[i] = first + second
        elif copy_operator[i] == "-": temp[i] = first - second
        elif copy_operator[i] == "*": temp[i] = first * second
    # 계산 완료된 새로운 num 리스트 생성
    for i, n in enumerate(copy_num):
        # 계산에 사용되지 않은 숫자면 그대로 추가
        if i not in cnt:
            new_num.append(n)
        # 계산에 사용됐으면 계산 완료된 숫자 한번만 추가
        elif not check:
            new_num.append(temp[i])
            check = True
        elif check:
            check = False
    # 새로운 operator 리스트도 생성
    for i, op in enumerate(copy_operator):
        if i not in comb:
            new_operator.append(op)
    return_list = [new_num, new_operator]
    return return_list

def cal():
    # 남은 연산자들에 맞게 전부 다 계산
    while copy_operator:
        first, second = copy_num[0], copy_num[1]
        if copy_operator[0] == "+": copy_num[1] = first + second
        elif copy_operator[0] == "-": copy_num[1] = first - second
        elif copy_operator[0] == "*": copy_num[1] = first * second
        del copy_operator[0]
        del copy_num[0]
    return copy_num[0]

N = int(sys.stdin.readline())
exp = sys.stdin.readline()
num, operator, result = [], [], -sys.maxsize
# 문자열 분리
for i in range(len(exp)-1):
    if i % 2 == 0: num.append(int(exp[i]))
    else: operator.append(exp[i])
# 연산자없이 숫자 하나만 있을 때, 예외 처리
if len(operator) == 0: result = num[0]
# 연산자 수에 맞게 조합 생성해서 최댓값 계산
for i in range(len(operator)):
    comb_list = combinations([int(x) for x in range(len(operator))], i+1)
    for comb in comb_list:
        comb = list(comb)
        check = False
        # 괄호가 연속되는지 확인하고, 연속되면 continue
        for j in range(len(comb)-1):
            if comb[j+1] - comb[j] == 1:
                check = True
                break
        if check: continue
        copy_num, copy_operator = copy.deepcopy(num), copy.deepcopy(operator)
        temp = prior_cal(comb)
        copy_num, copy_operator = temp[0], temp[1]
        result = max(result, cal())
print(result)