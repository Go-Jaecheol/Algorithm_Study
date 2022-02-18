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
        int result = solution.solution(2, 10, new int[]{7, 4, 5, 6});
        assertEquals(8, result);
    }

    @Test
    public void solution_2(){
        int result = solution.solution(100, 100, new int[]{10});
        assertEquals(101, result);
    }

    @Test
    public void solution_3(){
        int result = solution.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10});
        assertEquals(110, result);
    }
}

