function solution(n, times) {
    let left = 1;
    let right = Math.max(...times) * n;
 
    loop: while (left < right) {
        const mid = Math.floor((left + right) / 2);
        let totalTime = 0;

        for (let time of times) {
            totalTime += Math.floor(mid / time);
            if (totalTime >= n) {
                right = mid;
                continue loop;
            }
        }
        left = mid + 1;
    }

    return left;
}