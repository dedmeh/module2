import org.example.FizzBuzz;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    FizzBuzz fizzBuzz = new FizzBuzz();
    @Test
    public void Five() {
        String expected = "Buzz";
        String actual = fizzBuzz.translate(5);
        assertEquals(expected, actual);
    }
    @Test
    public void Nine() {
        String expected = "Fizz";
        String actual = fizzBuzz.translate(9);
        assertEquals(expected, actual);
    }
    @Test
    public void Fifteen() {
        String expected = "FizzBuzz";
        String actual = fizzBuzz.translate(15);
        assertEquals(expected, actual);
    }
}
