N = int(input())
ary = [0] * 1001
sequence = list(map(int, input().split()))
ans = []
for i in sequence:
    ary[i] = max(ary[:i]) + 1
    ans.append(ary.index(max(ary[:i])))
print(max(ary))
tmp = ary.index(max(ary))


def trc_back(n):
    if n < 1:
        return
    num_idx = sequence.index(n)
    trc_back(ans[num_idx])
    print(n, end=" ")


trc_back(tmp)
