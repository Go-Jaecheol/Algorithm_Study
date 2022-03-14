# [17406] 배열 돌리기 4 - Python

## 🔍 Algorithm
**Brute Force**

## 💻 Logic

```Python
def rotate(r,c,s):
    start_y, start_x, last_y, last_x = r-s-1, c-s-1, r+s-1, c+s-1
    count = (last_x - start_x) // 2
    for i in range(count):
        rightup, rightdown, leftdown = copy_arr[start_y][last_x], copy_arr[last_y][last_x], copy_arr[last_y][start_x]
        # 윗줄 가로
        for j in reversed(range(start_x, last_x)):
            copy_arr[start_y][j+1] = copy_arr[start_y][j]
        # 오른쪽 세로
        for j in reversed(range(start_y, last_y)):
            copy_arr[j+1][last_x] = copy_arr[j][last_x]
        copy_arr[start_y+1][last_x] = rightup
        # 아랫줄 가로
        for j in range(start_x, last_x-1):
            copy_arr[last_y][j] = copy_arr[last_y][j+1]
        copy_arr[last_y][last_x-1] = rightdown
        # 왼쪽 세로
        for j in range(start_y, last_y-1):
            copy_arr[j][start_x] = copy_arr[j+1][start_x]
        copy_arr[last_y-1][start_x] = leftdown
        start_y, start_x, last_y, last_x = start_y+1, start_x+1, last_y-1, last_x-1
```

- 회전 연산 함수  
  - **윗줄 가로, 오른쪽 세로, 아랫줄 가로, 왼쪽 세로 4가지로 나눠서 계산**  
    꼭짓점 정보를 미리 저장해두고, 각 라인에 맞게 한칸씩 이동

---

```Python
N, M, K = map(int, sys.stdin.readline().split())
arr = [[int(x) for x in sys.stdin.readline().split()] for _ in range(N)]
rot = [[int(x) for x in sys.stdin.readline().split()] for _ in range(K)]
rot_len = [int(x) for x in range(0, len(rot))]
order_list = permutations(rot_len, len(rot))
result = sys.maxsize

for order in order_list:
    order = list(order)
    copy_arr = copy.deepcopy(arr)
    for i in order:
        rotate(rot[i][0], rot[i][1], rot[i][2])
    for j in range(0, N):
        result = min(result, sum(copy_arr[j]))
print(result)
```

- 순열을 이용해 가능한 순서 경우의 수를 다 만들고,  
- 가능한 경우의 수마다 회전 연산을 하고 최솟값을 구한 뒤 최솟값 출력  
- 각 경우의 수마다 원본 리스트를 보존하기 위해 **deepcopy** 후 회전 연산 수행  


## 📝 Review

이전 문제와 비슷하게 순열을 이용해서 해결하는 문제여서 구현에는 크게 문제가 없었다.  
각 회전 연산마다 최솟값을 구해야하는줄 잘못 알았던 것만 빼면,,
