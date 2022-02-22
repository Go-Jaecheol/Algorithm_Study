import Foundation

func solution(_ numbers:[Int]) -> String {
    let answer: [String] = numbers.map { String($0) }.sorted() { (a, b) -> Bool in
        return a+b > b+a
    }
 
    if answer[0] != "0" { return answer.joined(separator: "") } 
    else { return "0" }
}