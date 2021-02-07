def main():
    N = int(input())
    A = list(map(int, input().split()))
    cal(N, A)

def cal(N, A):
    res = [1 for i in range(N)]
    tmp = []
    result = []
    max_num = int()
    for i in range(N):
        for j in range(i):
            if A[j] < A[i]:
                res[i] = max(res[i], res[j] + 1)
                tmp.append(A[j])
                max_num = A[i]

    for i in range(0, len(tmp)):
        if tmp[i] in result:
            continue
        else:
            result.append(tmp[i])
    result.append(max_num)

    print(max(res))
    print(result)


main()