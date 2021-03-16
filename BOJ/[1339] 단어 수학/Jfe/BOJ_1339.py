import sys
N = int(sys.stdin.readline())
words = [list(sys.stdin.readline()) for _ in range(N)]
alpha = []
num = 9
result = 0

def calculateDigit():
    alpha.append([0, 'A'])
    for i in range(N):
        for j in range(len(words[i])-1):
            change = False
            for k in range(len(alpha)):
                if words[i][j] == alpha[k][1]:
                    alpha[k][0] += pow(10, len(words[i]) - j - 2)
                    change = True
                    break
            if not change:
                alpha.append([pow(10, len(words[i]) - j - 2), words[i][j]])

calculateDigit()
alpha.sort(reverse=True)
for i in range(len(alpha)):
    result += num * alpha[i][0]
    num -= 1
print(result)