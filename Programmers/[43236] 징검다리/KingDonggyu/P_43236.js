function solution(distance, rocks, n) {
    let left = 0;
    let right = distance;

    rocks.sort((a, b) => a - b)

    loop: while (left <= right) {
        const mid = Math.floor((left + right) / 2);
        let standard = 0;
        let remove = 0;
        
        for (const rock of rocks) {
            if (rock - standard < mid) {
                if (++remove > n) {
                    right = mid - 1;
                    continue loop;
                }
            } else {
                standard = rock;
            }
        }

        left = mid + 1;
    }
    
    return right;
}