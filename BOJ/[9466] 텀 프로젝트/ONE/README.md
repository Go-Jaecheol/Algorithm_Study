# [9466] 텀 프로젝트 - JAVA

## :black_circle: Algorithm
**DFS**

## :black_circle: Logic
```Java
class Student{
    int selectNum;
    boolean isVisited;
    boolean isFinished;

    public Student(int selectNum){
        this.selectNum = selectNum;
        this.isVisited = false;
        this.isFinished = false;
    }
}
```

```Java
    private static void DFS(int v, Student[] students){
        if (students[v].isVisited){
            students[v].isFinished = true;
            count--;
        } else students[v].isVisited = true;

        if(!students[students[v].selectNum].isFinished)
            DFS(students[v].selectNum, students);

        students[v].isVisited = false;
        students[v].isFinished = true;
    }
```

학생 객체에 isVisited 와 isFinished 변수를 이용한다  
isVisited 는 방문의 여부를 따지고, isFinished 는 팀완성의 여부를 확인한다.  
두 변수를 따로 두는 이유는 이미 팀배정 결과가 나온 학생은 방문하지 않도록 하여 시간을 줄이기 위해서 이다.

## :black_circle: Review
원래 일반적인 DFS로 코드를 짜서 했는데 시간초과가 계속떠서,  
N 이 100000만 까지일 수도 있다는 걸 확인하고는 방문하는 노드를 줄이는 방법을 생각했다.  
어려웠던 문제