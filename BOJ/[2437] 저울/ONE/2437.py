N = int(input())
weights = list(map(int, input().split()))

weights.sort()

ans = 0
for i in range(N):
    if ans + 1 < weights[i]:
        break
    ans += weights[i]

print(ans + 1)