def solution(answers):
    answer = []
    solve = [0, 0, 0]
    
    num1 = 1
    num2 = [2, 1, 2, 3, 2, 4, 2, 5]
    num3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    i, j = 0, 0
    
    for a in answers:
        if num1 == a: solve[0] += 1
        if num2[i] == a: solve[1] += 1
        if num3[j] == a: solve[2] += 1
        
        num1 = num1+1 if num1 < 5 else 1
        i = i+1 if i < 7 else 0
        j = j+1 if j < 9 else 0
    
    max_solve = max(solve)
    for i, v in enumerate(solve):
        if v >= max_solve:
            answer.append(i+1)
            
    return answer