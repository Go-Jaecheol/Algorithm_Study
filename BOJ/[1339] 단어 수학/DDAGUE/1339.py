N = int(input())

word = []
for i in range(N):
    word.append(input())

dict= {}
for w in word:
    lengh = len(w) -1
    for spell in w:
        if spell in w:
            dict[spell] += pow(10, lengh)
        else:
            dict[spell] = pow(10, lengh)
        lengh -= 1
num = []

for value in dict.values():
    num.append(value)
num.sort(reverse=True)

result = 0
tmp = 9

for i in range(len(num)):
    result += num[i] * tmp
    tmp -= 1
print(result)