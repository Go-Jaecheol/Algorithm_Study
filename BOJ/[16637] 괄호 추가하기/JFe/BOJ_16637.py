import sys
from itertools import combinations

def prior_cal(comb):
    temp, cnt, new_num, new_operator = [], [], [], []
    for i in comb:
        first, second = num[i], num[i+1]
        cnt.append(i)
        cnt.append(i+1)
        if operator[i] == "+": temp.append(first+second)
        elif operator[i] == "-": temp.append(first-second)
        elif operator[i] == "*": temp.append(first*second)
    for i, n in enumerate(num):
        if i not in cnt:
            new_num.append(n)
        else:
            new_num.append(temp[i])
    for i, op in enumerate(operator):
        if i not in comb:
            new_operator.append(op)
    return_list = [new_num, new_operator]
    return return_list

N = int(sys.stdin.readline().split())
exp = sys.stdin.readline()
num, operator = [], []
for i in len(exp):
    if i % 2 == 0: num.append(int(exp[i]))
    else: operator.append(exp[i])
for i in len(operator):
    comb_list = combinations([int(x) for x in range(len(operator))], i+1)
    for comb in comb_list:
        comb = list(comb)
        temp = prior_cal(comb)
        num, operator = temp[0], temp[1]
