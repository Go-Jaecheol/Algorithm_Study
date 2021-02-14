

N, K = input().split()
N = int(N)
K = int(K)

items = []
cache = list(list(-1 for _ in range(2)) for _ in range(N))


for i in range(N):
    items.append(list(map(int, input().split())))

# print(items)

def inbag(idx,cur_v,rest_k):

    # print(idx,cur_v,rest_k)


    if idx == N or rest_k == 0:
        # print("case 1")
        return cur_v

    elif rest_k >= items[idx][0]:
        # print("case 2")
        return max(inbag(idx+1,cur_v+items[idx][1],rest_k-items[idx][0]),
                   inbag(idx+1,cur_v,rest_k))

    else:
        # print("case 3")
        return inbag(idx+1,cur_v,rest_k)


print(inbag(0,0,K))



