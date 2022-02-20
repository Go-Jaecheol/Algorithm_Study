from heapq import heappush, heappop

def solution(operations):
    size = 0
    max_h, min_h = [], []
    
    for op in operations:
        c, i = op.split()
        if c == 'I':
            heappush(max_h, -int(i))
            heappush(min_h, int(i))
            size += 1
        elif size > 0:
            if i == '1':
                heappop(max_h)
            else:
                heappop(min_h)
            size -= 1
            if size == 0:
                max_h, min_h = [], []

    return [-heappop(max_h), heappop(min_h)] if size > 0 else [0, 0]