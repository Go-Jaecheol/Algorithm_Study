def main():
    N = int(input())
    cal(N)


def cal(N):
    num = [[0 for i in range(10)] for j in range(N+1)]
    for i in range(1, N+1):
        if i == 1:
            num[i] = [0, 1, 1, 1, 1, 1, 1, 1, 1, 1]
        else:
            for j in range(10):
                if j == 0:
                    num[i][j] = num[i - 1][j + 1]
                elif j == 9:
                    num[i][j] = num[i - 1][j - 1]
                else:
                    num[i][j] = num[i - 1][j - 1] + num[i - 1][j + 1]
    result = sum(num[N]) % 1000000000
    print(result)

main()