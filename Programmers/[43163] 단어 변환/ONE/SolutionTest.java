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
        int result = solution.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        assertEquals(4, result);
    }

    @Test
    public void solution_2(){
        int result = solution.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"});
        assertEquals(0, result);
    }
}

