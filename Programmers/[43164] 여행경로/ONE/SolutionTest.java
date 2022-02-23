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
        String[] result = solution.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
        assertArrayEquals(new String[]{"ICN", "JFK", "HND", "IAD"}, result);
    }

    @Test
    public void solution_2(){
        String[] result = solution.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}});
        assertArrayEquals(new String[]{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"}, result);
    }

    @Test
    public void solution_3(){
        String[] result = solution.solution(new String[][]{{"ICN", "AOO"}, {"AOO", "BOO"}, {"BOO", "COO"}, {"COO", "DOO"}, {"DOO", "EOO"}, {"EOO", "DOO"}, {"DOO", "COO"}, {"COO", "BOO"}, {"BOO", "AOO"}});
        assertArrayEquals(new String[]{"ICN", "AOO", "BOO", "COO", "DOO", "EOO", "DOO", "COO", "BOO", "AOO"}, result);
    }
}

