function solution(n, lost, reserve) {
    let answer = 0;
    
    let students = new Array(n).fill(1);
    
    reserve.forEach(elem => students[elem - 1] = 2);
    lost.forEach(elem => {
        if(students[elem - 1] > 0) students[elem - 1]--;
    });
    
    students.forEach((elem, i) => {
        if(elem === 0) {
            let left = i - 1, right = i + 1;
            if(left >= 0 && students[left] > 1) {
                students[left]--;
                students[i]++;
                answer++;
            }
            else if (right < n && students[right] > 1) {
                students[right]--;
                students[i]++;
                answer++;
            }
        } 
        else {
            answer++;
        }
    });
    
    return answer;
}
