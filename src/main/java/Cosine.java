public class Cosine {

    private final Sinus sinus;

    public Cosine(Sinus sinus) {
        this.sinus = sinus;
    }

    public static Cosine withAccuracy(double accuracy) {
        return new Cosine(new Sinus(accuracy));
    }

    public double of(double x) {
        double cos = Math.sqrt(1 - Math.pow(sinus.of(x), 2));
        double newX = Math.abs(x) % (2 * Math.PI);
        double result = ( newX <= (Math.PI / 2) || newX >= (Math.PI * 3/2)  ) ? cos : -cos;
        Writer.write("Cosine", x, result);
        return result;
    }
}
