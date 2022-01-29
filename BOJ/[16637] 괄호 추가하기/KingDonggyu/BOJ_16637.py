import sys
from itertools import combinations


def calculate(op, v1, v2):
    if op == '+': 
        return v1 + v2
    elif op == '-':
        return v1 - v2
    else:
        return v1 * v2


N = int(input())
math = []

for i, c in enumerate(list(input())):
    if i%2 == 0: c = int(c)
    math.append(c)

result = -sys.maxsize
max_bracket = (N // 2) // 2 + (N // 2) % 2
bracket_num = [i for i in range(N // 2)]

for i in range(max_bracket+1):
    for brackets in list(combinations(bracket_num, i)):
        new_math = []
        check = -1

        # 중첩 괄호 확인
        for x in range(i):
            if x > 0 and brackets[x] - brackets[x-1] == 1:
                check = -2; break

        if check == -2: continue
        brackets = list(map(lambda x: x*2, brackets))

        # 괄호 수식 계산 
        for x in range(N):
            if x <= check: continue
            if x in brackets:
                new_math.append(calculate(math[x+1], math[x], math[x+2]))
                check = x+2
            else:
                new_math.append(math[x])
        
        # 남은 수식 계산
        num = new_math[0]
        for x in range(0, len(new_math)-2, 2):
            num = calculate(new_math[x+1], num, new_math[x+2])

        result = max(result, num)

print(result)