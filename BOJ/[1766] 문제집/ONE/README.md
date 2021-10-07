# [1766] 문제집 - JAVA

## :black_circle: Algorithm
**위상 정렬, 우선순위 큐**

## :black_circle: Logic

```Java
class Work implements Comparable<Work> {
    int num;

    public Work(int num){
        this.num = num;
    }

    @Override
    public int compareTo(Work o) {
        return this.num - o. num;
    }
}
```

**[2252] 줄 세우기** 문제와 거의 유사하지만  
번호가 작은 문제부터 풀어야 하기때문에  
번호에 따른 우선순위 큐를 사용해야 한다

## :black_circle: Review
줄 세우기와 굉장히 유사한 문제