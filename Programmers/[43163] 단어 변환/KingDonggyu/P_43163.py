def solution(begin, target, words):
    if target not in words: return 0
    
    q = [(begin, 0)]
    visited = [False for _ in range(len(words))]
    
    while q:
        x, l = q.pop(0)
        if x == target: return l
        
        for i, word in enumerate(words):
            if visited[i]: continue
            changed = 0
            for j in range(len(begin)):
                if x[j] != word[j]:
                    changed += 1
            if changed == 1:
                q.append((word, l+1))
                visited[i] = True