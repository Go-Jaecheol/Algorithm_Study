def main():
    N = int(input())
    cal(N)

def cal(N):
    num = [[0 for i in range(10)] for j in range(N+1)]
    num[0] = [1 for i in range(10)]
    for i in range(1, N):
        for j in range(10):
            for k in range(j, 10):
                num[i][k] += num[i-1][j]
    print(sum(num[N-1]) % 10007)

main()