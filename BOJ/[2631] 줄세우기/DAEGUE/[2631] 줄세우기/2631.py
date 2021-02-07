def main():
    N = int(input())
    number = []
    for i in range(0, N):
        tmp = int(input())
        number.append(tmp)
    cal(N, number)


def cal(N, num):
    res = [1 for i in range(N)]
    for i in range(N):
        for j in range(i):
            if num[j] < num[i]:
                res[i] = max(res[i], res[j] + 1)
    print(N - max(res))

main()