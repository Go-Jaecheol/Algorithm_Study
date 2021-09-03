import java.util.Scanner;

class Gear{
    int number;
    int[] cog;
    boolean check;

    public Gear(int number, int[] cog, boolean check){
        this.number = number;
        this.cog = cog;
        this.check = check;
    }
}

public class Main {
    private static Gear[] gears = new Gear[4];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < 4; i ++){
            int[] tmp = new int[8];
            String input = scanner.next();

            for(int j = 0; j < 8; j++)
                tmp[j] = input.toCharArray()[j] - '0';

            gears[i] = new Gear(i + 1, tmp, false);
        }

        int K = scanner.nextInt();

        for(int i = 0; i < K; i++){
            int gearNum, direction;

            gearNum = scanner.nextInt();
            direction = scanner.nextInt();

            rotatingGear(gearNum, direction);

            // 한바퀴 돌때마다 방문기록 초기화
            for(int j = 0; j < 4; j++)
                gears[j].check = false;
        }

        System.out.println(scoring());

        scanner.close();
    }

    private static void rotatingGear(int gearNum, int direction){
        gears[gearNum - 1].check = true;

        switch (gearNum){
            case 1:
                if(gears[0].cog[2] != gears[1].cog[6] && !gears[1].check)
                    rotatingGear(gears[1].number, -direction);
                break;
            case 2:
                if(gears[1].cog[6] != gears[0].cog[2] && !gears[0].check)
                    rotatingGear(gears[0].number, -direction);

                if(gears[1].cog[2] != gears[2].cog[6] && !gears[2].check)
                    rotatingGear(gears[2].number, -direction);
                break;
            case 3:
                if(gears[2].cog[6] != gears[1].cog[2] && !gears[1].check)
                    rotatingGear(gears[1].number, -direction);

                if(gears[2].cog[2] != gears[3].cog[6] && !gears[3].check)
                    rotatingGear(gears[3].number, -direction);
                break;
            case 4:
                if(gears[3].cog[6] != gears[2].cog[2] && !gears[2].check)
                    rotatingGear(gears[2].number, -direction);
                break;
        }

        if(direction == 1){ // 시계 방향일 때, 오른쪽으로 shift 1씩
            int temp = gears[gearNum - 1].cog[7];

            for(int i = 7; i >= 1; i--)
                gears[gearNum - 1].cog[i] = gears[gearNum - 1].cog[i - 1];

            gears[gearNum - 1].cog[0] = temp;
        }

        else { // 반시계 방향일 때, 왼쪽으로 shift 1씩
            int temp = gears[gearNum - 1].cog[0];

            for(int i = 0; i < 7; i++)
                gears[gearNum - 1].cog[i] = gears[gearNum - 1].cog[i + 1];

            gears[gearNum - 1].cog[7] = temp;
        }
    }

    private static int scoring(){
        int result = 0, S_score = 1;;

        for(int i = 0; i < 4; i++){
            result += gears[i].cog[0] * S_score;
            S_score *= 2;
        }

        return result;
    }
}
