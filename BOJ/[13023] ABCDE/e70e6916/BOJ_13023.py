N, M = map(int, input().split())
people = list([] for _ in range(N))
for _ in range(M):
    x, y = map(int, input().split())
    people[x].append(y)
    people[y].append(x)


def find_friend(person, friend):
    visited[person] = True

    if friend == 4:
        print(1)
        quit()

    for p in people[person]:
        if not visited[p]:
            find_friend(p, friend+1)
            visited[p] = False


visited = [False] * N
for i in range(N):
    if people[i]:
        find_friend(i, 0)
    visited = [False] * N
print(0)
