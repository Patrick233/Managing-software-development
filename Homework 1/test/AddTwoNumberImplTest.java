import java.util.List;

import static org.junit.Assert.*;

public class AddTwoNumberImplTest {

    AddTwoNumberImpl addTwoNumber = new AddTwoNumberImpl();

    @org.junit.Test
    public void addTwoNumber() {
        List<Integer> test1 = addTwoNumber.addTwoNumber(0,1);
        assertEquals(0, test1.size());

        List<Integer> test2 = addTwoNumber.addTwoNumber(0,6);
        assertTrue(test2.get(0) == 1);
        assertTrue(test2.get(1) == 3);
        assertTrue(test2.get(2) == 5);
    }
}