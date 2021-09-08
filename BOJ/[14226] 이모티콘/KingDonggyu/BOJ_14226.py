from collections import deque

S = int(input())
queue = deque()
queue.append((1, 0)) 
visited = dict()
visited[(1, 0)] = 0

while queue:
    screen, clipboard = queue.popleft()
    if screen == S:
        print(visited[(screen, clipboard)])
        break
    if (screen, screen) not in visited.keys():
        visited[(screen, screen)] = visited[(screen, clipboard)] + 1
        queue.append((screen, screen))
    if (screen + clipboard, clipboard) not in visited.keys():
        visited[(screen + clipboard, clipboard)] = visited[(screen, clipboard)] + 1
        queue.append((screen + clipboard, clipboard))
    if (screen - 1, clipboard) not in visited.keys():
        visited[(screen - 1, clipboard)] = visited[(screen, clipboard)] + 1
        queue.append((screen - 1, clipboard))
