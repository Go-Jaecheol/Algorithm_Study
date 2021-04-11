N = int(input())
alpha = [0 for _ in range(26)]

for _ in range(N):
    word = input()
    word_len_10 = int(pow(10, len(word) - 1))
    for i in range(len(word)):
        alpha[ord(word[i]) - 65] += word_len_10
        word_len_10 /= 10

alpha.sort(reverse=True)

ans = 0
cnt = 9

for j in alpha:
    if j == 0:
        break;
    ans += j * cnt
    cnt -= 1
print(int(ans))
