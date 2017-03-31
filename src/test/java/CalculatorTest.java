import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    private Calculator calculator;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void shouldReturnZeroWhenGivenEmptyString() throws Exception {
        String numbers = "";
        int value = calculator.add(numbers);

        assertThat(value, is(0));
    }

    @Test
    public void shouldReturnTheParameterForSingleParameter() throws Exception {
        String numbers = "0";
        int value = calculator.add(numbers);

        assertThat(value, is(0));
    }

    @Test
    public void shouldReturnTheParameterForSingleParameterWhenGivenValueMoreThanZero() throws Exception {
        String numbers = "1";

        int value = calculator.add(numbers);

        assertThat(value, is(1));
    }

    @Test
    public void shouldReturnTheParameterForSingleParameterWhenGivenValueLessThanZero() throws Exception {
        String numbers = "-1";

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Negatives not allowed");

        int value = calculator.add(numbers);
    }

    @Test
    public void shouldReturnTheSumOfNumbersInTheParameterWhenGivenAParameterWithTwoNumbers() throws Exception {
        String numbers = "1,-2";

        int value = calculator.add(numbers);

        assertThat(value, is(-1));
    }

    @Test
    public void shouldReturnTheSumOfNumbersInTheParameterWhenGivenAParameterWithMoreThanTwoNumbers() throws Exception {
        String numbers = "1,2,3";

        int value = calculator.add(numbers);

        assertThat(value, is(6));
    }

    @Test
    public void shouldHandleNewLineDelimiterInTheParameter() throws Exception {
        String numbers = "1\n2,3";

        int value = calculator.add(numbers);

        assertThat(value, is(6));
    }

}
