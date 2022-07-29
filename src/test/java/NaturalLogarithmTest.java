import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NaturalLogarithmTest {

    @Test
    public void testLegalArgumentsNaturalLog() {
        NaturalLogarithm naturalLogarithm = new NaturalLogarithm(0.000001);
        List<Double> testValues = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testValues.add(Math.random());
        }
        testValues.forEach(
                value -> Assertions.assertEquals(
                        reduce(Math.log(value), 3),
                        reduce(naturalLogarithm.of(value), 3)
                )
        );
        Assertions.assertAll(
                () -> Assertions.assertEquals(0, reduce(naturalLogarithm.of(1), 1)),
                () -> Assertions.assertEquals(Double.NaN, naturalLogarithm.of(0)),
                () -> Assertions.assertEquals(-0.8137, reduce(naturalLogarithm.of(0.4432), 4)),
                () -> Assertions.assertEquals(3.1638, reduce(naturalLogarithm.of(23.6610), 4)),
                () -> Assertions.assertEquals(1, reduce(naturalLogarithm.of(Math.E), 4)),
                () -> Assertions.assertEquals(9.4185, reduce(naturalLogarithm.of(12321), 4))
        );
    }

    @Test
    public void testIllegalArgumentsNaturalLog() {
        NaturalLogarithm naturalLogarithm = new NaturalLogarithm(-0.001);
        Assertions.assertAll(
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> naturalLogarithm.of(2)),
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> naturalLogarithm.of(-1))
        );
    }

    private double reduce(double x, int scale) {
        return BigDecimal.valueOf(x).setScale(scale, RoundingMode.HALF_UP).doubleValue();
    }
}
