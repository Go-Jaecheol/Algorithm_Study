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
        int[] result = solution.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        assertArrayEquals(new int[]{2, 1}, result);
    }

    @Test
    public void solution_2(){
        int[] result = solution.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
        assertArrayEquals(new int[]{1, 3, 2}, result);
    }
}

