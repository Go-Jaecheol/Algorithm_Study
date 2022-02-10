import math
from itertools import permutations

def solution(numbers):
    answer = 0
    num = []
    for i in range(len(numbers)):
        temp = list(map("".join, permutations(numbers, i+1)))
        num += list(map(int, temp))
        
    for s in set(num):
        x = int(s)
        if x < 2: continue
        for i in range(2, int(math.sqrt(x))+1):
            if x % i == 0:
                x = False
                break
        if x: answer += 1
    
    return answer