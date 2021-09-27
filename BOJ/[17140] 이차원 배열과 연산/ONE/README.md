# [17140] 이차원 배열과 연산 - JAVA

## :black_circle: Algorithm
**구현 시뮬레이션**

## :black_circle: Logic

```Java
class Node implements Comparable<Node>{
    int num;
    int numCount;

    public Node(int num, int numCount){
        this.num = num;
        this.numCount = numCount;
    }

    @Override
    public int compareTo(Node o) {
        if(this.numCount > o.numCount)
            return 1;
        else if(this.numCount < o.numCount)
            return -1;
        else
            return this.num - o.num;
    }
}
```

우선순위큐를 사용하기 위한 Node 객체  
수와 수의 개수 정보를 담고 있음  
수의 개수 오름차순 정렬로 우선순위큐에 저장되고  
개수가 같다면 수의 오름차순 정렬

```Java
    private static void operation(){
        int[][] temp = new int[101][101];

        if(rowSize >= colSize){
            // R operation
            int checkMax = 0; // for row or col size X 2
            for(int i = 1; i <= rowSize; i++){
                PriorityQueue<Node> queue = new PriorityQueue<>();
                int[] countNum = new int[101];

                for(int j = 1; j <= colSize; j++)
                    countNum[matrix[i][j]]++;

                for(int j = 1; j <= 100; j++)
                    if(countNum[j] != 0)
                        queue.add(new Node(j, countNum[j]));

                checkMax = Math.max(checkMax, queue.size());

                int index = 1;
                while (!queue.isEmpty()){
                    Node current = queue.poll();
                    temp[i][index++] = current.num;
                    temp[i][index++] = current.numCount;
                }
            }
            if(checkMax * 2 > colSize)
                colSize = checkMax * 2;
        }
```

R연산 C연산 두가지 경우로 나눠서  
배열의 수를 세어 우선순위큐에 저장  
큐에서 하나씩 꺼내 배열에 값을 저장하고  
배열을 원래 matrix 배열에 복사

## :black_circle: Review
문제 이해만 한다면 금방 구현할 수 있는 문제  
크게 어려운 부분은 없었으나 문제를 똑바로 안읽어서  
베열 크기 증가하는데서 시간 낭비 했다...  
문제좀 똑바로 읽자