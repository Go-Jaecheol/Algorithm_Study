N = int(input())
num = [int(input()) for _ in range(N)]
num.insert(0, 0)
visited = [0] * (N+1)

def dfs(x, set_x):
    if visited[x] == 1:
        return
    visited[x] = 1

    if x == num[x]:
        add_set.append(x)
        return
    set_x.append(x)

    global max_set
    check = 0
    for i in range(1, N+1):
        if x == num[i]:
            check += 1

            if i in set_x:
                temp = 0
                for x in set_x:
                    if x in max_set: temp += 1
                if temp == 0:
                    max_set.extend(set_x)
                elif len(set_x) > len(max_set):
                    max_set = set_x
                return

            temp = set_x.copy()
            dfs(i, temp)
    if check == 0:
        return

add_set, max_set = [], []
for i in range(1, N+1):
    dfs(i, [])

max_set.extend(add_set)
max_set.sort()
print(len(max_set))
for i in max_set: print(i)