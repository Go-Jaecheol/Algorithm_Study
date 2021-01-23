num = {-1: {'count': 0}, 0: {'count': 0}, 1: {'count': 0}}
N = int(input())
matrix = []

for _ in range(N):
    matrix.append(list(map(int, input().split())))

def search_paper(n, start_x, start_y):
    matrix_value = matrix[start_x][start_y]
    for x in range(n):
        for y in range(n):
            if matrix_value != matrix[start_x + x][start_y + y]:
                return divide_paper(n, start_x, start_y)
    num[matrix_value]['count'] += 1

def divide_paper(n, start_x, start_y):
    size = n // 3
    for x in range(n // size):
        for y in range(n // size):
            search_paper(size, start_x + x * size, start_y + y * size)

search_paper(N, 0, 0)
print(num[-1]['count'])
print(num[0]['count'])
print(num[1]['count'])
