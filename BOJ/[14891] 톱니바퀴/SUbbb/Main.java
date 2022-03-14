import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Gear[] gears = new Gear[4];

        for (int i = 0; i < 4; i++) {
            gears[i] = new Gear();
            gears[i].tooth = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int N = Integer.parseInt(br.readLine());
        int[][] spins = new int[N][2];

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

        N = 0;
        for (int i = 0; i < 4; i++) N += gears[i].tooth[0] * Math.pow(2,i);

        System.out.println(N);

        br.close();
    }
}