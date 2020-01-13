package tennis.set;

import org.junit.Test;

import static org.junit.Assert.*;

public class SetTest {

    private Set set;

    @Test
    public void getScore_should_return_0_0_when_empty_set() {
        set = new Set();
        assertEquals("(0-0)", Set.getScore(set));
    }

    @Test
    public void getScore_should_return_4_2() {
        set = new Set(4, 2);
        assertEquals("(4-2)", Set.getScore(set));
    }
}