import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Fish{
    int x;
    int y;
    int num;
    int direction;

    public Fish(int x, int y, int num, int direction){
        this.x = x;
        this.y = y;
        this.num = num;
        this.direction = direction;
    }
}

public class Main {
    private static int max;
    private static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fish[][] fish = new Fish[4][4];

        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 4; j++){
                int num, direction;
                num = scanner.nextInt();
                direction = scanner.nextInt();
                fish[i][j] = new Fish(i, j, num, direction);
            }
        Fish shark = new Fish(0, 0, fish[0][0].num, fish[0][0].direction);
        fish[0][0].num = -1;
        teenShark(fish, shark, shark.num);

        System.out.println(max);

        scanner.close();
    }

    private static int changeDirection(int direction){
        return (direction % 8) + 1;
    }

    private static Fish[][] copyMatrix(Fish[][] fish){
        Fish[][] temp = new Fish[4][4];

        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 4; j++)
                temp[i][j] = new Fish(fish[i][j].x, fish[i][j].y, fish[i][j].num, fish[i][j].direction);

        return temp;
    }

    private static void moveFish(Fish[][] fish){
        for(int num = 1; num <= 16; num++){
            boolean check = false; // avoid duplicated checking
            for(int i = 0; i < 4; i++)
                for(int j = 0; j < 4; j++){
                    if(fish[i][j].num > 0 && fish[i][j].num == num && !check) {
                        check = true;
                        for(int k = 0; k < 8; k++){
                            int nx = i + dx[fish[i][j].direction];
                            int ny = j + dy[fish[i][j].direction];
                            if(nx >= 0 && ny >= 0 && nx < 4 && ny < 4 && fish[nx][ny].num != -1){ // can move
                                int tmpNum = fish[i][j].num;
                                fish[i][j].num = fish[nx][ny].num;
                                fish[nx][ny].num = tmpNum;

                                tmpNum = fish[i][j].direction;
                                fish[i][j].direction = fish[nx][ny].direction;
                                fish[nx][ny].direction = tmpNum;
                                break;
                            }
                            else // can not move
                                fish[i][j].direction = changeDirection(fish[i][j].direction);
                        }
                    }
                }
        }
    }

    private static void teenShark(Fish[][] fish, Fish shark, int sum){
        max = Math.max(max, sum);
        moveFish(fish);

        Queue<Fish> queue = new LinkedList<>();

        int nx = shark.x;
        int ny = shark.y;
        for(int i = 0; i < 4; i++){
            nx += dx[shark.direction];
            ny += dy[shark.direction];
            if(nx >= 0 && ny >= 0 && nx < 4 && ny <4 && fish[nx][ny].num != 0)
                queue.add(new Fish(nx, ny, fish[nx][ny].num, fish[nx][ny].direction));
        }

        while(!queue.isEmpty()){
            Fish current = queue.poll();
            Fish tempShark = new Fish(shark.x, shark.y, shark.num, shark.direction);
            Fish[][] tempFish = copyMatrix(fish);

            tempFish[tempShark.x][tempShark.y].num = 0;

            tempShark.x = current.x;
            tempShark.y = current.y;
            tempShark.direction = current.direction;
            int tempSum = sum + tempFish[current.x][current.y].num;

            tempFish[tempShark.x][tempShark.y].num = -1;

            teenShark(tempFish, tempShark, tempSum);
        }
    }
}
