def solution(n, lost, reserve):
    two = [r for r in reserve if r not in lost]
    zero = [l for l in lost if l not in reserve]
    
    for t in sorted(two):
        if t-1 in zero:
            zero.remove(t-1)
        elif t+1 in zero:
            zero.remove(t+1)
    
    return n - len(zero)