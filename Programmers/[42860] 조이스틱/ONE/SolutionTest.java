import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    Solution solution;

    @BeforeEach
    public void setSol(){
        solution = new Solution();
    }

    @Test
    public void solution_1(){
        int result = solution.solution("ABAAAAABB");
        Assertions.assertEquals(solution.solution("ABBAAAAAB"), result);
    }

    @Test
    public void solution_2(){
        int result = solution.solution("JAN");
        Assertions.assertEquals(23, result);
    }
}
