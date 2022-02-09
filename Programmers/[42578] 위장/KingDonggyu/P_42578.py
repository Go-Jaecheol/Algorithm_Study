def solution(clothes):
    answer = 0
    n = len(clothes)
    clo = dict.fromkeys(map(lambda x:x[1], clothes), 0)

    for i in range(n):
        clo[clothes[i][1]] += 1

    for i in range(n):
        if clothes[i][1] not in clo:
            continue
            
        x = clo[clothes[i][1]]
        del clo[clothes[i][1]]
        
        for v in clo.values():
            x *= (v+1)
        
        answer += x

    return answer