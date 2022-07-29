import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogarithmTest {

    @Test
    public void testLegalArgumentsLogBaseThree() {
        LogarithmFunctions logarithmFunctions = LogarithmFunctions.withAccuracy(0.0000001);
        List<Double> testValues = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testValues.add(Math.random());
        }
        testValues.forEach(
                value -> Assertions.assertEquals(
                        reduce(Math.log(value) / Math.log(3), 3),
                        reduce(logarithmFunctions.log3(value), 3)
                )
        );
        Assertions.assertAll(
                () -> Assertions.assertEquals(0, reduce(logarithmFunctions.log3(1), 1)),
                () -> Assertions.assertEquals(Double.NaN, logarithmFunctions.log3(0)),
                () -> Assertions.assertEquals(1.9263, reduce(logarithmFunctions.log3(8.30012), 4)),
                () -> Assertions.assertEquals(3.92895, reduce(logarithmFunctions.log3(74.9182), 5)),
                () -> Assertions.assertEquals(0.9102, reduce(logarithmFunctions.log3(Math.E), 4)),
                () -> Assertions.assertEquals(8.5735, reduce(logarithmFunctions.log3(12321), 4))
        );
    }

    @Test
    public void testIllegalArgumentsLogBaseThree() {
        LogarithmFunctions logarithmFunctions = LogarithmFunctions.withAccuracy(-0.0001);
        Assertions.assertAll(
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> logarithmFunctions.log3(2)),
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> logarithmFunctions.log3(-1))
        );
    }

    private double reduce(double x, int scale) {
        return BigDecimal.valueOf(x).setScale(scale, RoundingMode.HALF_UP).doubleValue();
    }
}
