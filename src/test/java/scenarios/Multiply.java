package scenarios;

import com.automation.utils.Verification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tests.BaseClass;

public class Multiply extends BaseClass {

    @ParameterizedTest
    @CsvSource({
            "1, 2",
            "3, 4",
            "5, 6",
            "7, 8",
            "8, 9",
            "9, 3",
            "4, 5",
            "5, 5"
    })
    void multiplySingleDigitNumbers(int digit_1, int digit_2) {
        Assertions.assertEquals(Verification.checkMultiply(digit_1, digit_2), multiply(digit_1, digit_2));
    }
}
