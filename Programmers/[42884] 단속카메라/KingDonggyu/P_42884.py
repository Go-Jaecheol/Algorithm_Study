def solution(routes):
    answer, i = 1, 1
    routes.sort()
    x, y = routes[0]
    while i < len(routes):
        if x <= routes[i][0] <= y:
            y = min(y, routes[i][1])
        else:
            y = routes[i][1]
            answer += 1
        x = routes[i][0]
        i += 1

    return answer