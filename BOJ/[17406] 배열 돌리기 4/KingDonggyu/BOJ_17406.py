import sys, copy
from itertools import permutations
input = sys.stdin.readline


def rotate(r, c, s):
    for cnt in range(((r+s) - (r-s)) // 2):
        t1 = copy_A[r-s+cnt][c+s-cnt]
        t2 = copy_A[r+s-cnt][c+s-cnt]
        t3 = copy_A[r+s-cnt][c-s+cnt]
        # right
        for i in reversed(range(c-s+cnt, c+s-cnt)):   
            copy_A[r-s+cnt][i+1] = copy_A[r-s+cnt][i]
        # down
        for i in reversed(range(r-s+cnt, r+s-cnt)):
            copy_A[i+1][c+s-cnt] = copy_A[i][c+s-cnt]
        copy_A[r-s+cnt+1][c+s-cnt] = t1
        # left
        for i in range(c-s+cnt, c+s-cnt):
            copy_A[r+s-cnt][i] = copy_A[r+s-cnt][i+1]
        copy_A[r+s-cnt][c+s-cnt-1] = t2
        # up
        for i in range(r-s+cnt, r+s-cnt):
            copy_A[i][c-s+cnt] = copy_A[i+1][c-s+cnt]
        copy_A[r+s-cnt-1][c-s+cnt] = t3


N, M, K = map(int, input().split())
A = [0] + [[0] + [int(i) for i in input().split()] for _ in range(N)]
rot = [[int(i) for i in input().split()] for _ in range(K)] 

result = sys.maxsize
for order in list(permutations([i for i in range(0, K)], K)):
    copy_A = copy.deepcopy(A)
    for i in order:
        rotate(rot[i][0], rot[i][1], rot[i][2])
    for i in range(1, N+1):
        result = min(result, sum(copy_A[i]))

print(result)