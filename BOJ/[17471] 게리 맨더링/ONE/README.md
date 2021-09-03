# [17471] 게리맨더링 - JAVA

## :black_circle: Algorithm
**BFS**

## :black_circle: Logic

```Java
    private static void gerrymandering(ArrayList<Integer> A){
        int sumA = 0, sumB = 0;

        if(!isConnect(sectors[A.get(0)].idx, A)) // A가 잘 연결됐는지 확인
            return;

        ArrayList<Integer> B = new ArrayList<>(); // A 구역을 제외한 B 구역 리스트 생성
        for(int i = 1; i <= N; i++){
            if(A.contains(i))
                continue;
            B.add(i);
        }

        if(!isConnect(sectors[B.get(0)].idx, B)) // B가 잘 연결됐는지 확인
            return;

        for(int i = 0; i < A.size(); i++)
            sumA += sectors[A.get(i)].population;

        for(int i = 0; i < B.size(); i++)
            sumB += sectors[B.get(i)].population;

        result = Math.min(result, Math.abs(sumA - sumB));
    }
```

조합을 이용하여 A 와 B를 나누는 경우의 수 combination 함수를 사용하여 구하고,  
각각 구역이 잘 연결 되어있는지 확인 후 잘 연결 되어있다면 인구 차의 최솟값을 구한다

## :black_circle: Review
뿌요뿌요를 풀고 이 문제를 풀었는데 생각보다 잘 풀렸다.  
하지만 조합이라는걸 생각해내는데 시간이 좀 걸렸던 것 같다.