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
        long result = solution.solution(6, new int[]{7, 10});
        assertEquals(28, result);
    }

    @Test
    public void solution_2(){
        long result = solution.solution(10, new int[]{6, 8, 10});
        assertEquals(30, result);
    }
}

