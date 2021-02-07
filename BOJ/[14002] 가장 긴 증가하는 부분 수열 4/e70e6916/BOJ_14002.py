N = int(input())
A = list(map(int, input().split()))
len_data = [1] * N
seq_data = [[0] * N for _ in range(N)]

for i in range(N):
    for j in reversed(range(i)):
        if A[i] > A[j] and len_data[i] <= len_data[j]:
            len_data[i] = len_data[j] + 1
            seq_data[i] = seq_data[j].copy()
    seq_data[i][i] = 1
    print(seq_data)

max_len = max(len_data)
last_num = len_data.index(max_len)
print(max_len)

for i, v in enumerate(seq_data[last_num]):
    if v == 1:
        print(A[i], end=' ')