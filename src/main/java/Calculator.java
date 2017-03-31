import java.util.Arrays;

public class Calculator {
    public int add(String numbers) {
        if (!numbers.equals("")) {
            String[] values = numbers.split("[\n,]");
            return Arrays.stream(values).mapToInt(Integer::parseInt).sum();
        }
        return 0;
    }
}
