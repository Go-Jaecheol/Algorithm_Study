def solution(numbers, target):
    if numbers:
        return solution(numbers[1:], target+numbers[0]) + solution(numbers[1:], target-numbers[0])
    else:
        if target == 0: return 1
        return 0