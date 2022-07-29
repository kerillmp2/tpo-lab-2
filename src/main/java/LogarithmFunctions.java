public class LogarithmFunctions {

    private final NaturalLogarithm naturalLogarithm;

    public LogarithmFunctions(NaturalLogarithm naturalLogarithm) {
        this.naturalLogarithm = naturalLogarithm;
    }

    public static LogarithmFunctions withAccuracy(double accuracy) {
        return new LogarithmFunctions(new NaturalLogarithm(accuracy));
    }

    public double ln(double x) {
        return naturalLogarithm.of(x);
    }

    public double log3(double x) {
        double lnX = naturalLogarithm.of(x);
        double ln3 = naturalLogarithm.of(3);
        double result = (lnX / ln3);
        Writer.write("LogarithmFunctions", x, result);
        return result;
    }
}
