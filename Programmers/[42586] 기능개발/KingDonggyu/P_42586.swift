import Foundation

func solution(_ progresses: [Int], _ speeds: [Int]) -> [Int] {
    var answer: [Int] = []
    var progresses = progresses
    var speeds = speeds
    
    while progresses.count > 0 {
        for i in 0..<progresses.count {
            progresses[i] += speeds[i]
        }
        
        var cnt: Int = 0
        while progresses.count > 0 && progresses[0] >= 100 {
            progresses.remove(at: 0)
            speeds.remove(at: 0)
            cnt += 1
        }
        
        if cnt > 0 { answer.append(cnt) }
    }
    
    return answer
}