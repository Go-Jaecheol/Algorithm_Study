function solution(routes) {
    let answer = 0;
    routes = routes.map(route => [+route[0], +route[1]]).sort((a, b) => a[1] - b[1]);
    
    let currentEnd = null;
    for(let routeIndex = 0; routeIndex < routes.length; routeIndex++) {
        const route = routes[routeIndex];
        if(currentEnd === null || route[0] > currentEnd) {
            currentEnd = route[1];
            answer++;
        }
    }
    
    return answer;
}
