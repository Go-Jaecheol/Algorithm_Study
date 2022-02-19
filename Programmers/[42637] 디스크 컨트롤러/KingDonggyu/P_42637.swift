import Foundation

func solution(_ jobs:[[Int]]) -> Int {
    var answer = 0
    
    var start = -1, end = 0, cnt = 0
    var heap:[[Int]] = []
    
    while cnt < jobs.count {
        for j in jobs {
            if start < j[0] && j[0] <= end {
                heap.append(j)
            }
        }
        
        if heap.count > 0 {
            heap.sort { $0[1] < $1[1] }
            var j = heap.removeFirst()
            start = end
            end += j[1]
            answer += end - j[0]
            cnt += 1
        } else {
            end += 1
        }
    }
    
    return answer / jobs.count
}