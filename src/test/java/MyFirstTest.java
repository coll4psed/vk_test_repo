import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyFirstTest {

    @Test
    public void testTrue(){
        int a = 5;
        int b = 3;

        assertTrue(a > b, "а должно быть больше b");
    }
}
