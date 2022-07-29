public class TrigonometricFunctions {

    private final Sinus sinus;
    private final Cosine cosine;

    public TrigonometricFunctions(Sinus sinus, Cosine cosine) {
        this.sinus = sinus;
        this.cosine = cosine;
    }

    public static TrigonometricFunctions withAccuracy(double accuracy) {
        return new TrigonometricFunctions(new Sinus(accuracy), Cosine.withAccuracy(accuracy));
    }

    public double sin(double x) {
        return sinus.of(x);
    }

    public double cos(double x) {
        return cosine.of(x);
    }

    public double sec(double x) {
        double result;
        if (Math.abs(x) % Math.PI == (Math.PI / 2)) {
            result = Double.NaN;
        } else {
            double cosX = cos(x);
            result = (1 / cosX);
        }
        Writer.write("TrigonometricFunctions/sec", x, result);
        return result;
    }

    public double csc(double x) {
        double result;
        if (Math.abs(x) % Math.PI == 0) {
            result = Double.NaN;
        } else {
            double sinX = sin(x);
            result = (1 / sinX);
        }
        Writer.write("TrigonometricFunctions/csc", x, result);
        return result;
    }

    public double tan(double x) {
        double result;
        if (Math.abs(x) % Math.PI == (Math.PI / 2)) {
            result = Double.NaN;
        } else {
            double sinX = sin(x);
            double cosX = cos(x);
            result = (sinX / cosX);
        }
        Writer.write("TrigonometricFunctions/tan", x, result);
        return result;
    }

    public double cot(double x) {
        double result;
        if (Math.abs(x) % Math.PI == 0) {
            return Double.NaN;
        } else {
            double sinX = sin(x);
            double cosX = cos(x);
            result = (cosX / sinX);
        }
        Writer.write("TrigonometricFunctions/cot", x, result);
        return result;
    }
}
