import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
            Graph graph=new Graph();
            graph.readFromFile();
            graph.solveTask();
    }
}
