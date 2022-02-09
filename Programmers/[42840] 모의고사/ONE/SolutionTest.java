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
        int[] result = solution.solution(new int[]{1, 2, 3, 4, 5});
        assertArrayEquals(new int[]{1}, result);
    }

    @Test
    public void solution_2(){
        int[] result = solution.solution(new int[]{1, 3, 2, 4, 2});
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }
}
