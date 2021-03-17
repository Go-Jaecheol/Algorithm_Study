import sys
N = int(sys.stdin.readline())
words = list(list(sys.stdin.readline().rstrip()) for _ in range(N))
word_data = {}
_sum, value = 0, 9

for i in range(N):
    words_len = len(words[i])
    for j in range(words_len):
        if words[i][j] not in word_data:
            word_data[words[i][j]] = 0
        word_data[words[i][j]] += 10 ** (words_len - j - 1)

for x in sorted(word_data.values(), reverse=True):
    _sum += value * x
    value -= 1
print(_sum)
