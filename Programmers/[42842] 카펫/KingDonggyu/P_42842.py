def solution(brown, yellow):
    answer = []

    for x in range(3, brown//2):
        y = (brown-x*2)//2 + 2
        if x >= y and (x-2) * (y-2) == yellow:
            answer += [x, y]
            break
            
    return answer