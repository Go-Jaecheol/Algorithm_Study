import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    Solution solution;

    @BeforeEach
    public void setSol(){
        solution = new Solution();
    }

    @Test
    public void solution_1(){
        int result = solution.solution(new int[]{2, 1, 3, 2}, 2);
        assertEquals(1, result);
    }

    @Test
    public void solution_2(){
        int result = solution.solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
        assertEquals(5, result);
    }
}
