import Foundation

func solution(_ bridge_length:Int, _ weight:Int, _ truck_weights:[Int]) -> Int {
    
    var answer: Int = 0
    var w: Int = 0
    var q: [Int] = []
    var truck: [Int] = truck_weights
    
    for _ in 0..<bridge_length {
        q.append(0)
    }
    
    while true {
        w -= q.removeFirst()
        if truck.count > 0 && truck[0] + w <= weight {
            var x = truck.removeFirst()
            q.append(x)
            w += x
        } else {
            q.append(0)
        }
        
        answer += 1
        if w == 0 { break }
    }
    
    return answer
}