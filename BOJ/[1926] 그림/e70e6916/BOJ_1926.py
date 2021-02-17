size = list(map(int, input().split()))  # size[0] = 세로, size[1] = 가로
paper = [list(map(int, input().split())) for _ in range(size[0])]
picture = [[0] * size[1] for _ in range(size[0])]
direction = [[-1, 0], [1, 0], [0, -1], [0, 1]]

def search_picture(i, j):  # BFS
    if picture[i][j] > 0:
        return 0

    if paper[i][j] == 1:
        picture[i][j] = 1
        queue = [(i, j)]
        while queue:
            temp = queue.pop(0)
            for d in direction:
                x, y = temp[0] + d[0], temp[1] + d[1]
                if 0 <= x < size[0] and 0 <= y < size[1] and paper[x][y] == 1 and picture[x][y] == 0:
                    queue.append((x, y))
                    picture[x][y] = 1
                    picture[i][j] += 1
        return 1
    return 0

cnt = 0
for i in range(size[0]):
    for j in range(size[1]):
        cnt += search_picture(i, j)

print(cnt)
print(max(map(max, picture)))