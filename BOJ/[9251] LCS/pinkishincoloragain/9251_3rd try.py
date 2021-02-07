
a1 = input()
a2 = input()


cache = list(list(-1 for _ in range(0,len(a1))) for _ in range(0,len(a2)))
# short_cache = list()

for a1_idx in range(0, len(a1)):
    for a2_idx in range(0, len(a2)):
        if a1[a1_idx] == a2[a2_idx]:
            cache[a1_idx][a2_idx] = 1

num_arr = []

def lcs(start1,start2):
    cnt = 0
    temp = []

    for i in range(start1, len(a1)):
        for j in range(start2, len(a2)):
            if cache[i][j] == 1:
                temp.append(lcs(i+1,j+1))
                cnt+=1

    if cnt == 0:
        return 0

    max_num = max(temp) + 1
    num_arr.append(max_num)

    return max_num



lcs(0,0)

print(max(num_arr))

# print(num_arr)
#
# print(cache)




