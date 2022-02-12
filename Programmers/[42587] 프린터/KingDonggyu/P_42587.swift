import Foundation

func solution(_ priorities:[Int], _ location:Int) -> Int {
    var answer: Int = 0
    var q: [(Int, Int)] = []
    
    for i in 0..<priorities.count {
        q.append((i, priorities[i]))
    }
    
    while true {
        var (i, v) = q.removeFirst()
        if q.count > 0, let maxValue = q.max{ a, b in a.1 < b.1 },
        maxValue.1 > v {
            q.append((i, v))
        } else {
            answer += 1
            if i == location { break }
        }
    }
    
    return answer
}