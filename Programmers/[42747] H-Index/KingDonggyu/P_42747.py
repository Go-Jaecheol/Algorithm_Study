def solution(citations):
    n = len(citations)
    for i, ci in enumerate(sorted(citations)):
        if n-i <= ci: return n-i
    return 0