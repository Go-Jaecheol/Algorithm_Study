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
        String result = solution.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"});
        assertEquals("leo", result);
    }

    @Test
    public void solution_2(){
        String result = solution.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"});
        assertEquals("vinko", result);
    }

    @Test
    public void solution_3(){
        String result = solution.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"});
        assertEquals("mislav", result);
    }
}
