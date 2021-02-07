
a1 = input()
a2 = input()

short_cache = []

for a1_idx in range(0, len(a1)):
    for a2_idx in range(0, len(a2)):
        if a1[a1_idx] == a2[a2_idx]:
            short_cache.append([a1_idx,a2_idx])

num_arr = []

def lcs(start1,start2):
    cnt = 0
    temp = []

    for ele in short_cache:
        temp.append(lcs()) # next ele 들어가야함.
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




