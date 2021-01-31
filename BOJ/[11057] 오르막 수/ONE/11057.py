N = int(input())
stair_num = [1] * 10 # 0~9 까지로 끝나는 수 한자리 숫자로 끝나게 되는 경우의 수 각각 1
for _ in range(N-1):
    for i in range(1, 10):
        stair_num[i] = (stair_num[i] + stair_num[i-1]) % 10007
print(sum(stair_num) % 10007)
