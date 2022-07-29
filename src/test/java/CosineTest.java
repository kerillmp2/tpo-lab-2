import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CosineTest {

    @Test
    public void testLegalArgumentsCosine() {
        Cosine cosine = Cosine.withAccuracy(0.0000001);
        List<Double> testValues = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testValues.add(Math.random() * 10);
        }
        testValues.forEach(
                value -> Assertions.assertEquals(
                        reduce(Math.cos(value), 3),
                        reduce(cosine.of(value), 3)
                )
        );
        Assertions.assertAll(
                () -> Assertions.assertEquals(1, reduce(cosine.of(0), 1)),
                () -> Assertions.assertEquals(0, reduce(cosine.of(Math.PI / 2), 1)),
                () -> Assertions.assertEquals(-0.4315, reduce(cosine.of(8.30012), 4)),
                () -> Assertions.assertEquals(0.887, reduce(cosine.of(74.9182), 4)),
                () -> Assertions.assertEquals(-0.9117, reduce(cosine.of(Math.E), 4)),
                () -> Assertions.assertEquals(0.97, reduce(cosine.of(12.321), 4))
        );
    }

    @Test
    public void testIllegalArgumentsCosine() {
        LogarithmFunctions logarithmFunctions = LogarithmFunctions.withAccuracy(-0.0001);
        Assertions.assertAll(
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> logarithmFunctions.log3(2)),
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> logarithmFunctions.log3(-1))
        );
    }

    @Test
    public void testLegalArgumentsCosineModule() {
        Sinus sinus = Mockito.mock(Sinus.class);
        Mockito.when(sinus.of(Mockito.eq(3.0))).thenReturn(0.1411);
        Mockito.when(sinus.of(Mockito.eq(Math.PI))).thenReturn(0.0);
        Mockito.when(sinus.of(Mockito.eq(25.6))).thenReturn(0.4504);
        Mockito.when(sinus.of(Mockito.eq(-12.021))).thenReturn(0.5187);
        Mockito.when(sinus.of(Mockito.eq(-Math.PI / 2))).thenReturn(-1.0);
        Cosine cosine = new Cosine(sinus);

        Assertions.assertAll(
                () -> Assertions.assertEquals(-0.99, reduce(cosine.of(3.0), 4)),
                () -> Assertions.assertEquals(-1, reduce(cosine.of(Math.PI), 4)),
                () -> Assertions.assertEquals(0.8928, reduce(cosine.of(25.6), 4)),
                () -> Assertions.assertEquals(0.855, reduce(cosine.of(-12.021), 4)),
                () -> Assertions.assertEquals(0.0, reduce(cosine.of(-Math.PI / 2), 4))
        );
    }

    @Test
    public void testIllegalArgumentsCosineModule() {
        Sinus sinus = Mockito.mock(Sinus.class, Mockito.withSettings().useConstructor(-0.01));
        Mockito.when(sinus.of(Mockito.anyDouble())).thenThrow(new IllegalArgumentException());
        Cosine cosine = new Cosine(sinus);

        Assertions.assertAll(
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> cosine.of(2)),
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> cosine.of(-1))
        );
    }

    private double reduce(double x, int scale) {
        return BigDecimal.valueOf(x).setScale(scale, RoundingMode.HALF_UP).doubleValue();
    }
}
