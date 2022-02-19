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
        int result = solution.solution(new int[]{1, 1, 1, 1, 1}, 3);
        assertEquals(5, result);
    }

    @Test
    public void solution_2(){
        int result = solution.solution(new int[]{4, 1, 2, 1}, 4);
        assertEquals(2, result);
    }
}

