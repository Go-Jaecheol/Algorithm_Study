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
        String result = solution.solution(new int[]{6,10,2});
        assertEquals("6210", result);
    }

    @Test
    public void solution_2(){
        String result = solution.solution(new int[]{3,30,34,5,9});
        assertEquals("9534330", result);
    }

    @Test
    public void solution_3(){
        String result = solution.solution(new int[]{1, 10, 100, 1000});
        assertEquals("1101001000", result);
    }

    @Test
    public void solution_4(){
        String result = solution.solution(new int[]{9,998});
        assertEquals("9998", result);
    }

    @Test
    public void solution_5(){
        String result = solution.solution(new int[]{30,3021});
        assertEquals("303021", result);
    }
}

