public class Sinus {

    private final double accuracy;

    public Sinus(double accuracy) {
        this.accuracy = accuracy;
    }

    public double of(double x) throws IllegalArgumentException {
        if (accuracy <= 0) {
            throw new IllegalArgumentException();
        }
        if (x < 0) {
            x = -x + Math.PI;
        }
        x = x % (Math.PI * 2);
        double result = 0;
        double lastElement = -accuracy;
        double nextElement = x;
        int factorialCounter = 1;
        int sign = 1;
        while (Math.abs(nextElement - lastElement) >= accuracy) {
            lastElement = nextElement;
            result += sign * lastElement;
            nextElement = lastElement * x * x / ((factorialCounter + 1) * (factorialCounter + 2));
            factorialCounter += 2;
            sign = -sign;
        }
        result = Math.min(1, result);
        Writer.write("Sinus", x, result);
        return result;
    }
}
