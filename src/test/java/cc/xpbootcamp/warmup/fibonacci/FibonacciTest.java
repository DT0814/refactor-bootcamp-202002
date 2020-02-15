package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FibonacciTest {
    @Test
    void should_be_return_1_when_calculate_given_position_is_1() {
        //Arrange

        //Act
        int result = Fibonacci.calculate(1);
        //Assert
        Assertions.assertEquals(1, result);
    }

    @Test
    void should_be_return_2_when_calculate_given_position_is_1() {
        //Arrange

        //Act
        int result = Fibonacci.calculate(2);
        //Assert
        Assertions.assertEquals(1, result);
    }
}
