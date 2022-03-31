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
        int result = solution.solution(5,12);
        assertEquals(4, result);
    }

    @Test
    public void solution_2(){
        int result = solution.solution(2,11);
        assertEquals(3, result);
    }

    @Test
    public void solution_3(){
        int result = solution.solution(8,5800);
        assertEquals(8, result);
    }
}

