# [14499] 뱀 - Python

## :mag: Algorithm

Simulation

## :round_pushpin: Logic

```python
if m == 1:
    dice[1], dice[4] = dice[4], dice[1]
    dice[3], dice[6] = dice[6], dice[3]
    dice[3], dice[4] = dice[4], dice[3]
elif m == 2:
    dice[1], dice[3] = dice[3], dice[1]
    dice[4], dice[6] = dice[6], dice[4]
    dice[3], dice[4] = dice[4], dice[3]
elif m == 3:
    dice[1], dice[2] = dice[2], dice[1]
    dice[5], dice[6] = dice[6], dice[5]
    dice[2], dice[5] = dice[5], dice[2]
elif m == 4:
    dice[1], dice[5] = dice[5], dice[1]
    dice[2], dice[6] = dice[6], dice[2]
    dice[2], dice[5] = dice[5], dice[2]
```

위 코드는 **이동 명령에 따른 주사위의 값 변화**를 나타낸다. 이 로직만 구현하면 해당 문제는 쉽게 해결할 수 있다.

**각 명령에 따라 주사위 번호에 따른 위치의 값만 서로 바꿔줌**으로, 마치 주사위가 굴러가는 듯한 모션을 취한다.

## :memo: Review

주사위를 굴리는 것에 대한 코드를 구현하는 것이 이번 문제의 관건이었다. 

간단한 그림을 그려보니 금방 해결할 수 있었다.

