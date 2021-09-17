from collections import deque


def bfs():
    if S == G: return 0
    visited[S] = 1
    queue = deque([S])
    while queue:
        current_layer = queue.popleft()
        for d in direction:
            next_layer = current_layer + d
            if 1 <= next_layer <= F and visited[next_layer] == 0:
                if next_layer == G: return visited[current_layer]
                visited[next_layer] = visited[current_layer] + 1
                queue.append(next_layer)
    return "use the stairs"


F, S, G, U, D = map(int, input().split())
visited = [0] * (F + 1)
direction = [U, -D]

print(bfs())