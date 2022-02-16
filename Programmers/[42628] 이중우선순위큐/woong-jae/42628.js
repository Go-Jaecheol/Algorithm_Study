class Heap {
    constructor() {
        this.heap = [];
    }
    push(newVal) {
        this.heap.push(newVal);
        let index = this.heap.length - 1;
        let parent = Math.floor((index - 1) / 2);
        while(index > 0 && this.heap[index] > this.heap[parent]) {
            [this.heap[index], this.heap[parent]] = [this.heap[parent], this.heap[index]];
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
            if(this.heap[next] < this.heap[left]) next = left;
            if(right < this.heap.length && this.heap[next] < this.heap[right]) next = right;
            if(next === here) break;
            [this.heap[here], this.heap[next]] = [this.heap[next], this.heap[here]];
            here = next;
        }
        return ret;
    }
}

function solution(operations) {
    let maxQ = new Heap();
    let minDeleteCount = 0;
    
    operations.forEach(op => {
        const [command, number] = op.split(" ");
        if(command === "D" && maxQ.heap.length) {
            if(number === "1") maxQ.pop();
            else minDeleteCount++;
        } 
        else {
            maxQ.push(+number);
        }
    });
    
    let arr = [...maxQ.heap];
    arr.sort((a, b) => b - a);
    while(arr.length && minDeleteCount--) arr.pop();
    
    let answer = [arr[0] ? arr[0] : 0, arr[arr.length - 1] ? arr[arr.length - 1] : 0];
    
    return answer;
}
