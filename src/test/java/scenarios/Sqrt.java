package scenarios;

import com.automation.utils.Verification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import tests.BaseClass;

public class Sqrt extends BaseClass {

    @ParameterizedTest
    @MethodSource("com.automation.utils.TestUtils#argsProvider")
    void sqrtSingleDigitNumbers(int digit_1) {
        Assertions.assertEquals(Verification.checkRoot(digit_1), sqrt(digit_1));
    }
}
