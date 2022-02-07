def solution(people, limit):
    answer = 0
    people.sort()
    left, right = 0, len(people)-1
    while left <= right:
        if left == right:
            answer += 1
            break
        w = limit - people[right]
        right -= 1
        while True:
            if w >= people[left]:
                w -= people[left]
                left += 1
            else: break
        answer += 1
    
    return answer