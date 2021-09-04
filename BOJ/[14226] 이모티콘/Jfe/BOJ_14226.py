import sys
from collections import deque

S = int(sys.stdin.readline())
visited = [[False for _ in range(1001)] for _ in range(1001)]

def bfs(screen, clip):
    time = 0
    q = deque()
    visited[screen][clip] = True
    q.append((screen, clip, time))

    while q:
        screen, clip, time = q.popleft()
        time += 1
        for i in range(3):
            if i == 0 and not visited[screen][screen]:
                visited[screen][screen] = True
                q.append((screen, screen, time))
            elif i == 1 and 0 <= screen+clip < 1001 and not visited[screen+clip][screen]:
                    visited[screen+clip][clip] = True
                    q.append((screen+clip, clip, time))
                    if screen+clip == S:
                        return time
            elif i == 2 and 0 <= screen-1 and not visited[screen-1][screen]:
                visited[screen-1][clip] = True
                q.append((screen-1, clip, time))
                if screen-1 == S:
                    return time
print(bfs(1, 0))