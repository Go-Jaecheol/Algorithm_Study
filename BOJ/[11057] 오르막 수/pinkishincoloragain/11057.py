
# 중복조합 구현 - 10Hn
import sys

N = int(input())

cal = 1
bunmo = []

for i in range(0,N):
    cal = cal * (10+N-1-i)

    cal = cal // (i+1)

    if cal % 10007 != 0:
        cal = cal % 10007

    print(cal)

print(cal % 10007)


