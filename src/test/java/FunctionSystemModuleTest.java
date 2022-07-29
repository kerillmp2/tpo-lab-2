import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class FunctionSystemModuleTest {

    @Test
    public void testPositiveArgumentFunctionSystemModule() {
        LogarithmFunctions logarithmFunctions = Mockito.mock(LogarithmFunctions.class);
        TrigonometricFunctions trigonometricFunctions = Mockito.mock(TrigonometricFunctions.class);
        Mockito.when(logarithmFunctions.log3(Mockito.eq(0))).thenReturn(Double.NaN);
        Mockito.when(logarithmFunctions.ln(Mockito.eq(0))).thenReturn(Double.NaN);
        Mockito.when(logarithmFunctions.log3(Mockito.eq(12.7))).thenReturn(2.3134);
        Mockito.when(logarithmFunctions.ln(Mockito.eq(12.7))).thenReturn(2.5416);
        Mockito.when(logarithmFunctions.log3(Mockito.eq(10 * Math.PI / 9))).thenReturn(1.13788);
        Mockito.when(logarithmFunctions.ln(Mockito.eq(10 * Math.PI / 9))).thenReturn(1.25009);

        FunctionSystem functionSystem = new FunctionSystem(logarithmFunctions, trigonometricFunctions);

        Assertions.assertAll(
                () -> Assertions.assertEquals(Double.NaN, reduce(functionSystem.result(0), 4)),
                () -> Assertions.assertEquals(63727.3952, reduce(functionSystem.result(12.7), 4)),
                () -> Assertions.assertEquals(37.0166, reduce(functionSystem.result(10 * Math.PI / 9), 4)),
                () -> Assertions.assertEquals(0.0, reduce(functionSystem.result(1), 4))
        );
    }

    @Test
    public void testNegativeArgumentFunctionSystemModule() {
        LogarithmFunctions logarithmFunctions = Mockito.mock(LogarithmFunctions.class);
        TrigonometricFunctions trigonometricFunctions = Mockito.mock(TrigonometricFunctions.class);

        Mockito.when(trigonometricFunctions.sin(Mockito.eq(-2.1))).thenReturn(-0.8632);
        Mockito.when(trigonometricFunctions.cos(Mockito.eq(-2.1))).thenReturn(-0.5048);
        Mockito.when(trigonometricFunctions.tan(Mockito.eq(-2.1))).thenReturn(1.70985);
        Mockito.when(trigonometricFunctions.cot(Mockito.eq(-2.1))).thenReturn(0.584848);
        Mockito.when(trigonometricFunctions.csc(Mockito.eq(-2.1))).thenReturn(-1.15847);
        Mockito.when(trigonometricFunctions.sec(Mockito.eq(-2.1))).thenReturn(-1.9808);

        Mockito.when(trigonometricFunctions.sin(Mockito.eq(-3 * Math.PI / 2))).thenReturn(1.0);
        Mockito.when(trigonometricFunctions.cos(Mockito.eq(-3 * Math.PI / 2))).thenReturn(0.0);
        Mockito.when(trigonometricFunctions.tan(Mockito.eq(-3 * Math.PI / 2))).thenReturn(Double.NaN);
        Mockito.when(trigonometricFunctions.cot(Mockito.eq(-3 * Math.PI / 2))).thenReturn(0.0);
        Mockito.when(trigonometricFunctions.csc(Mockito.eq(-3 * Math.PI / 2))).thenReturn(1.0);
        Mockito.when(trigonometricFunctions.sec(Mockito.eq(-3 * Math.PI / 2))).thenReturn(Double.NaN);

        Mockito.when(trigonometricFunctions.sin(Mockito.eq(-0.01))).thenReturn(-0.009999);
        Mockito.when(trigonometricFunctions.cos(Mockito.eq(-0.01))).thenReturn(0.99995);
        Mockito.when(trigonometricFunctions.tan(Mockito.eq(-0.01))).thenReturn(-0.01);
        Mockito.when(trigonometricFunctions.cot(Mockito.eq(-0.01))).thenReturn(-99.9967);
        Mockito.when(trigonometricFunctions.csc(Mockito.eq(-0.01))).thenReturn(-100.002);
        Mockito.when(trigonometricFunctions.sec(Mockito.eq(-0.01))).thenReturn(1.00005);

        FunctionSystem functionSystem = new FunctionSystem(logarithmFunctions, trigonometricFunctions);

        Assertions.assertAll(
                () -> Assertions.assertEquals(-361107.7118, reduce(functionSystem.result(-2.1), 4)),
                () -> Assertions.assertEquals(Double.NaN, reduce(functionSystem.result(-3 * Math.PI / 2), 4)),
                () -> Assertions.assertEquals(-1020420.0887, reduce(functionSystem.result(-0.01), 4))
        );
    }

    private double reduce(double x, int scale) {
        return Double.isNaN(x) ? x : BigDecimal.valueOf(x).setScale(scale, RoundingMode.HALF_UP).doubleValue();
    }
}
