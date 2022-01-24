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
        int result = solution.solution(4, new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}});
        assertEquals(4, result);
    }

    @Test
    public void solution_2(){
        int result = solution.solution(5, new int[][]{{0,1,5},{1,2,3},{2,3,3},{3,1,2},{3,0,4},{2,4,6},{4,0,7}});
        assertEquals(15, result);
    }

    @Test
    public void solution_3(){
        int result = solution.solution(5, new int[][]{{0,1,1},{3,4,1},{1,2,2},{2,3,4}});
        assertEquals(8, result);
    }

    @Test
    public void solution_4(){
        int result = solution.solution(4, new int[][]{{0,1,5},{1,2,3},{2,3,3},{1,3,2},{0,3,4}});
        assertEquals(9, result);
    }

    @Test
    public void solution_5(){
        int result = solution.solution(4, new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}});
        assertEquals(4, result);
    }

    @Test
    public void solution_6(){
        int result = solution.solution(5, new int[][]{{0,1,1},{3,1,1},{0,2,2},{0,3,2},{0,4,100}});
        assertEquals(104, result);
    }

    @Test
    public void solution_7(){
        int result = solution.solution(6, new int[][]{{0,1,5},{0,3,2},{0,4,3},{1,4,1},{3,4,10},{1,2,2},{2,5,3},{4,5,4}});
        assertEquals(11, result);
    }

    @Test
    public void solution_8(){
        int result = solution.solution(5, new int[][]{{0,1,1},{2,3,1},{3,4,2},{1,2,2},{0,4,100}});
        assertEquals(6, result);
    }

    @Test
    public void solution_9(){
        int result = solution.solution(5, new int[][]{{0,1,1},{0,4,5},{2,4,1},{2,3,1},{3,4,1}});
        assertEquals(8, result);
    }

    @Test
    public void solution_10(){
        int result = solution.solution(5, new int[][]{{0,1,1},{0,2,2},{0,3,3},{0,4,4},{1,3,1}});
        assertEquals(8, result);
    }
}
