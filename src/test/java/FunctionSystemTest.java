import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FunctionSystemTest {

    @Test
    public void testPositiveArgumentFunctionSystem() {
        FunctionSystem functionSystem = FunctionSystem.withAccuracy(0.00001);

        Assertions.assertAll(
                () -> Assertions.assertEquals(Double.NaN, reduce(functionSystem.result(0), 4)),
                () -> Assertions.assertEquals(0.1046, reduce(functionSystem.result(Math.PI / 2), 4)),
                () -> Assertions.assertEquals(2244542.0457, reduce(functionSystem.result(10 * Math.PI), 4)),
                () -> Assertions.assertEquals(286.3251, reduce(functionSystem.result(Math.PI / 2 * 3), 4)),
                () -> Assertions.assertEquals(4590.8991, reduce(functionSystem.result(7.49182), 4)),
                () -> Assertions.assertEquals(1342.5865, reduce(functionSystem.result(Math.E * 20 / 9), 4)),
                () -> Assertions.assertEquals(0.0, reduce(functionSystem.result(1), 4))
        );
    }

    @Test
    public void testNegativeArgumentFunctionSystem() {
        FunctionSystem functionSystem = FunctionSystem.withAccuracy(0.00001);

        Assertions.assertAll(
                () -> Assertions.assertEquals(-55.2609, reduce(functionSystem.result(-Math.PI / 2 + 1.2), 4)),
                () -> Assertions.assertEquals(Double.NaN, reduce(functionSystem.result(-Math.PI / 2 * 3), 4)),
                () -> Assertions.assertEquals(-1250.5709, reduce(functionSystem.result(-0.1), 4)),
                () -> Assertions.assertEquals(45.0341, reduce(functionSystem.result(-Math.E * 20 / 9), 4)),
                () -> Assertions.assertEquals(-24249.4858, reduce(functionSystem.result(-88), 4))
        );
    }

    @Test
    public void testIllegalArgumentFunctionSystem() {
        FunctionSystem functionSystem = FunctionSystem.withAccuracy(-0.000001);

        Assertions.assertAll(
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> functionSystem.result(2)),
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> functionSystem.result(-1))
        );
    }

    private double reduce(double x, int scale) {
        return Double.isNaN(x) ? x : BigDecimal.valueOf(x).setScale(scale, RoundingMode.HALF_UP).doubleValue();
    }
}
