# [10775] 공항
## 💡Algorithm
그리디, 분리집합

## 💡Logic
### --- JAVA ---
parent 배열에 각 인덱스에 해당하는 수로 미리 채워두고  
각 인덱스에 해당하는 비행기가 들어오면 채우고 만약에 채워져있다면 한칸밑에 도킹하는 방식  

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[x] = y;
        }
    }

### --- Python ---
JAVA 풀이방식과 유사

## 💡Review
수업시간에 한번 들어본적이 있는 알고리즘이었는데 막상 처음 보고 이걸 어떻게 접근하는지 알 수 없었다
그래서 공부해서 해봤는데 아직도 원리가 잘 이해되지 않는다ㅠㅠ