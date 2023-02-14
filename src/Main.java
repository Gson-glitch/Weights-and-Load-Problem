import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Double> arr = new ArrayList<>();
        arr.add(1.0);
        arr.add(2.0);
        arr.add(3.0);
        arr.add(4.0);
        arr.add(10.0);

        int iter = 1000;  // The number of iterations

        RandomMutationHillClimbing RMHC = new RandomMutationHillClimbing();

        System.out.println("TEST 1 - Using a predefined ArrayList");
        RMHC.HillClimbing(arr, iter);
        RMHC.display();
        System.out.println("\n");

        System.out.println("TEST 2 - Reading input from a file");
        ReadCSV CSV = new ReadCSV();
        RMHC.HillClimbing(CSV.read(), iter);
        RMHC.display();
        System.out.println("\n");

        System.out.println("TEST 3 - Using a larger dataset (100 weights ranging from 10.00kg – 30.00kg)");
        ArrayList<Double> largerDataset = new ArrayList<>();
        ArrayList<Double> results = new ArrayList<>();

        iter = 10000;
        int datasetSize = 100;
        float min = 10.00f;
        float max = 30.00f;

        for (int i=0; i<datasetSize; i++) {
            largerDataset.add(ThreadLocalRandom.current().nextDouble(min, max));
        }

        int numberOfExperiments = 10;
        for (int i=0; i<numberOfExperiments; i++) {
            System.out.println(MessageFormat.format("Final Fitness Input: {0}\t Optimum Input: {1}",RMHC.HillClimbing(largerDataset, iter).values(), RMHC.HillClimbing(largerDataset, iter).keySet()));
        }
    }
}
