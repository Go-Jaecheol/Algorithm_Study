import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    Solution sol;

    @BeforeEach
    public void setSol(){
        sol = new Solution();
    }

    @Test
    public void solution_1(){
        assertEquals(5, sol.solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
    }

    @Test
    public void solution_2(){
        assertEquals(4, sol.solution(5, new int[]{2, 4}, new int[]{3}));
    }

    @Test
    public void solution_3(){
        assertEquals(2, sol.solution(3, new int[]{3}, new int[]{1}));
    }
}
