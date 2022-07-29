import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrigonometricFunctionsTest {

    @Test
    public void testLegalArgumentsSin() {
        TrigonometricFunctions trigonometricFunctions = TrigonometricFunctions.withAccuracy(0.000001);
        Assertions.assertAll(
                () -> Assertions.assertEquals(0, reduce(trigonometricFunctions.sin(0), 1)),
                () -> Assertions.assertEquals(1, reduce(trigonometricFunctions.sin(Math.PI / 2), 1)),
                () -> Assertions.assertEquals(0, reduce(trigonometricFunctions.sin(100 * Math.PI), 1)),
                () -> Assertions.assertEquals(-1, reduce(trigonometricFunctions.sin(Math.PI / 2 * 3), 4)),
                () -> Assertions.assertEquals(0.9351, reduce(trigonometricFunctions.sin(7.49182), 4)),
                () -> Assertions.assertEquals(-0.2402, reduce(trigonometricFunctions.sin(Math.E * 20 / 9), 4)),
                () -> Assertions.assertEquals(0.0354, reduce(trigonometricFunctions.sin(88), 4))
        );
    }

    @Test
    public void testLegalArgumentsCos() {
        TrigonometricFunctions trigonometricFunctions = TrigonometricFunctions.withAccuracy(0.000001);
        Assertions.assertAll(
                () -> Assertions.assertEquals(1, reduce(trigonometricFunctions.cos(0), 1)),
                () -> Assertions.assertEquals(0, reduce(trigonometricFunctions.cos(Math.PI / 2), 1)),
                () -> Assertions.assertEquals(-1, reduce(trigonometricFunctions.cos(3 * Math.PI), 1)),
                () -> Assertions.assertEquals(0.0998, reduce(trigonometricFunctions.cos(Math.PI / 2 - 0.1), 4)),
                () -> Assertions.assertEquals(-0.0224, reduce(trigonometricFunctions.cos(-95.841), 4)),
                () -> Assertions.assertEquals(-0.9117, reduce(trigonometricFunctions.cos(Math.E), 4)),
                () -> Assertions.assertEquals(0.97, reduce(trigonometricFunctions.cos(12.321), 4))
        );
    }

    @Test
    public void testLegalArgumentsSec() {
        TrigonometricFunctions trigonometricFunctions = TrigonometricFunctions.withAccuracy(0.000001);
        Assertions.assertAll(
                () -> Assertions.assertEquals(1, reduce(trigonometricFunctions.sec(0), 1)),
                () -> Assertions.assertEquals(Double.NaN, reduce(trigonometricFunctions.sec(Math.PI / 2), 1)),
                () -> Assertions.assertEquals(1, reduce(trigonometricFunctions.sec(2 * Math.PI), 1)),
                () -> Assertions.assertEquals(10.0167, reduce(trigonometricFunctions.sec(Math.PI / 2 - 0.1), 4)),
                () -> Assertions.assertEquals(1.1274, reduce(trigonometricFunctions.sec(74.9182), 4)),
                () -> Assertions.assertEquals(-1.0968, reduce(trigonometricFunctions.sec(Math.E), 4)),
                () -> Assertions.assertEquals(1.0309, reduce(trigonometricFunctions.sec(12.321), 4))
        );
    }

    @Test
    public void testLegalArgumentsCsc() {
        TrigonometricFunctions trigonometricFunctions = TrigonometricFunctions.withAccuracy(0.00001);
        Assertions.assertAll(
                () -> Assertions.assertEquals(Double.NaN, reduce(trigonometricFunctions.csc(0), 1)),
                () -> Assertions.assertEquals(1, reduce(trigonometricFunctions.csc(Math.PI / 2), 1)),
                () -> Assertions.assertEquals(1000, reduce(trigonometricFunctions.csc(0.001), 1)),
                () -> Assertions.assertEquals(1.1085, reduce(trigonometricFunctions.csc(8.30012), 4)),
                () -> Assertions.assertEquals(2.1654, reduce(trigonometricFunctions.csc(-74.9182), 4)),
                () -> Assertions.assertEquals(-1.0075, reduce(trigonometricFunctions.csc(Math.E * 4), 4)),
                () -> Assertions.assertEquals(-4.1167, reduce(trigonometricFunctions.csc(12.321), 4))
        );
    }

    @Test
    public void testLegalArgumentsTan() {
        TrigonometricFunctions trigonometricFunctions = TrigonometricFunctions.withAccuracy(0.000001);
        Assertions.assertAll(
                () -> Assertions.assertEquals(0, reduce(trigonometricFunctions.tan(0), 1)),
                () -> Assertions.assertEquals(Double.NaN, reduce(trigonometricFunctions.tan(Math.PI / 2), 1)),
                () -> Assertions.assertEquals(-99.997, reduce(trigonometricFunctions.tan(Math.PI / 2 + 0.01), 3)),
                () -> Assertions.assertEquals(-0.591, reduce(trigonometricFunctions.tan(8.891), 4)),
                () -> Assertions.assertEquals(1.8017, reduce(trigonometricFunctions.tan(-42.9182), 4)),
                () -> Assertions.assertEquals(0.2523, reduce(trigonometricFunctions.tan(Math.E / 11), 4)),
                () -> Assertions.assertEquals(0.001, reduce(trigonometricFunctions.tan(0.001), 4))
        );
    }

    @Test
    public void testLegalArgumentsCot() {
        TrigonometricFunctions trigonometricFunctions = TrigonometricFunctions.withAccuracy(0.000001);
        Assertions.assertAll(
                () -> Assertions.assertEquals(Double.NaN, reduce(trigonometricFunctions.cot(0), 1)),
                () -> Assertions.assertEquals(0, reduce(trigonometricFunctions.cot(Math.PI / 2), 1)),
                () -> Assertions.assertEquals(-0.01, reduce(trigonometricFunctions.cot(Math.PI / 2 + 0.01), 2)),
                () -> Assertions.assertEquals(0.555, reduce(trigonometricFunctions.cot(-42.9182), 3)),
                () -> Assertions.assertEquals(3.964, reduce(trigonometricFunctions.cot(Math.E / 11), 4)),
                () -> Assertions.assertEquals(-99.997, reduce(trigonometricFunctions.cot(-0.01), 3))
        );
    }

    @Test
    public void testIllegalArgumentsTrigonometricFunctions() {
        TrigonometricFunctions trigonometricFunctions = TrigonometricFunctions.withAccuracy(-0.000001);

        Assertions.assertAll(
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> trigonometricFunctions.sec(2)),
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> trigonometricFunctions.sec(-1)),
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> trigonometricFunctions.csc(2)),
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> trigonometricFunctions.csc(-1)),
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> trigonometricFunctions.tan(2)),
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> trigonometricFunctions.tan(-1)),
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> trigonometricFunctions.cot(2)),
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> trigonometricFunctions.cot(-1)),
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> trigonometricFunctions.cos(2)),
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> trigonometricFunctions.cos(-1)),
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> trigonometricFunctions.sin(2)),
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> trigonometricFunctions.sin(-1))
        );
    }

    private double reduce(double x, int scale) {
        return Double.isNaN(x) ? x : BigDecimal.valueOf(x).setScale(scale, RoundingMode.HALF_UP).doubleValue();
    }
}
