# [14891] 톱니바퀴 - Java

## :pushpin: **Algorithm**

구현, 시뮬레이션

## :round_pushpin: **Logic**

```java
class Gear {
    int[] tooth;
    boolean spinStatus;
    int spinDir;

    public Gear() {
        tooth = new int[8];
        spinStatus = false;
        spinDir = 0;
    }

    public void clockWise() {
        int tmp = tooth[7];
        System.arraycopy(tooth, 0, tooth, 1, 7);
        tooth[0] = tmp;
    }

    public void counterClockWise() {
        int tmp = tooth[0];
        System.arraycopy(tooth, 1, tooth, 0, 7);
        tooth[7] = tmp;
    }
}
```

- 톱니바퀴의 정보를 저장하는 클래스이다.
- `clockWise()` 는 톱니를 시계방향으로 돌렸을 때 상태 업데이트를 수행하고, `counterClockWise()` 는 반시계방향에 대한 업데이트를 수행한다.

```java
for (int i = 0; i < N; i++) {
    spins[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int centerG = spins[i][0] - 1;
    gears[centerG].spinStatus = true;
    gears[centerG].spinDir = spins[i][1];

    for (int j = centerG - 1; j >= 0; j--) {
        if (gears[j + 1].spinStatus) {
            if (gears[j].tooth[2] != gears[j + 1].tooth[6]) {
                gears[j].spinStatus = true;
                gears[j].spinDir = gears[j + 1].spinDir * -1;
            }
        }
    }

    for (int j = centerG + 1; j < 4; j++) {
        if (gears[j - 1].spinStatus) {
            if (gears[j].tooth[6] != gears[j - 1].tooth[2]) {
                gears[j].spinStatus = true;
                gears[j].spinDir = gears[j - 1].spinDir * -1;
            }
        }
    }

    for (int j = 0; j < 4; j++) {
        if (gears[j].spinDir == -1) gears[j].counterClockWise();
        else if (gears[j].spinDir == 1) gears[j].clockWise();
        gears[j].spinDir = 0;
        gears[j].spinStatus = false;
    }
}
```

- 중심 구현부는 크게 3개로 나눌 수 있다.
  - 회전하는 톱니의 왼쪽 톱니에 대해 회전여부를 판단하고 수행하는 for문
  - 회전하는 톱니의 오른쪽 톱니에 대해 회전여부를 판단하고 수행하는 for문
  - 주어진 1회전이 끝난 후 톱니의 정보를 업데이트하는 for문

## :black_nib: **Review**

- 정말 오랜만에 1트만에 성공했다. 난이도 높은 문제는 아니었지만 ...
- 문제 풀이를 구상하면서, 어떤 메소드를 구현해야하며, 어떤 메소드를 객체에 둬야 하는지에 대해 좀 더 공부해봐야겠다.
