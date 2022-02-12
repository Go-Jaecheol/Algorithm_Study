def solution(priorities, location):
    answer = 0
    q = [(i, v) for i, v in enumerate(priorities)]
    
    while True:
        i, v = q.pop(0)
        if q and max(q, key=lambda x: x[1])[1] > v:
            q.append((i, v))
        else:
            answer += 1
            if i == location: break
    
    return answer