import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LogarithmModuleTest {

    @Test
    public void testLegalArgumentsLogBaseThreeModule() {
        NaturalLogarithm naturalLogarithm = Mockito.mock(NaturalLogarithm.class);
        Mockito.when(naturalLogarithm.of(Mockito.eq(3.0))).thenReturn(1.0986);
        Mockito.when(naturalLogarithm.of(Mockito.eq(1.0))).thenReturn(0.0);
        Mockito.when(naturalLogarithm.of(Mockito.eq(0.11412))).thenReturn(-2.1705);
        Mockito.when(naturalLogarithm.of(Mockito.eq(256.0))).thenReturn(5.5452);
        Mockito.when(naturalLogarithm.of(Mockito.eq(12.021))).thenReturn(2.4867);
        Mockito.when(naturalLogarithm.of(Mockito.doubleThat(x -> x <= 0))).thenReturn(Double.NaN);
        LogarithmFunctions logarithmFunctions = new LogarithmFunctions(naturalLogarithm);

        Assertions.assertAll(
                () -> Assertions.assertEquals(1, reduce(logarithmFunctions.log3(3), 4)),
                () -> Assertions.assertEquals(0, reduce(logarithmFunctions.log3(1), 4)),
                () -> Assertions.assertEquals(-1.9757, reduce(logarithmFunctions.log3(0.11412), 4)),
                () -> Assertions.assertEquals(5.0475, reduce(logarithmFunctions.log3(256), 4)),
                () -> Assertions.assertEquals(2.2635, reduce(logarithmFunctions.log3(12.021), 4)),
                () -> Assertions.assertEquals(Double.NaN, logarithmFunctions.log3(-1))
        );
    }

    @Test
    public void testIllegalArgumentsLogBaseThreeModule() {
        NaturalLogarithm naturalLogarithm = Mockito.mock(NaturalLogarithm.class, Mockito.withSettings().useConstructor(-0.01));
        Mockito.when(naturalLogarithm.of(Mockito.anyDouble())).thenThrow(new IllegalArgumentException());
        LogarithmFunctions logarithmFunctions = new LogarithmFunctions(naturalLogarithm);

        Assertions.assertAll(
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> logarithmFunctions.log3(2)),
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> logarithmFunctions.log3(-1))
        );
    }

    private double reduce(double x, int scale) {
        return BigDecimal.valueOf(x).setScale(scale, RoundingMode.HALF_UP).doubleValue();
    }
}
