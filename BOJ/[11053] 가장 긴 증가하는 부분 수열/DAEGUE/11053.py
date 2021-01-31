def main():
    N = int(input())
    A = list(map(int, input().split()))
    cal(N, A)

def cal(N, A):
    res = [1 for i in range(N)]
    for i in range(N):
        for j in range(i):
            if A[j] < A[i]:
                res[i] = max(res[i], res[j] + 1)
    print(max(res))

main()