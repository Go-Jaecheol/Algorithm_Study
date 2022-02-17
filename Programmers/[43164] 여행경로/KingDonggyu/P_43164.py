def solution(tickets):
    airports = {}
    for key, value in tickets:
        if key in airports: airports[key].append(value)
        else: airports[key] = [value]
    for key in airports:
        airports[key].sort()
    
    after = []
    stack = ["ICN"]
    while len(stack) + len(after) != len(tickets)+1:
        top = stack[-1]
        if top not in airports or not airports[top]:
            after.append(stack.pop())
        else:
            stack.append(airports[top].pop(0))
            
    return stack + after[::-1]

"""첫번째 코드
def solution(tickets):
    n = len(tickets)
    
    def dfs(airport, route, visited):
        if not airport:
            d = "ICN"
        else:
            visited[airport[2]] = True
            d = airport[1]
            
        airports = []
        for i in range(n):
            if not visited[i] and tickets[i][0] == d:
                airports.append(tickets[i]+[i])

        for a in sorted(airports, key=lambda x:x[1]):
                temp = dfs(a, route+[a[0]], visited)
                if temp: return temp
                visited[a[2]] = False

        if not airports and len(route) == n:
            route.append(d)
            return route
        return False
    
    return dfs([], [], [False for _ in range(n)])
"""