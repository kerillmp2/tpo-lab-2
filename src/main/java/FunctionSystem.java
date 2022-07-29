public class FunctionSystem {

    private final LogarithmFunctions logarithmFunctions;
    private final TrigonometricFunctions trigonometricFunctions;

    public FunctionSystem(LogarithmFunctions logarithmFunctions, TrigonometricFunctions trigonometricFunctions) {
        this.logarithmFunctions = logarithmFunctions;
        this.trigonometricFunctions = trigonometricFunctions;
    }

    public static FunctionSystem withAccuracy(double accuracy) {
        return new FunctionSystem(LogarithmFunctions.withAccuracy(accuracy), TrigonometricFunctions.withAccuracy(accuracy));
    }

    public double result(double x) {
        double result = x <= 0 ? resultOfNegativeOrZero(x) : resultOfPositive(x);
        Writer.write("FunctionSystem", x, result);
        return result;
    }

    private double resultOfPositive(double x) {
        return pow((((pow(ln(x), 2) * (ln(x) * log_3(x))) + ln(x)) + ((log_3(x) - ln(x)) * ln(x))), 3);
    }

    private double resultOfNegativeOrZero(double x) {
        return (((pow((pow(((pow(cos(x), 3) - csc(x) - sec(x)) / cot(x)), 2) / cos(x)), 3) - (sec(x) / ((pow(cos(x), 3) - tan(x)) / csc(x)))) - cos(x)) / pow((cos(x) * sec(x)), 3)) * ((tan(x) - sec(x)) * pow((sec(x) - csc(x)), 2)) + pow(tan(x), 3);
    }

    private double cos(double x) {
        return trigonometricFunctions.cos(x);
    }

    private double csc(double x) {
        return trigonometricFunctions.csc(x);
    }

    private double sec(double x) {
        return trigonometricFunctions.sec(x);
    }

    private double cot(double x) {
        return trigonometricFunctions.cot(x);
    }

    private double tan(double x) {
        return trigonometricFunctions.tan(x);
    }

    private double ln(double x) {
        return logarithmFunctions.ln(x);
    }

    private double log_3(double x) {
        return logarithmFunctions.log3(x);
    }

    private double pow(double x, int n) {
        return Math.pow(x, n);
    }
}

/*
x <= 0 : (((((((((((cos(x) ^ 3) - csc(x) - sec(x)) / cot(x)) ^ 2) / cos(x)) ^ 3) - (sec(x) / (((cos(x) ^ 3) - tan(x)) / csc(x)))) - cos(x)) / ((cos(x) * sec(x)) ^ 3)) * ((tan(x) - sec(x)) * ((sec(x) - csc(x)) ^ 2))) + (tan(x) ^ 3))
x > 0 : (((((ln(x) ^ 2) * (ln(x) * log_3(x))) + ln(x)) + ((log_3(x) - ln(x)) * ln(x))) ^ 3)
 */