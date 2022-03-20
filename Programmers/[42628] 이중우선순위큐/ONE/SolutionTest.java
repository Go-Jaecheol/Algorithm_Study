import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    Solution solution;

    @BeforeEach
    public void setSol(){
        solution = new Solution();
    }

    @Test
    public void solution_1(){
        int[] result = solution.solution(new String[]{"I 16","D 1"});
        assertArrayEquals(new int[]{0,0}, result);
    }

    @Test
    public void solution_2(){
        int[] result = solution.solution(new String[]{"I 7","I 5","I -5","D -1"});
        assertArrayEquals(new int[]{7,5}, result);
    }
}

