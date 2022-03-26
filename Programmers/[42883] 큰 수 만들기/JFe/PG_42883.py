import sys
def solution(number, k):
    answer, cnt = [], 0
    number = list(number)
    for n in number:
        if 0 < len(answer):
            while cnt < k and answer[-1] < n:
                answer.pop()
                cnt += 1
                if 0 == len(answer): break
        answer.append(n)
    if cnt != k:
        for _ in range(k-cnt):
            answer.pop()
    answer = "".join(answer)
    return answer