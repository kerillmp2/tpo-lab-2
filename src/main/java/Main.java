public class Main {
    public static void main(String[] args) {
        FunctionSystem functionSystem = FunctionSystem.withAccuracy(0.000001);
        double x = -Math.PI * 3;
        for(double i = x; i <= 3 * Math.PI; i += 0.01) {
            functionSystem.result(i);
        }
        Writer.close();
    }
}
