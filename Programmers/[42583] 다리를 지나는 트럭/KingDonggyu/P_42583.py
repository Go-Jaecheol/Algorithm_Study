def solution(bridge_length, weight, truck_weights):
    answer = 0; w = 0
    q = [0 for _ in range(bridge_length)]
    while True:
        w -= q.pop(0)
        if truck_weights and truck_weights[0] + w <= weight:
            x = truck_weights.pop(0)
            q.append(x)
            w += x
        else:
            q.append(0)
            
        answer += 1
        if w == 0: break
    
    return answer