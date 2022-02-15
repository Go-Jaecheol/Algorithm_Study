class PriorityQueue {
    constructor() {
        this.heap = [];
    }
    push(val) {
        this.heap.push(val);
        let index = this.heap.length - 1;
        let parent = Math.floor((index - 1) / 2);
        while(index > 0 && this.heap[parent][1] > this.heap[index][1]) {
            [this.heap[parent], this.heap[index]] = [this.heap[index], this.heap[parent]];
            index = parent;
            parent = Math.floor((index - 1) / 2);
        }
    }
    pop() {
        if(this.heap.length === 0) return null;
        if(this.heap.length === 1) return this.heap.pop();
        let ret = this.heap[0];
        this.heap[0] = this.heap.pop();
        let here = 0;
        while(1) {
            let left = here * 2 + 1, right = here * 2 + 2;
            if(left >= this.heap.length) break;
            let next = here;
            if(this.heap[next][1] > this.heap[left][1]) next = left;
            if(right < this.heap.length && this.heap[next][1] > this.heap[right][1]) next = right;
            if(next === here) break;
            [this.heap[here], this.heap[next]] = [this.heap[next], this.heap[here]]
            here = next;
        }
        return ret;
    }
}

function solution(jobs) {
    let [answer, time, index] = [0, 0, 0];
    const pq = new PriorityQueue();
    
    jobs.sort((a, b) => a[0] - b[0]);
    
    while(index < jobs.length || pq.heap.length) {
        if(jobs.length > index && time >= jobs[index][0]) {
              pq.push(jobs[index++]);
              continue;
        }
        if(pq.heap.length) {
            let [requestTime, duration] = pq.pop();
            time += duration;
            answer += time - requestTime;
        } else {
            time = jobs[index][0];
        }
    }
    
    return Math.floor(answer / jobs.length);
}
