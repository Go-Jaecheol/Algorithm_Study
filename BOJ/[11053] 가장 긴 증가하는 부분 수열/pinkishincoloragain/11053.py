A = []
N = int(input())

# def find(start, idx):
#
#     for i in range(0,N):
#         cur_max = 0
#
#         for j in range(0,i-1):
#             find(range(j-1,cur_max(len(cur_max))))


A = list(map(int, input().split()))

result = [0 for _ in range(0,N)]
result[0] = 1

for i in range(N):

    cur_max = 0

    for j in range(0,i):
        if A[i] > A[j]:
            if cur_max < result[j]:
                cur_max = result[j]

    result[i] = cur_max + 1

print(max(result))

