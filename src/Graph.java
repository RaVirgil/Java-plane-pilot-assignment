import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graph {
    private int nrPlanes;
    private int nrCrews;
    private int[][] matrix;

    public Graph() {
    }

    public void readFromFile() throws FileNotFoundException {
        Scanner file = new Scanner(new File("graph.txt"));

        nrPlanes = file.nextInt();
        nrCrews = file.nextInt();
        matrix = new int[nrPlanes][nrCrews];

        for (int i = 0; i < nrPlanes; i++)
            for (int j = 0; j < nrCrews; j++)
                matrix[i][j] = file.nextInt();
    }

    public void solveTask() {

        int[] result = new int[nrCrews];

        for (int i = 0; i < nrCrews; i++)
            result[i] = -1;

        for (int i = 0; i < nrPlanes; i++) {
            boolean[] visited = new boolean[nrCrews];

            assignPlane(i, visited, result);
        }

        for (int i = 0; i < nrCrews; i++)
            System.out.print("\nCrew " + (i+1) + " is assigned to plane " + (result[i] + 1));
        System.out.println();

    }

    private boolean assignPlane(int plane, boolean[] visited, int[] result) {

        for (int crew = 0; crew < nrCrews; crew++) {

            if (matrix[plane][crew] == 1 && !visited[crew]) {
                visited[crew] = true;

                if (result[crew] == -1 || assignPlane(result[crew], visited, result)) {
                    result[crew] = plane;
                    return true;
                }
            }
        }
        return false;
    }

}
