N = int(input())
matrix = []

for _ in range(N):
    matrix.append(list(map(int, input())))

def search_matrix(n, start_x, start_y):
    data = matrix[start_x][start_y]
    for x in range(n):
        for y in range(n):
            if data != matrix[start_x + x][start_y + y]:
                return divide_paper(n, start_x, start_y)
    print(data, end='')

def divide_paper(n, start_x, start_y):
    size = n // 2
    print('(', end='')
    for x in range(n // size):
        for y in range(n // size):
            search_matrix(size, start_x + x * size, start_y + y * size)
    print(')', end='')

search_matrix(N, 0, 0)

