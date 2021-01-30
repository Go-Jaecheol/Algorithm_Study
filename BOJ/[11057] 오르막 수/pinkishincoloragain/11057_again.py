
N = int(input())

arr = [1,1,1,1,1,1,1,1,1,1]

for i in range(0,N-1):
    for j in range(0,9):
        arr[j+1] = arr[j+1] + arr[j]

    for k in range(0,9):
        arr[k] = arr[k] % 10007

print(sum(arr) % 10007)
