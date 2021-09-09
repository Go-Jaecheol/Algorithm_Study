import java.util.*;

enum Direction{ // 머리가 보는 방향
    EAST, SOUTH, WEST, NORTH
}

class Change{
    int X;
    char C;

    public Change(int X, char C){
        this.X = X;
        this.C = C;
    }
}

class Snake{
    int row;
    int col;
    Direction direction;

    public Snake(int row, int col, Direction direction){
        this.row = row;
        this.col = col;
        this.direction = direction;
    }
}

public class Main {
    private static int N, K, L, second;
    private static boolean[][] apple;
    private static boolean[][] body;
    private static Deque<Change> changes = new LinkedList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        K = scanner.nextInt();

        apple = new boolean[N + 1][N + 1];
        body = new boolean[N + 1][N + 1];

        for(int i = 0; i < K; i++){
            int r,c;
            r = scanner.nextInt();
            c = scanner.nextInt();

            apple[r][c] = true;
        }

        L = scanner.nextInt();

        for(int i = 0; i < L; i++){
            int X = scanner.nextInt();
            char C = scanner.next().charAt(0);
            changes.add(new Change(X, C));
        }

        dummy();

        System.out.println(second);

        scanner.close();
    }

    private static Direction changeDirection(int second, Direction direction){
        if(!changes.isEmpty()){
            Change current = changes.pollFirst();
            if(second == current.X)
                switch (direction){
                    case EAST:
                        if(current.C == 'L') // North
                            return Direction.NORTH;
                        else // South
                            return Direction.SOUTH;
                    case SOUTH:
                        if(current.C == 'L') // East
                            return Direction.EAST;
                        else // west
                            return Direction.WEST;
                    case WEST:
                        if(current.C == 'L') // South
                            return Direction.SOUTH;
                        else // North
                            return Direction.NORTH;
                    case NORTH:
                        if(current.C == 'L') // West
                            return Direction.WEST;
                        else // East
                            return Direction.EAST;
                }
            changes.addFirst(current);
        }
        return direction;
    }

    private static void dummy(){
        Deque<Snake> deque = new ArrayDeque<>();
        deque.addLast(new Snake(1,1,Direction.EAST));

        while(true){
            Snake head = deque.getFirst(); // 큐의 제일 앞의 머리를 가져옴

            switch (head.direction){
                case EAST: // (0, 1)
                    if(head.col + 1 <= N && !body[head.row][head.col + 1]){ // 벽과 몸에 안 부딪힐 때
                        deque.addFirst(new Snake(head.row, head.col + 1, head.direction)); // 머리를 한칸 앞으로 이동
                        body[head.row][head.col + 1] = true;
                        if(!apple[head.row][head.col + 1]){ // 사과가 없으면 꼬리칸 비우기
                            Snake tail = deque.pollLast();
                            body[tail.row][tail.col] = false;
                        } else
                            apple[head.row][head.col + 1] = false; // 사과가 있으면 없애고, 꼬리 그대로
                        second++;
                    }
                    else{
                        second++;
                        return;
                    }
                    break;

                case SOUTH: // (1, 0)
                    if(head.row + 1 <= N && !body[head.row + 1][head.col]){ // 벽과 몸에 안 부딪힐 때
                        deque.addFirst(new Snake(head.row + 1, head.col, head.direction)); // 머리를 한칸 앞으로 이동
                        body[head.row + 1][head.col] = true;
                        if(!apple[head.row + 1][head.col]){ // 사과가 없으면 꼬리칸 비우기
                            Snake tail = deque.pollLast();
                            body[tail.row][tail.col] = false;
                        } else
                            apple[head.row + 1][head.col] = false;
                        second++;
                    }
                    else{
                        second++;
                        return;
                    }
                    break;

                case WEST: // (0, -1)
                    if(head.col - 1 >= 1 && !body[head.row][head.col - 1]){ // 벽과 몸에 안 부딪힐 때
                        deque.addFirst(new Snake(head.row, head.col - 1, head.direction)); // 머리를 한칸 앞으로 이동
                        body[head.row][head.col - 1] = true;
                        if(!apple[head.row][head.col - 1]){ // 사과가 없으면 꼬리칸 비우기
                            Snake tail = deque.pollLast();
                            body[tail.row][tail.col] = false;
                        } else
                            apple[head.row][head.col - 1] = false;
                        second++;
                    }
                    else{
                        second++;
                        return;
                    }
                    break;

                case NORTH: // (-1, 0)
                    if(head.row - 1 >= 1 && !body[head.row - 1][head.col]){ // 벽과 몸에 안 부딪힐 때
                        deque.addFirst(new Snake(head.row - 1, head.col, head.direction)); // 머리를 한칸 앞으로 이동
                        body[head.row - 1][head.col] = true;
                        if(!apple[head.row - 1][head.col]){ // 사과가 없으면 꼬리칸 비우기
                            Snake tail = deque.pollLast();
                            body[tail.row][tail.col] = false;
                        } else
                            apple[head.row - 1][head.col] = false;
                        second++;
                    }
                    else{
                        second++;
                        return;
                    }
                    break;
            }
            Snake nextHead = deque.pollFirst();
            nextHead.direction = changeDirection(second, nextHead.direction);
            deque.addFirst(nextHead);
        }
    }
}
