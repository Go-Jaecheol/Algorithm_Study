def solution(people, limit):
    answer, left, right = 0, 0, len(people)-1
    people.sort()
    while left <= right:
        answer += 1
        boat = people[right]
        right -= 1
        if left > right : break
        if boat + people[left] <= limit:
            left += 1
    return answer