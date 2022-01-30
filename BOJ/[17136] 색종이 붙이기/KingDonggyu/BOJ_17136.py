def check_attach(paper, x, y, size):
    if x + size > 10 or y + size > 10:
        return False
    for i in range(x, x+size):
        for j in range(y, y+size):
            if paper[i][j] == 0:
                return False
    return True


# dfs
def attach_colored_paper(paper, cnt, one):
    global result

    if result != -1 and result < sum(cnt):
        return

    # 모든 1 제거한 경우
    if one == 0:
        if result == -1:
            result = sum(cnt)
        else:
            result = min(result, sum(cnt))
        return

    # 색종이 붙일 위치 찾기
    x, y = -1, -1
    for i in range(10):
        for j in range(10):
            if paper[i][j] == 1:
                x, y = i, j
                break
        if x != -1: break

    for size in range(1, 6):
        # 색종이를 전부 사용한 경우
        if cnt[size] == 5:
            continue
        # 색종이를 붙일 수 있는 경우
        if check_attach(paper, x, y, size):
            temp = []
            # 1을 0으로 변경
            for i in range(x, x+size):
                for j in range(y, y+size):
                    paper[i][j] = 0
                    temp.append((i, j))
            # 다음 색종이 붙이기 시행
            cnt[size] += 1
            attach_colored_paper(paper, cnt, one-size**2)
            # 원상 복귀
            cnt[size] -= 1
            for i, j in temp:
                paper[i][j] = 1
        

result = -1
paper = [[int(i) for i in input().split()] for _ in range(10)]

# 1의 총 개수 세기
one = 0
for i in range(10):
    for j in range(10):
        if paper[i][j] == 1:
            one += 1

attach_colored_paper(paper, [0, 0, 0, 0, 0, 0], one)
print(result)