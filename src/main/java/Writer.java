import java.io.*;

public class Writer {

    private static FileWriter fileWriter;
    private static BufferedReader reader;

    static {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            fileWriter = new FileWriter("src/main/resources/output.csv");
        }catch (IOException e) {
            System.out.println("Такого файла не существует!");
        }
    }

    public static void write(String from, double x, double result) {
        try {
            if(from.equals("TrigonometricFunctions/tan")) {
                fileWriter.write(x + ", " + result + "\n");
                fileWriter.flush();
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    public static void close() {
        try {
            reader.close();
            fileWriter.close();
        }catch (IOException e) {
            System.out.println("Can't close streams");
        }
    }
}