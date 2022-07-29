import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TrigonometricFunctionsModuleTest {

    @Test
    public void testLegalArgumentsSinModule() {
        Sinus sinus = Mockito.mock(Sinus.class);
        Cosine cosine = Mockito.mock(Cosine.class);
        Mockito.when(sinus.of(Mockito.eq(0))).thenReturn(0.0);
        Mockito.when(sinus.of(Mockito.eq(Math.PI / 2))).thenReturn(1.0);
        Mockito.when(sinus.of(Mockito.eq(8.30012))).thenReturn(0.90212);
        Mockito.when(sinus.of(Mockito.eq(-74.9182))).thenReturn(0.4618);
        Mockito.when(sinus.of(Mockito.eq(Math.E * 4))).thenReturn(-0.9925);
        Mockito.when(sinus.of(Mockito.eq(12.321))).thenReturn(-0.24291);
        TrigonometricFunctions trigonometricFunctions = new TrigonometricFunctions(sinus, cosine);

        Assertions.assertAll(
                () -> Assertions.assertEquals(0.0, reduce(trigonometricFunctions.sin(0), 1)),
                () -> Assertions.assertEquals(1.0, reduce(trigonometricFunctions.sin(Math.PI / 2), 1)),
                () -> Assertions.assertEquals(0.9021, reduce(trigonometricFunctions.sin(8.30012), 4)),
                () -> Assertions.assertEquals(0.4618, reduce(trigonometricFunctions.sin(-74.9182), 4)),
                () -> Assertions.assertEquals(-0.9925, reduce(trigonometricFunctions.sin(Math.E * 4), 4)),
                () -> Assertions.assertEquals(-0.2429, reduce(trigonometricFunctions.sin(12.321), 4))
        );
    }

    @Test
    public void testLegalArgumentsCosModule() {
        Sinus sinus = Mockito.mock(Sinus.class);
        Cosine cosine = Mockito.mock(Cosine.class);
        Mockito.when(cosine.of(Mockito.eq(Math.PI / 6))).thenReturn(0.866);
        Mockito.when(cosine.of(Mockito.eq(1.444))).thenReturn(0.12645);
        Mockito.when(cosine.of(Mockito.eq(-0.14))).thenReturn(0.9902);
        Mockito.when(cosine.of(Mockito.eq(Math.PI * 2))).thenReturn(1.0);
        Mockito.when(cosine.of(Mockito.eq(12.021))).thenReturn(0.855);
        Mockito.when(cosine.of(Mockito.eq(Math.PI / 2))).thenReturn(0.0);
        TrigonometricFunctions trigonometricFunctions = new TrigonometricFunctions(sinus, cosine);

        Assertions.assertAll(
                () -> Assertions.assertEquals(0.866, reduce(trigonometricFunctions.cos(Math.PI / 6), 4)),
                () -> Assertions.assertEquals(0.1265, reduce(trigonometricFunctions.cos(1.444), 4)),
                () -> Assertions.assertEquals(0.9902, reduce(trigonometricFunctions.cos(-0.14), 4)),
                () -> Assertions.assertEquals(1, reduce(trigonometricFunctions.cos(Math.PI * 2), 4)),
                () -> Assertions.assertEquals(0.855, reduce(trigonometricFunctions.cos(12.021), 4)),
                () -> Assertions.assertEquals(0.0, reduce(trigonometricFunctions.cos(Math.PI / 2), 4))
        );
    }

    @Test
    public void testLegalArgumentsSecModule() {
        Sinus sinus = Mockito.mock(Sinus.class);
        Cosine cosine = Mockito.mock(Cosine.class);
        Mockito.when(cosine.of(Mockito.eq(Math.PI / 6))).thenReturn(0.866);
        Mockito.when(cosine.of(Mockito.eq(1.444))).thenReturn(0.12645);
        Mockito.when(cosine.of(Mockito.eq(-0.14))).thenReturn(0.9902);
        Mockito.when(cosine.of(Mockito.eq(Math.PI * 2))).thenReturn(1.0);
        Mockito.when(cosine.of(Mockito.eq(12.021))).thenReturn(0.855);
        Mockito.when(cosine.of(Mockito.eq(Math.PI / 2))).thenReturn(0.0);
        TrigonometricFunctions trigonometricFunctions = new TrigonometricFunctions(sinus, cosine);

        Assertions.assertAll(
                () -> Assertions.assertEquals(1.1547, reduce(trigonometricFunctions.sec(Math.PI / 6), 4)),
                () -> Assertions.assertEquals(7.9083, reduce(trigonometricFunctions.sec(1.444), 4)),
                () -> Assertions.assertEquals(1.0099, reduce(trigonometricFunctions.sec(-0.14), 4)),
                () -> Assertions.assertEquals(1, reduce(trigonometricFunctions.sec(Math.PI * 2), 4)),
                () -> Assertions.assertEquals(1.1696, reduce(trigonometricFunctions.sec(12.021), 4)),
                () -> Assertions.assertEquals(Double.NaN, trigonometricFunctions.sec(Math.PI / 2))
        );
    }

    @Test
    public void testLegalArgumentsCscModule() {
        Sinus sinus = Mockito.mock(Sinus.class);
        Cosine cosine = Mockito.mock(Cosine.class);
        Mockito.when(sinus.of(Mockito.eq(0))).thenReturn(0.0);
        Mockito.when(sinus.of(Mockito.eq(Math.PI / 2))).thenReturn(1.0);
        Mockito.when(sinus.of(Mockito.eq(8.30012))).thenReturn(0.90212);
        Mockito.when(sinus.of(Mockito.eq(-74.9182))).thenReturn(0.4618);
        Mockito.when(sinus.of(Mockito.eq(Math.E * 4))).thenReturn(-0.9925);
        Mockito.when(sinus.of(Mockito.eq(12.321))).thenReturn(-0.24291);
        TrigonometricFunctions trigonometricFunctions = new TrigonometricFunctions(sinus, cosine);

        Assertions.assertAll(
                () -> Assertions.assertEquals(Double.NaN, reduce(trigonometricFunctions.csc(0), 1)),
                () -> Assertions.assertEquals(1, reduce(trigonometricFunctions.csc(Math.PI / 2), 1)),
                () -> Assertions.assertEquals(1.1085, reduce(trigonometricFunctions.csc(8.30012), 4)),
                () -> Assertions.assertEquals(2.1654, reduce(trigonometricFunctions.csc(-74.9182), 4)),
                () -> Assertions.assertEquals(-1.0076, reduce(trigonometricFunctions.csc(Math.E * 4), 4)),
                () -> Assertions.assertEquals(-4.1168, reduce(trigonometricFunctions.csc(12.321), 4))
        );
    }

    @Test
    public void testLegalArgumentsTanModule() {
        Sinus sinus = Mockito.mock(Sinus.class);
        Cosine cosine = Mockito.mock(Cosine.class);
        Mockito.when(sinus.of(Mockito.eq(0))).thenReturn(0.0);
        Mockito.when(sinus.of(Mockito.eq(Math.PI / 2))).thenReturn(1.0);
        Mockito.when(cosine.of(Mockito.eq(Math.PI / 2))).thenReturn(0.0);
        Mockito.when(sinus.of(Mockito.eq(8.30012))).thenReturn(0.90212);
        Mockito.when(cosine.of(Mockito.eq(8.30012))).thenReturn(-0.431485);
        Mockito.when(sinus.of(Mockito.eq(-74.9182))).thenReturn(0.4618);
        Mockito.when(cosine.of(Mockito.eq(-74.9182))).thenReturn(0.886984);
        Mockito.when(sinus.of(Mockito.eq(Math.E * 4))).thenReturn(-0.9925);
        Mockito.when(cosine.of(Mockito.eq(Math.E * 4))).thenReturn(-0.12214);
        Mockito.when(sinus.of(Mockito.eq(12.321))).thenReturn(-0.24291);
        Mockito.when(cosine.of(Mockito.eq(12.321))).thenReturn(0.970047);
        Mockito.when(cosine.of(Mockito.eq(0.0))).thenReturn(1.0);

        TrigonometricFunctions trigonometricFunctions = new TrigonometricFunctions(sinus, cosine);

        Assertions.assertAll(
                () -> Assertions.assertEquals(0, reduce(trigonometricFunctions.tan(0), 1)),
                () -> Assertions.assertEquals(Double.NaN, reduce(trigonometricFunctions.tan(Math.PI / 2), 1)),
                () -> Assertions.assertEquals(-2.0907, reduce(trigonometricFunctions.tan(8.30012), 4)),
                () -> Assertions.assertEquals(0.5206, reduce(trigonometricFunctions.tan(-74.9182), 4)),
                () -> Assertions.assertEquals(8.1259, reduce(trigonometricFunctions.tan(Math.E * 4), 4)),
                () -> Assertions.assertEquals(-0.2504, reduce(trigonometricFunctions.tan(12.321), 4))
        );
    }

    @Test
    public void testLegalArgumentsCotModule() {
        Sinus sinus = Mockito.mock(Sinus.class);
        Cosine cosine = Mockito.mock(Cosine.class);
        Mockito.when(sinus.of(Mockito.eq(0.0))).thenReturn(0.0);
        Mockito.when(sinus.of(Mockito.eq(Math.PI / 2))).thenReturn(1.0);
        Mockito.when(cosine.of(Mockito.eq(Math.PI / 2))).thenReturn(0.0);
        Mockito.when(sinus.of(Mockito.eq(8.30012))).thenReturn(0.90212);
        Mockito.when(cosine.of(Mockito.eq(8.30012))).thenReturn(-0.431485);
        Mockito.when(sinus.of(Mockito.eq(-74.9182))).thenReturn(0.4618);
        Mockito.when(cosine.of(Mockito.eq(-74.9182))).thenReturn(0.886984);
        Mockito.when(sinus.of(Mockito.eq(Math.E * 4))).thenReturn(-0.9925);
        Mockito.when(cosine.of(Mockito.eq(Math.E * 4))).thenReturn(-0.12214);
        Mockito.when(sinus.of(Mockito.eq(12.321))).thenReturn(-0.24291);
        Mockito.when(cosine.of(Mockito.eq(12.321))).thenReturn(0.970047);
        Mockito.when(cosine.of(Mockito.eq(0.0))).thenReturn(1.0);

        TrigonometricFunctions trigonometricFunctions = new TrigonometricFunctions(sinus, cosine);

        Assertions.assertAll(
                () -> Assertions.assertEquals(Double.NaN, reduce(trigonometricFunctions.cot(0), 1)),
                () -> Assertions.assertEquals(0, reduce(trigonometricFunctions.cot(Math.PI / 2), 1)),
                () -> Assertions.assertEquals(-0.4783, reduce(trigonometricFunctions.cot(8.30012), 4)),
                () -> Assertions.assertEquals(1.9207, reduce(trigonometricFunctions.cot(-74.9182), 4)),
                () -> Assertions.assertEquals(0.1231, reduce(trigonometricFunctions.cot(Math.E * 4), 4)),
                () -> Assertions.assertEquals(-3.9934, reduce(trigonometricFunctions.cot(12.321), 4))
        );
    }

    @Test
    public void testIllegalArgumentsTrigonometricFunctionsModule() {
        Sinus sinus = Mockito.mock(Sinus.class, Mockito.withSettings().useConstructor(-0.01));
        Cosine cosine = new Cosine(sinus);
        Mockito.when(sinus.of(Mockito.anyDouble())).thenThrow(new IllegalArgumentException());
        TrigonometricFunctions trigonometricFunctions = new TrigonometricFunctions(sinus, cosine);

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
