import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SinusTest {

    @Test
    public void testLegalArgumentsSinus() {
        Sinus sinus = new Sinus(0.000001);
        List<Double> testValues = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testValues.add(Math.random() * 100);
        }
        testValues.forEach(
                value -> Assertions.assertEquals(
                        reduce(Math.sin(value), 3),
                        reduce(sinus.of(value), 3)
                )
        );
        Assertions.assertAll(
                () -> Assertions.assertEquals(1, reduce(sinus.of(Math.PI / 2), 1)),
                () -> Assertions.assertEquals(0, sinus.of(0)),
                () -> Assertions.assertEquals(0.4288, reduce(sinus.of(0.4432), 4)),
                () -> Assertions.assertEquals(-0.9951, reduce(sinus.of(23.6610), 4)),
                () -> Assertions.assertEquals(0.4108, reduce(sinus.of(Math.E), 4)),
                () -> Assertions.assertEquals(0.9749, reduce(sinus.of(-11.22), 4))
        );
    }

    @Test
    public void testIllegalArgumentsSinus() {
        Sinus sinus = new Sinus(-0.001);
        Assertions.assertAll(
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> sinus.of(2)),
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> sinus.of(-1))
        );
    }

    private double reduce(double x, int scale) {
        return BigDecimal.valueOf(x).setScale(scale, RoundingMode.HALF_UP).doubleValue();
    }
}
