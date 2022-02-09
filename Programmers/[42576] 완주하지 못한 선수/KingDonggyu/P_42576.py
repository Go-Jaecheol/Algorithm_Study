def solution(participant, completion):
    answer = ''
    n = len(participant)
    player = dict.fromkeys(participant, 0)
    
    for i in range(n):
        player[participant[i]] += 1
        if i >= n-1: continue
        player[completion[i]] -= 1
    
    for key, value in player.items():
        if value != 0:
            answer = key
            break
    
    return answer