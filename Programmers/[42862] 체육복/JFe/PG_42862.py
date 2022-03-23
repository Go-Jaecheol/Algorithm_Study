def solution(n, lost, reserve):
    answer, dup_list = 0, []
    # lost, reserve 중복 확인
    for i in reserve:
        if i in lost:
            dup_list.append(i)
    # 중복 제거
    lost = list(set(lost) - set(dup_list))
    reserve = list(set(reserve) - set(dup_list))
    # 왼쪽부터 확인하고 빌려주기
    for i in reserve:
        if i - 1 > 0 and i - 1 in lost:
            lost.remove(i-1)
        elif i + 1 <= n and i + 1 in lost:
            lost.remove(i+1)
    answer = n - len(lost)
    return answer