import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadCSV {
    public ArrayList<Double> read() throws IOException {
        ArrayList<Double> weights = new ArrayList<>();

        // Reading in the csv file
        String filePath = System.getProperty("user.dir") + "/src/";
        String fileName= "bricks.csv";
        File file= new File(filePath + fileName);

        try (BufferedReader r = new BufferedReader(new FileReader(file))) {
            String line = r.readLine();
            while (line != null) {
                weights.add(Double.valueOf(line));
                line = r.readLine();
            }
        }
    return weights;
    }
}
