import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    Solution solution;

    @BeforeEach
    public void setSol(){
        solution = new Solution();
    }

    @Test
    public void solution_1(){
        int[] result = solution.solution(10, 2);
        assertArrayEquals(new int[]{4, 3}, result);
    }

    @Test
    public void solution_2(){
        int[] result = solution.solution(8, 1);
        assertArrayEquals(new int[]{3, 3}, result);
    }

    @Test
    public void solution_3(){
        int[] result = solution.solution(24, 24);
        assertArrayEquals(new int[]{8, 6}, result);
    }
}

