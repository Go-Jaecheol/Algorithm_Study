import heapq

def solution(jobs):
    answer = 0
    
    heap = []
    start, end, cnt = -1, 0, 0
    
    while cnt < len(jobs):
        for j in jobs:
            if start < j[0] <= end:
                heapq.heappush(heap, [j[1], j[0]])
                
        if heap:
            t, p = heapq.heappop(heap)
            start = end; end += t
            answer += end - p
            cnt += 1
        else:
            end += 1
            
    return answer // len(jobs)