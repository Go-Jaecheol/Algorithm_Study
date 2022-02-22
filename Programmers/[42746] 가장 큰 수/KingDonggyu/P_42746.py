from functools import cmp_to_key

def comp(a, b):
    return 1 if a+b <= b+a else -1

def solution(numbers):
    return str(int("".join(sorted((list(map(str, numbers))), key=cmp_to_key(comp)))))