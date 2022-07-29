public class NaturalLogarithm extends Main {

    private final double accuracy;

    public NaturalLogarithm(double accuracy) {
        this.accuracy = accuracy;
    }

    public double of(double x) throws IllegalArgumentException {
        if (accuracy <= 0) {
            throw new IllegalArgumentException();
        }
        if (x <= 0) {
            return Double.NaN;
        }
        double currentSum = 0;
        double lastSum = accuracy;
        double nextElement;
        int denominator = 1;
        while (Math.abs(currentSum - lastSum) >= accuracy / 10) {
            nextElement = (Math.pow(((x - 1) / (x + 1)), denominator) / denominator);
            lastSum = currentSum;
            currentSum += nextElement;
            denominator += 2;
        }
        currentSum *= 2;
        Writer.write("NaturalLogarithm", x, currentSum);
        return currentSum;
    }
}
