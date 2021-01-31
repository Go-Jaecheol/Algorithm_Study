N = int(input())
ary = [0] * 1001
sequence = list(map(int, input().split()))

for i in sequence:
    ary[i] = max(ary[:i]) + 1

print(max(ary))
