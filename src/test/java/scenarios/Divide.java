package scenarios;

import com.automation.utils.Verification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tests.BaseClass;

public class Divide extends BaseClass {

    @ParameterizedTest
    @CsvSource({
            "4, 2",
            "3, 4",
            "5, 6",
            "7, 8",
            "8, 9",
            "9, 3",
            "8, 2",
            "5, 0"
    })
    void divideSingleDigitNumbers(int digit_1, int digit_2) {
        Assertions.assertEquals(Verification.checkDivide(digit_1, digit_2), divide(digit_1, digit_2));
    }
}
