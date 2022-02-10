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
        int result = solution.solution("17");
        assertEquals(3, result);
    }

    @Test
    public void solution_2(){
        int result = solution.solution("011");
        assertEquals(2, result);
    }
}
