num = int(input())
## row: n번째 계단, col: col의 숫자로 시작
## 2차원 배열 생성
stair_num = [[0 for _ in range(10)] for _ in range(num + 1)]

for i in range(1, num + 1): # 1 부터 N 계단까지
    for j in range(10): # 0 ~ 9까지
        if i == 1:
            stair_num[i][j] = 1
        else:
            if j == 0: # 0으로 시작 -> N-1번째의 1로 시작하는 계단수
                stair_num[i][j] = stair_num[i-1][1]
            elif j == 9: # 9로 시작 -> N-1번째의 8로 시작하는 계단수
                stair_num[i][j] = stair_num[i-1][8]
            else: # 1~8로 시작 -> N-1번째의 j-1과 j+1 을 더한값
                stair_num[i][j] = stair_num[i-1][j-1] + stair_num[i-1][j+1]
print(sum(stair_num[num][1:10]) % 1000000000)
