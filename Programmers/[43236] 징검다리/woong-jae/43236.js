function solution(distance, rocks, n) {
    let answer = 0;
    let between = [];

    rocks.sort((a, b) => a - b);
    between.push(rocks[0]);
    for(let i = 0; i < rocks.length - 1; i++) {
        between.push(rocks[i + 1] - rocks[i]);
    }
    between.push(distance - rocks[rocks.length - 1]);
    
    let left = 0, right = distance;
    while(left <= right) {
        let mid = Math.floor((left + right) / 2);
        let partialSum = 0, removed = 0;
        between.forEach(elem => {
            partialSum += elem; 
            if(partialSum < mid) removed++;
            else partialSum = 0;
        });
        if(removed > n) right = mid - 1;
        else left = mid + 1;
    }
    
    
    return right;
}
