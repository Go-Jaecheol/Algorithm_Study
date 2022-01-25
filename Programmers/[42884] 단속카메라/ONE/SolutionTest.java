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
        int result = solution.solution(new int[][]{{-20,-15},{-14,-5},{-18,-13},{-5,-3}});
        assertEquals(2, result);
    }

    @Test
    public void solution_2(){
        int result = solution.solution(new int[][]{{-2,-1},{1,2},{-3,-0}});
        assertEquals(2, result);
    }

    @Test
    public void solution_3(){
        int result = solution.solution(new int[][]{{0,0},});
        assertEquals(1, result);
    }

    @Test
    public void solution_4(){
        int result = solution.solution(new int[][]{{0,1},{0,1},{1,2}});
        assertEquals(1, result);
    }

    @Test
    public void solution_5(){
        int result = solution.solution(new int[][]{{-20,15},{-14,-5},{-18,-13},{-5,-3}});
        assertEquals(2, result);
    }

    @Test
    public void solution_6(){
        int result = solution.solution(new int[][]{{-20,-15},{-20,15},{-14,-5},{-18,-13},{-5,-3}});
        assertEquals(2, result);
    }
}
