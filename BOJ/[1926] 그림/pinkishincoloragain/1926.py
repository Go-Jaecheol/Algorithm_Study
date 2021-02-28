
import sys
sys.setrecursionlimit(30000)

n,m = map(int, input().split())
p = []
visited = []

for i in range(n):
    p.append(list(map(int, input().split())))
    visited.append(list(-1 for _ in range(0,m)))

photos = list(list(0 for i in range(m)) for _ in range(n))

def def_photo(idx1,idx2,res):
    if visited[idx1][idx2] == 1:
        return 0
    visited[idx1][idx2] = 1

    if p[idx1][idx2] == 1:
        res += 1

    # right
    if idx2 != m-1 and p[idx1][idx2+1] == 1 and visited[idx1][idx2+1] != 1:
        res += def_photo(idx1,idx2+1, 0)
    # left
    if idx2 != 0 and p[idx1][idx2-1] == 1 and visited[idx1][idx2-1] != 1:
        res += def_photo(idx1,idx2-1, 0)
    # up
    if idx1 != 0 and p[idx1-1][idx2] == 1 and visited[idx1-1][idx2] != 1:
        res += def_photo(idx1-1,idx2, 0)
    # down
    if idx1 != n-1 and p[idx1+1][idx2] == 1 and visited[idx1+1][idx2] != 1:
        res += def_photo(idx1+1,idx2, 0)

    # print(idx1, idx2, res)

    return res


cnt = 0
max_num = 0

for i in range(0,n):
    for j in range(0,m):
        if p[i][j] == 1 and visited[i][j] != 1:
            photos[i][j] = def_photo(i,j,0)
            if photos[i][j] != 0:
                cnt+=1
            if max_num < photos[i][j]:
                max_num = photos[i][j]

#
# print(p)
# print(visited)
#
# print(photos)
print(cnt)
print(max_num)

