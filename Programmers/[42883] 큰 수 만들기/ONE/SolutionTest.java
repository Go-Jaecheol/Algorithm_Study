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
        String result = solution.solution("1924", 2);
        assertEquals("94", result);
    }

    @Test
    public void solution_2(){
        String result = solution.solution("1231234", 3);
        assertEquals("3234", result);
    }

    @Test
    public void solution_3(){
        String result = solution.solution("4177252841", 4);
        assertEquals("775841", result);
    }
}
