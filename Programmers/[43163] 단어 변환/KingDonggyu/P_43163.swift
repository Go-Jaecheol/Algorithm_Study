import Foundation

func solution(_ begin:String, _ target:String, _ words:[String]) -> Int {
    if !words.contains(target) { return 0 }
    
    var q: [(String, Int)] = [(begin, 0)]
    var visited = Array(repeating: false, count: words.count)
    
    while q.count > 0 {
        var (x, l) = q.removeFirst()
        if x == target { return l }
        
        for (i, word) in words.enumerated() {
            if visited[i] { continue }
            var changed = 0
            for j in 0..<begin.count {
                if Array(x)[j] != Array(word)[j] {
                    changed += 1
                }
            }
            if changed == 1 {
                q.append((word, l+1))
                visited[i] = true
            }
        }
    }
    
    return 0
}